package com.yc.piclib.web.controllers;

import com.yc.piclib.future.PiclibFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/piclib")
public class PicController {

    private static Logger logger = LoggerFactory.getLogger(PicController.class.getName());

    @Autowired
    private PiclibFuture piclibFuture;

    @RequestMapping(value = "/{id}")
    public CompletableFuture<String> findById(@PathVariable Integer id) {
        return piclibFuture.findById(id);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public CompletableFuture<String> findAll(Integer page, Integer pageSize, String description) {
        return piclibFuture.findPage(page, pageSize, description);
    }


}
