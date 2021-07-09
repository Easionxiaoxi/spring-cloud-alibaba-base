package com.xyz.base.common.component.dubbo;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;

/**
 * Dubbo泛化调用Builder模式工厂
 */
public class DubboRemoteServiceBuilderFactory {

    private static ApplicationConfig applicationConfig;
    private static RegistryConfig registryConfig;

    public void setApplicationConfig(ApplicationConfig applicationConfig) {
        DubboRemoteServiceBuilderFactory.applicationConfig = applicationConfig;
    }

    public void setRegistryConfig(RegistryConfig registryConfig) {
        DubboRemoteServiceBuilderFactory.registryConfig = registryConfig;
    }

    public static DubboRemoteServiceBuilder createBuilder() {
        return new DubboRemoteServiceBuilder(applicationConfig, registryConfig);
    }
}
