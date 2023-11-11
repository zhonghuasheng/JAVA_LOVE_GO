import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JedisClusterTest {

    @Test
    public void get() {
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add(new HostAndPort("myserver.com", 7000));
        nodes.add(new HostAndPort("myserver.com", 7001));
        nodes.add(new HostAndPort("myserver.com", 7002));
        nodes.add(new HostAndPort("myserver.com", 7003));
        nodes.add(new HostAndPort("myserver.com", 7004));
        nodes.add(new HostAndPort("myserver.com", 7005));
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(10);
        config.setTestOnBorrow(true);
        // timeout和maxAttempts要设置的大些，设置小了容易获取不到，应该是JedisCluster效率的问题
        JedisCluster jedisCluster = new JedisCluster(nodes, 300, 30,
                config);
        String value = jedisCluster.get("hello");
        System.out.println(value);
        Assert.assertEquals("world", value);
    }

    @Test
    public void set() {
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add(new HostAndPort("myserver.com", 7000));
        nodes.add(new HostAndPort("myserver.com", 7001));
        nodes.add(new HostAndPort("myserver.com", 7002));
        nodes.add(new HostAndPort("myserver.com", 7003));
        nodes.add(new HostAndPort("myserver.com", 7004));
        nodes.add(new HostAndPort("myserver.com", 7005));
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(10);
        config.setTestOnBorrow(true);
        JedisCluster jedisCluster = new JedisCluster(nodes, 300, 30,
                config);
        String value = jedisCluster.set("k11", "value11");
    }

    @Test
    public void singleMode() {
        Jedis jedis = new Jedis("myserver.com", 7002);
        System.out.println(jedis.get("test"));
    }
}
