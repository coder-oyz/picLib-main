package com.yc.picLib.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yc.picLib.dao.impl.PicMapper;
import com.yc.picLib.domain.PageDomain;
import com.yc.picLib.domain.PicDomain;
import com.yc.picLib.entity.Pics;
import com.yc.picLib.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PicServiceImpl implements PicService {

    @Autowired(required = false)
    private PicMapper picMapper;

    @Transactional(readOnly = true)
    @Override
    public List<PicDomain> list() {
        List<Pics> list = picMapper.selectAll();
        //将实体类转为   domain
        List<PicDomain> r = new ArrayList<PicDomain>();
        for (Pics p : list) {   //  BeanUtils.copyBean(source, destination);
            PicDomain pd = new PicDomain(p.getId(), p.getPath(), p.getDescription());
            r.add(pd);
        }
        return r;
    }

    @Transactional(readOnly = true)
    @Override
    public PageDomain<PicDomain> listByPage(PicDomain picDomain) {
        PageHelper.startPage(picDomain.getPage(), picDomain.getPageSize());
        Example example = new Example(Pics.class);   //条件
        Example.Criteria c = example.createCriteria();
        if (CommonUtils.isNotNull(picDomain.getData())) {
            //条件创建

            c.andLike("description", "%" + picDomain.getData() + "%");
        }
        long total = picMapper.selectCountByExample(example);

        PageDomain<PicDomain> pageDomain = new PageDomain<PicDomain>();
        pageDomain.setTotal(total);
        pageDomain.setPage(picDomain.getPage());
        pageDomain.setPageSize(picDomain.getPageSize());

        //TODO: 分页条件

        c.andGreaterThanOrEqualTo("id", 1);
        example.setOrderByClause("id desc");

        PageInfo<Pics> pageInfo = new PageInfo<Pics>(picMapper.selectByExample(example));

        //List<Pic> list = picMapper.selectByExample(example);
        List<PicDomain> r = new ArrayList<PicDomain>();
        if (pageInfo.getList() != null) {
            for (Pics p : pageInfo.getList()) {
                PicDomain pd = new PicDomain(p.getId(), p.getPath(), p.getDescription());
                r.add(pd);
            }
        }
        pageDomain.setData(r);

        return pageDomain;
    }

    @Override
    public PicDomain getPic(int pid) {

        Pics p= picMapper.selectByPrimaryKey(pid);
        PicDomain pd = new PicDomain(p.getId(), p.getPath(), p.getDescription());
        return pd;
    }


}
