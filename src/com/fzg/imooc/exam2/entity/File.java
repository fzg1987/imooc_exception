package com.fzg.imooc.exam2.entity;

import java.io.Serializable;

/*
 * 文件实体类
 */
public class File implements Serializable {
    private static final long serialVersionUid = -404352805766L;
    private int fid;

    public String getFname() {
        return fname;
    }

    public byte[] getFcontent() {
        return fcontent;
    }

    private String fname;
    private byte[] fcontent;

    public File(){

    }
    public File(String fname, byte[] fcontent){
        super();
        this.fname = fname;
        this.fcontent = fcontent;
    }
}
