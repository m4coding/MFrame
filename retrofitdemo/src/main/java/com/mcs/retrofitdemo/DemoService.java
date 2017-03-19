package com.mcs.retrofitdemo;

import com.mcs.retrofitdemo.model.UserEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author mochangsheng
 * @version 1.0
 * @title 类的名称
 * @description 该类的主要功能描述
 * @created 2017/3/19 0019
 * @changeRecord [修改记录] <br/>
 */
public interface DemoService {

    @GET("{name}")
    Call<UserEntity> getName(@Path("name") String name);

}
