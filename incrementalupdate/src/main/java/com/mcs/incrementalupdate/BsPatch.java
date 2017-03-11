package com.mcs.incrementalupdate;

import java.security.MessageDigest;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/3/11
 * @changeRecord [修改记录] <br/>
 */

public class BsPatch {

    static {
        //指定库名字就可以，不用添加lib
        System.loadLibrary("bspatch");
    }

    public static native void doPatch(String oldPath, String newPath, String patchPath);
}
