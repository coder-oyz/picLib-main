package com.yc.picLib.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;


@Data      //  lombok 注解，节省getter, setter
@Table(name = "pics")
public class Pics<main> {
    @Id  // JPA注解,指定此属性为表中的主键
    private Integer id;   //注意: 对应的数据表中的字段名叫 book_id
    private String path;
    private String description;

    public Integer getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void main(String[] args) {
        System.out.println(new Pics().getId());
    }
}