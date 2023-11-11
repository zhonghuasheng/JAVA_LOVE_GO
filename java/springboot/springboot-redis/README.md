### SpringBoot + Jedis + 1主2从3服务 实现Redis的高可用
> 配置文件
```xml
# redis-master-config
port 7000
daemonize yes
protected-mode no
pidfile "/var/run/redis-7000.pid"
logfile "7000.log"
dir "/usr/local/redis/data"
replica-read-only no
```
```xml
# redis-slave-config
port 7001 # 第二个端口7002
daemonize yes
protected-mode no
pidfile "/var/run/redis-7001.pid"
logfile "7001.log"
dir "/usr/local/redis/data"
replica-read-only no
slaveof x.x.x.x 7002 #publicip
```
```xml
# redis-sentinel-config
port 26379 #其他端口26780 26781
daemonize yes
protected-mode no
dir "/usr/local/redis/data"
logfile "26379.log"
sentinel monitor mymaster x.x.x.x 7000 2
sentinel down-after-milliseconds mymaster 30000
sentinel parallel-syncs mymaster 1
sentinel failover-timeout mymaster 180000
```
> Java代码
```java
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
    sentinels.add(new HostAndPort("x.x.x.x", 26379).toString());
    sentinels.add(new HostAndPort("x.x.x.x", 26380).toString());
    sentinels.add(new HostAndPort("x.x.x.x", 26381).toString());
    JedisSentinelPool pool = new JedisSentinelPool(
            "mymaster", sentinels, config, 10000);

    while (true) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            int index = new Random().nextInt(100000);
            String key = "k11:" + index;
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
```

> 执行步骤

测试场景：1主2从3监控模式，Client不停的从JedisSentinelPool中获取连接。运行本测试，然后kill掉master，此时监控长老们会重新选举新的master，程序
在不停的获取新的连接，当redis集群服务恢复之后程序继续执行。重新把之前的master启动回来之后，执行info replication显示是从服务器。