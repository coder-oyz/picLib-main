package com.yc.picLib.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data      //  lombok 注解，节省getter, setter
@Table(name = "pic")
public class Pic{
    @Id  // JPA注解,指定此属性为表中的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //使插入时自动生成的ID号会返回
    private Integer id;   //注意: 对应的数据表中的字段名叫 book_id
    private String path;
    private String description;


}