package com.yc.picLib.service;

import com.yc.picLib.domain.PageDomain;
import com.yc.picLib.domain.PicDomain;

import java.util.List;

public interface PicService {

    public List<PicDomain> list();

    /**
     * 分页查找
     *
     * @param picDomain
     * @return
     */
    public PageDomain<PicDomain> listByPage(PicDomain picDomain);

    public PicDomain getPic(int pid);
}
