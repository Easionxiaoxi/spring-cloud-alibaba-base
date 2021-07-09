package com.xyz.base.common.component.dubbo;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * Dubbo泛化调用接口实现
 */
public class DubboRemoteService implements RemoteService {
    /**
     * Dubbo应用配置
     */
    private ApplicationConfig applicationConfig;
    /**
     * Dubbo注册中心配置
     */
    private RegistryConfig registryConfig;
    /**
     * 泛化调用全限定接口名
     */
    private String interfaceName;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 参数类型
     */
    private String[] paramTypes;
    /**
     * 参数
     */
    private Object[] params;

    /**
     * 全参构造器
     */
    public DubboRemoteService(ApplicationConfig applicationConfig, RegistryConfig registryConfig, String interfaceName, String methodName, String[] paramTypes, Object[] params) {
        this.applicationConfig = applicationConfig;
        this.registryConfig = registryConfig;
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.params = params;
    }

    /**
     * 接口调用
     */
    @Override
    public Object invoke() {
        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(interfaceName);
        referenceConfig.setGeneric(true);
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(referenceConfig);
        return genericService.$invoke(methodName, paramTypes, params);
    }
}
