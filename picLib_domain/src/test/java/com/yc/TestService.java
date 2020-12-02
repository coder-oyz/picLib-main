package com.yc;

import com.yc.picLib.domain.PageDomain;
import com.yc.picLib.domain.PicDomain;
import com.yc.picLib.service.PicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DaoConfiguration.class})
public class TestService {

    private static final Logger logger = Logger.getLogger(TestService.class.getName());

    @Autowired
    private PicService picService;

    @Test
    public void testList() {
        logger.info("调用PicService.list");
        List<PicDomain> list = picService.list();
        System.out.println(list);
    }

    @Test
    public void testListByPage() {
        PicDomain picDomain = new PicDomain(1, "abc", "good");
        picDomain.setPage(2);
        logger.info("------------调用PicService.listByPage");
        PageDomain<PicDomain> list = picService.listByPage(picDomain);
        System.out.println(list);
    }

    @Test
    public void testFindOne(){
        PicDomain pic=picService.findOne(1);
        logger.info("------------调用PicService.findOne");
        System.out.println(pic);
    }

    @Test
    public void testSave() {
        Random r = new Random();
        PicDomain picDomain = new PicDomain(2, "new pic" + r.nextInt(9999), "very very good");
        picService.save(picDomain);
        logger.info("新增的产品编号:" + picDomain.getId());
        //断言.
        Assert.notNull(picDomain.getId(), "not insert");
    }

    @Test
    public void testDelete() {
        picService.delete(1);
    }







}