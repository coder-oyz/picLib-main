package com.yc.picLib.domain;

import lombok.Data;

@Data
public class PicDomain extends PageDomain {
    private Integer id;   //注意: 对应的数据表中的字段名叫 book_id
    private String path;
    private String description;

    /**
     * 一张图片的其它属于，通过程序获得.
     */
    private Long fileSize;
    private String extension;
    private String realPath;

    public PicDomain(Integer id, String path, String description) {
        this.id = id;
        this.path = path;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public String getExtension() {
        return extension;
    }

    public String getRealPath() {
        return realPath;
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

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setRealPath(String realPath) {
        this.realPath = realPath;
    }
}