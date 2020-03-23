import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

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
    }
}
