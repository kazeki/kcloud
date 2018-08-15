package com.kzk.kcloud.controller;

import com.kzk.kcloud.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import com.kzk.kcloud.model.Module;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class ModuleController {

    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    RedisTemplate<String, String> redisTemplate;

	@RequestMapping(value="/module",method=RequestMethod.GET)
    @Cacheable(value = "moduleCache" , key = "'kcloud-system-module-all'")
    public Object getModuleList(){
	    return moduleRepository.findAllBy();
    }

    @RequestMapping(value="/module/{name}",method=RequestMethod.GET)
    @Cacheable(value = "moduleCache" , key = "#name")
    public Object getModuleByName(@PathVariable String name){
        return moduleRepository.findByName(name);
    }

    @RequestMapping(value="/module/clearAllCache",method=RequestMethod.GET)
    @CacheEvict(value = "moduleCache" , allEntries = true, beforeInvocation = true)
    public Object clearAllCache(){
        redisTemplate.boundListOps("action").expire(30, TimeUnit.SECONDS);
        redisTemplate.boundListOps("action").leftPush(new Date().toString());
        return redisTemplate.boundListOps("action").range(0,-1);
    }

    @RequestMapping(value="/module/clearCacheByName/{name}",method=RequestMethod.GET)
    @CacheEvict(value = "moduleCache" , key = "#name")
    public Object clearCacheByName(@PathVariable String name){
        return "OK";
    }

}
