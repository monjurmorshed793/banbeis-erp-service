/*
package bd.gov.banbeis.erp.configurations;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import javax.annotation.PreDestroy;
import java.util.Arrays;

@Configuration
//@EnableCaching
@Slf4j
@RequiredArgsConstructor
public class CacheConfiguration {

    private final Environment environment;

    @PreDestroy
    public void destroy(){
        log.info("Closing cache manager");
        Hazelcast.shutdownAll();
    }

    @Bean
    public CacheManager cacheManager(HazelcastInstance hazelcastInstance){
        log.debug("Setting HazelcastCacheManager");
        return new HazelcastCacheManager(hazelcastInstance);
    }

    @Bean
    public HazelcastInstance hazelcastInstance(){
        log.debug("Configuring Hazelcast");
        HazelcastInstance hazelcastInstance =
                Hazelcast
                        .getHazelcastInstanceByName("banbeiserp");
        if(hazelcastInstance != null){
            log.debug("Hazelcast already initialized");
            return hazelcastInstance;
        }

        Config config = new Config();
        config.setInstanceName("banbeiserp");
        config.getNetworkConfig().setPort(5701);
        config.getNetworkConfig().setPortAutoIncrement(true);

        // In development, remove multicast auto-configuration
        if(environment.acceptsProfiles(Profiles.of(BanbeisConstants.PROFILE_DEVELOPMENT))){
            System.setProperty("hazelcast.local.localAddress", "127.0.0.1");

            config.getNetworkConfig().getJoin().getAwsConfig().setEnabled(false);
            config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
            config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(false);
        }

        config.setManagementCenterConfig(new ManagementCenterConfig());
        config.addMapConfig(initializeDefaultMapConfig());
        config.addMapConfig(initializeDomainMapConfig());
        return Hazelcast.newHazelcastInstance(config);
    }

    private MapConfig initializeDefaultMapConfig(){
        MapConfig mapConfig = new MapConfig("default");
        mapConfig.setBackupCount(2);

        */
/*
        Valid values are:
        NONE (no eviction),
        LRU (Least Recently Used),
        LFU (Least Frequently Used).
        NONE is the default.
        *//*

        mapConfig.getEvictionConfig().setEvictionPolicy(EvictionPolicy.LRU);

                */
/*
        Maximum size of the map. When max size is reached,
        map is evicted based on the policy defined.
        Any integer between 0 and Integer.MAX_VALUE. 0 means
        Integer.MAX_VALUE. Default is 0.
        *//*

        mapConfig.getEvictionConfig().setMaxSizePolicy(MaxSizePolicy.USED_HEAP_SIZE);
        return mapConfig;
    }

    private MapConfig initializeDomainMapConfig(){
        MapConfig mapConfig = new MapConfig("bd.banbeis.erp.domains.*");
//        mapConfig.setTimeToLiveSeconds(Integer.parseInt(environment.getProperty("banbeis.cache.hazelcast.time-to-live-seconds")));
        mapConfig.setTimeToLiveSeconds(3600);

        return mapConfig;
    }
}
*/
