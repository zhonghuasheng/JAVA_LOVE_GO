import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class JedisConnectionTest {

    @Test
    public void testGet() {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(1024);
        config.setMaxIdle(200);
        config.setMaxWaitMillis(10000);
        config.setTestOnBorrow(true);
        config.setTestWhileIdle(true);
        config.setTestOnReturn(true);
        Set<String> sentinels = new HashSet<String>();
        sentinels.add(new HostAndPort("47.107.153.16", 26379).toString());
        sentinels.add(new HostAndPort("47.107.153.16", 26380).toString());
        sentinels.add(new HostAndPort("47.107.153.16", 26381).toString());
        JedisSentinelPool pool = new JedisSentinelPool(
                "mymaster", sentinels, config, 10000);
        Jedis jedis = pool.getResource();
        System.out.println(jedis.get("hello"));
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 测试场景：1主2从3监控模式，Client不停的从JedisSentinelPool中获取连接
     * 运行本测试，然后kill掉master，此时监控长老们会重新选举新的master，程序
     * 在不停的获取新的连接，当redis集群服务恢复之后程序继续执行。重新把之前的
     * master启动回来之后，执行info replication显示是从服务器。
     * # redis-master-config
     * port 7000
     * daemonize yes
     * protected-mode no
     * pidfile "/var/run/redis-7000.pid"
     * logfile "7000.log"
     * dir "/usr/local/redis/data"
     * replica-read-only no
     *
     * # redis-slave-config
     * port 7001 # 第二个端口7002
     * daemonize yes
     * protected-mode no
     * pidfile "/var/run/redis-7001.pid"
     * logfile "7001.log"
     * dir "/usr/local/redis/data"
     * replica-read-only no
     * slaveof x.x.x.x 7002 #publicip
     *
     * # redis-sentinel-config
     * port 26379 #26780 26781
     * daemonize yes
     * protected-mode no
     * dir "/usr/local/redis/data"
     * logfile "26379.log"
     * sentinel monitor mymaster x.x.x.x 7002 2
     * sentinel down-after-milliseconds mymaster 30000
     * sentinel parallel-syncs mymaster 1
     * sentinel failover-timeout mymaster 180000
     */
    @Test
    public void masterFatal() {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(1024);
        config.setMaxIdle(200);
        config.setMaxWaitMillis(10000);
        config.setTestOnBorrow(true);
        config.setTestWhileIdle(true);
        config.setTestOnReturn(true);
        Set<String> sentinels = new HashSet<String>();
        sentinels.add(new HostAndPort("47.107.153.16", 26379).toString());
        sentinels.add(new HostAndPort("47.107.153.16", 26380).toString());
        sentinels.add(new HostAndPort("47.107.153.16", 26381).toString());
        JedisSentinelPool pool = new JedisSentinelPool(
                "mymaster", sentinels, config, 10000);

        while (true) {
            Jedis jedis = null;
            try {
                jedis = pool.getResource();
                int index = new Random().nextInt(100000);
                String key = "k12:" + index;
                String value = "v:" + index;
                jedis.set(key, value);
                System.out.println(key + "    " + value);
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (jedis != null) {
                    jedis.close();
                }
            }
        }
    }
}
