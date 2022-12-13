package com.example.ribbon.Services.Imp;

import com.example.ribbon.Services.MyRibbonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyRibbonServiceImpl implements MyRibbonService {
    @Autowired
    private DiscoveryClient client;

    @Override
    public DiscoveryClient test() {

        List<String> services = client.getServices();
        System.out.println("发现的微服务群组：" + services);

        List<ServiceInstance> serviceInstances = client.getInstances("PROVIDER-SERVER");
        System.out.println("发现的微服务实例是：" + serviceInstances);
        System.out.println("======================================");
        for (ServiceInstance serviceInstance : serviceInstances) {
            System.out.println(
                    "主机: " + serviceInstance.getHost() + "\t" +
                            "\n端口号: " + serviceInstance.getPort() + "\t" +
                            "\n资源定为符: " + serviceInstance.getUri() + "\t" +
                            "\n微服务id: " + serviceInstance.getServiceId()
            );
        }
        System.out.println("======================================");

        return this.client;
    }
}
