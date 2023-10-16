package com.cantina.gateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@FeignClient(value = "cantina-service"//Name of conta-service application
        , path = "api/orders"
        //Pre-path for conta-service
        //,url = "${conta.service.url}"
        ,configuration = FeignConfiguration.class
)
public interface OrderServiceRequest
{
    @PostMapping
    Object save(@RequestBody Object requestBody);

    @GetMapping
    List<Object> findByAll();

    @PutMapping("/{id}")
    Object update(@PathVariable("id") Long id, @RequestBody Object requestBody) throws IOException ;

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id) throws IOException ;

    @PostMapping("/upload/{type}")
    void uploadCsv() throws IOException ;
}
