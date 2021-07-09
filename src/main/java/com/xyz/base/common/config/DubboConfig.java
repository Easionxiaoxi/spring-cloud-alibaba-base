package com.xyz.base.common.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.xyz.base.common.component.DubboRemoteServiceBuilderFactory;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;

/**
 * dubbo配置
 */
@Configuration
public class DubboConfig {
    @Resource
    ApplicationConfig applicationConfig;
    @Resource
    NacosDiscoveryProperties nacosDiscoveryProperties;

    /**
     * dubbo配置nacos注册中心
     */
    @Bean
    @Primary
    RegistryConfig dubboRegistryConfig() {
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("nacos://" + nacosDiscoveryProperties.getServerAddr());
        return registry;
    }

    /**
     * dubbo泛化调用工厂
     */
    @Bean
    DubboRemoteServiceBuilderFactory remoteServiceFactory() {
        DubboRemoteServiceBuilderFactory factory = new DubboRemoteServiceBuilderFactory();
        factory.setApplicationConfig(applicationConfig);
        factory.setRegistryConfig(dubboRegistryConfig());
        return factory;
    }
}
