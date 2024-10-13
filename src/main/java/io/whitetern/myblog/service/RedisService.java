package io.whitetern.myblog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setValue(String key, String value, Duration duration) {
        redisTemplate.opsForValue().set(key, value, duration);
    }

    public void setHashValue(String key, Map<String, String> value) {
        redisTemplate.opsForHash().putAll(key, value);
    }

    public String getValue(String key) {
        ValueOperations<String, Object> values = redisTemplate.opsForValue();
        if (values.get(key) == null) {
            return "";
        }
        return String.valueOf(values.get(key));
    }

    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }

}
