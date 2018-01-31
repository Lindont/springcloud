package com.aos.cloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EurekaController {
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/eureka-instant")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("aos-micoo-movie", false);
        return instance.getHomePageUrl();
    }


    @RequestMapping("/instant-info")
    public String serviceInstantInfo() {
        List<ServiceInstance> list = discoveryClient.getInstances("aos-micoo-movie");
        if (list != null && list.size() > 0) {
            return "Host: " + list.get(0).getHost() + "  Port: " + list.get(0).getPort() + "  Uri: " + list.get(0).getUri() + "  ServiceId: " + list.get(0).getServiceId() + "  Metadata: " + list.get(0).getMetadata();
        }
        return null;
    }
}
