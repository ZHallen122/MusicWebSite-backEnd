package com.music.musicwebsitebackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig  extends CachingConfigurerSupport {


    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
        //默认的Key序列化器为: JdkSerializationRedisSerializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory( connectionFactory) ;
        return redisTemplate;
    }

//        @Value("${spring.redis.host}")
//        private String redisHost;
//
//        @Value("${spring.redis.port}")
//        private int redisPort;
//
//        @Bean
//        public LettuceConnectionFactory lettuceConnectionFactory() {
//            RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHost, redisPort);
//            // Uncomment and set the password if your Redis instance requires authentication
//            // redisStandaloneConfiguration.setPassword(RedisPassword.of("your_redis_password"));
//            return new LettuceConnectionFactory(redisStandaloneConfiguration);
//        }
//
//        @Bean
//        public RedisTemplate<String, Object> redisTemplate() {
//            RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//            redisTemplate.setConnectionFactory(lettuceConnectionFactory());
//            // Customize the RedisTemplate as needed
//            return redisTemplate;
//        }
//
//        @Bean
//        public StringRedisTemplate stringRedisTemplate() {
//            StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//            stringRedisTemplate.setConnectionFactory(lettuceConnectionFactory());
//            // Customize the StringRedisTemplate as needed
//            return stringRedisTemplate;
//        }
}
