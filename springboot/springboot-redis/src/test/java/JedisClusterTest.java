import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JedisClusterTest {

    @Test
    public void get() {
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add(new HostAndPort("47.107.153.16", 7000));
        nodes.add(new HostAndPort("47.107.153.16", 7001));
        nodes.add(new HostAndPort("47.107.153.16", 7002));
        nodes.add(new HostAndPort("47.107.153.16", 7003));
        nodes.add(new HostAndPort("47.107.153.16", 7004));
        nodes.add(new HostAndPort("47.107.153.16", 7005));
        JedisPoolConfig config = new JedisPoolConfig();
        JedisCluster jedisCluster = new JedisCluster(nodes, 30, 3, config);
        String value = jedisCluster.get("hello");
        System.out.println(value);
        Assert.assertEquals("word", value);
    }

    public void set() {

    }
}
