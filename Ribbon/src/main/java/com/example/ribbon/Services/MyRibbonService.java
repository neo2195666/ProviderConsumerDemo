package com.example.ribbon.Services;

import org.springframework.cloud.client.discovery.DiscoveryClient;

public interface MyRibbonService {
    public DiscoveryClient test();
}
