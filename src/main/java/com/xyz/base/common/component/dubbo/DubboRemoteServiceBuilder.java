package com.xyz.base.common.component.dubbo;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;

/**
 * Dubbo调用Builder模式
 */
public class DubboRemoteServiceBuilder {
    private final ApplicationConfig applicationConfig;
    private final RegistryConfig registryConfig;
    private String interfaceName;
    private String methodName;
    private String[] paramTypes;
    private Object[] params;

    public DubboRemoteServiceBuilder(ApplicationConfig applicationConfig, RegistryConfig registryConfig) {
        this.applicationConfig = applicationConfig;
        this.registryConfig = registryConfig;
    }

    public DubboRemoteServiceBuilder withInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
        return this;
    }

    public DubboRemoteServiceBuilder withMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public DubboRemoteServiceBuilder withParamTypes(String... paramTypes) {
        this.paramTypes = paramTypes;
        return this;
    }

    public DubboRemoteServiceBuilder withParams(Object... params) {
        this.params = params;
        return this;
    }

    public DubboRemoteService build() {
        return new DubboRemoteService(applicationConfig, registryConfig, interfaceName, methodName, paramTypes, params);
    }
}
