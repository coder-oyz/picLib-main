package com.yc.picLib.controller;


import com.yc.picLib.domain.PicDomain;
import com.yc.picLib.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("pic")
public class PicController {
    @Autowired
    private PicService picService;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public PicDomain getPic(@PathVariable("id")Integer id){
        show();
        return picService.getPic(id);
    }

    @GetMapping("/findAll")
    public List<PicDomain> findAll(){
        show();
        return picService.list();
    }
    @RequestMapping("/discover")
    public Object discover(){
        System.out.println( this.discoveryClient.description() );
        System.out.println(  ((EurekaDiscoveryClient)this.discoveryClient).getServices());
        //再通过Service获取EurekaServiceInstance
        return this.discoveryClient;
    }

    private void show(){
        System.out.println( this.discoveryClient.description() );

        //EurekaDiscoveryClient
        EurekaDiscoveryClient edc=(EurekaDiscoveryClient)this.discoveryClient;
        // 服务器上有有很多服务
        List<String> servicesName=edc.getServices();
        for( String sn:servicesName ) {
            System.out.println("服务名:" + sn);
            List<ServiceInstance> instances = edc.getInstances(sn);
            for (ServiceInstance si : instances) {
                System.out.println(si.getScheme() + " " + si.getHost() + " " + si.getPort() + " " + si.getUri());
            }
        }
    }
}
