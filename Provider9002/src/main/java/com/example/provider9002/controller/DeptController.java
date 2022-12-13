package com.example.provider9002.controller;

import com.example.provider9002.pojo.Department;
import com.example.provider9002.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Department department){
        return deptService.addDept(department);
    };

    @GetMapping("/dept/get/{id}")
    public Department queryById(@PathVariable("id")Long id){
        return deptService.queryById(id);
    };

    @GetMapping("/dept/list")
    public List<Department> queryAll(){
        return deptService.queryAll();
    };

    //获注册到取eureka中心的所有微服务相关信息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> services = client.getServices();
        System.out.println("发现的微服务群组：" + services);

        List<ServiceInstance> serviceInstances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance serviceInstance : serviceInstances) {
            System.out.println(
                    "主机: " + serviceInstance.getHost() + "\t" +
                    "\n端口号: " + serviceInstance.getPort() + "\t" +
                    "\n资源定为符: " + serviceInstance.getUri() + "\t" +
                    "\n微服务id: " + serviceInstance.getServiceId()
                    );
        }
        return this.client;
    }

}
