package com.yc.picLib.dao.impl;

import com.yc.picLib.dao.MisBaseMapper;
import com.yc.picLib.entity.Pic;
import org.apache.ibatis.annotations.Mapper;


@Mapper  //具体操作某张表的mapper
public interface PicMapper extends MisBaseMapper<Pic> {
}
