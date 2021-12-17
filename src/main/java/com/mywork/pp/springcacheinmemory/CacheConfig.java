package com.mywork.pp.springcacheinmemory;

import javax.management.timer.Timer;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import net.sf.ehcache.config.CacheConfiguration;

@EnableCaching
@EnableScheduling // remember this so your `@Scheduled` get picked up
@Configuration
public class CacheConfig extends CachingConfigurerSupport{

/*	 @Scheduled(fixedRate = Timer.ONE_MINUTE)
	  @CacheEvict(
	      value = {"student"},
	      allEntries = true)
	  public void clearEvents() {
	    System.out.println("Cleared Cache");
	  }*/
	 
	 @Bean
	 public net.sf.ehcache.CacheManager ehCacheMagaer() {
		 CacheConfiguration cacheConfig = new CacheConfiguration();
		 cacheConfig.setName("student");
		 cacheConfig.internalSetTimeToLive(10);
		 cacheConfig.setMaxEntriesLocalHeap(3);
		 cacheConfig.setMemoryStoreEvictionPolicy("LRU");
		 
		 net.sf.ehcache.config.Configuration config = new  net.sf.ehcache.config.Configuration();
		 config.addCache(cacheConfig);
		 
		 return net.sf.ehcache.CacheManager.newInstance(config);
	 }
	 
	 	@Bean
	 	@Override
	    public CacheManager cacheManager() {
	        return new EhCacheCacheManager(ehCacheMagaer());
	    }
}
