package com.yc.picLib.controller;

import com.yc.picLib.domain.PicDomain;
import com.yc.picLib.service.PicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("consumer")
public class ConsumerBookController {
    @Resource
    private PicService picService;

    @Resource
    private LoadBalancerClient loadBalancerClient;   //因为ribbon是客户端的负载均衡，所以它可以在客户端记录访问的日志



    private static Logger log= LoggerFactory.getLogger(ConsumerBookController.class);

   /* @Autowired
    private HttpHeaders httpHeaders;
*/

    @GetMapping("/{id}")
    public PicDomain getPic(@PathVariable("id") Integer id){
        return picService.findOne(id);
    }
    @GetMapping("/findAll")
    public List<PicDomain> findAll( ){
        return picService.list();
    }





}
