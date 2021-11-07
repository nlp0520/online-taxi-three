package com.mashibing.apipassenger;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.netflix.servo.monitor.Timer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Auther:niulipeng
 * @Date:2021/11/4
 * @Description:com.mashibing.apipassenger
 * @Version:1.0
 */
public class GuvaTest {

    LoadingCache cache = CacheBuilder.newBuilder()
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .build(new CacheLoader<Object, Object>() {

                @Override
                public Object load(Object key) throws Exception {
                    return "load";
                }
            });

    @PostMapping("/testSet/{id}")
    public String testSet(@PathVariable("id") String id){
        cache.put(id,"set");
        return "success";
    }

    @PostMapping("/testSet/{id}")
    public String testGet(@PathVariable("id") String id){
        String id1 = null;
        try {
            id1 = (String) cache.get("id");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return id1;
    }
}
