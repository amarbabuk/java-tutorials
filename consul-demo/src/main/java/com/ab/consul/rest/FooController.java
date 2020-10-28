package com.ab.consul.rest;

/*import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;
import java.net.URI;
import java.util.Optional;

@RequestMapping("rest/foo")
@RestController
public class FooController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${spring.application.name}")
    private String serviceId;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/discoveryClient")
    public String discoveryPing() throws RestClientException, ServiceUnavailableException {
        URI service = serviceUrl().map(s -> s.resolve("/ping"))
                .orElseThrow(ServiceUnavailableException::new);
        return restTemplate.getForEntity(service, String.class)
                .getBody();
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/my-health-check")
    public ResponseEntity<String> myCustomCheck() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public Optional<URI> serviceUrl() {
        return discoveryClient.getInstances(serviceId)
                .stream()
                .findFirst()
                .map(si -> si.getUri());
    }
}
