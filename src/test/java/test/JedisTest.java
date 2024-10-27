package test;

import com.JedisConnectFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    private Jedis jedis;
    @BeforeEach
    void setUp(){
        jedis = JedisConnectFactory.getJedis();
        jedis.auth("Lgd");
        jedis.select(0);
    }
    @Test
    void testString(){
        String result = jedis.set("name","huge");
        System.out.println(result);
        String name = jedis.get("name");
        System.out.println(name);
    }
    @AfterEach
    void tearDown(){
        if (jedis!=null){
            jedis.close();
        }
    }
}
