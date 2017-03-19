package com.mcs.retrofitdemo.model;

/**
 * @author mochangsheng
 * @version 1.0
 * @title 类的名称
 * @description 该类的主要功能描述
 * @created 2017/3/19 0019
 * @changeRecord [修改记录] <br/>
 */
public class UserEntity {

    private String mInfo;

    public UserEntity(String info) {
        mInfo = info;
    }

    public void setInfo(String info) {
        mInfo = info;
    }

    public String getInfo() {
        return mInfo;
    }
}
