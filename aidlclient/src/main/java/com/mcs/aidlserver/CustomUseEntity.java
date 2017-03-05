package com.mcs.aidlserver;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author mochangsheng
 * @version 1.0
 * @title 类的名称
 * @description 该类的主要功能描述
 * @created 2017/3/5 0005
 * @changeRecord [修改记录] <br/>
 */
public class CustomUseEntity implements Parcelable {

    public String mName;

    public CustomUseEntity(String name) {
        mName = name;
    }

    protected CustomUseEntity(Parcel in) {
        mName = in.readString();
    }


    ///序列化
    public static final Creator<CustomUseEntity> CREATOR = new Creator<CustomUseEntity>() {
        @Override
        public CustomUseEntity createFromParcel(Parcel in) {
            return new CustomUseEntity(in);
        }

        @Override
        public CustomUseEntity[] newArray(int size) {
            return new CustomUseEntity[size];
        }
    };

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
    }

    public void readFromParcel(Parcel dest) {
        //注意，此处的读值顺序应当是和writeToParcel()方法中一致的
        mName = dest.readString();
    }
}
