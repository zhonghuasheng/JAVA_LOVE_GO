import com.zhonghuasheng.springboot.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringBootRedisTemplateTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void stringRedisTemplateTest() {
        System.out.println(stringRedisTemplate);
        stringRedisTemplate.opsForValue().set("db-type", "mongodb");
        System.out.println(stringRedisTemplate.opsForValue().get("db-type"));
        stringRedisTemplate.opsForValue().setIfAbsent("forward", "1", 24, TimeUnit.HOURS);
        for (int i = 0; i < 10; i++) {
            stringRedisTemplate.opsForValue().increment("forward", 1);
            System.out.println(stringRedisTemplate.opsForValue().get("forward"));
        }
    }
}
