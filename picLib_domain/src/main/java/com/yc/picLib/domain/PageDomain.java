package com.yc.picLib.domain;

import lombok.Data;

import java.util.List;

@Data
public class PageDomain<T> {
    private Integer page = 0;   //当前第几页
    private Integer pageSize = 2;  //每页多少条
    private Long total = 0L;  //总记录数

    private List<T> data;   //当前查询出来的数据集

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public List<T> getData() {
        return data;
    }
}