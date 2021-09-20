package am.adrian.microservices_example.user_management.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/service")
@CrossOrigin(origins = "*")
public class ServiceController {

    private final DiscoveryClient discoveryClient;

    @GetMapping("/findAll")
    public List<String> findAll() {
        return discoveryClient.getServices();
    }

    @GetMapping("/findByName/{serviceName}")
    public List<ServiceInstance> findInstancesByServiceName(@PathVariable String serviceName) {
        return discoveryClient.getInstances(serviceName);
    }
}
