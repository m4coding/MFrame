// AidlService.aidl
package com.mcs.aidlserver;
import com.mcs.aidlserver.CustomUseEntity;
import com.mcs.aidlserver.ICallBack;
// Declare any non-default types here with import statements

interface AidlService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
   /* void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);*/

    String getName();

    CustomUseEntity getCustomUseEntity();

    void setCustomUseEntity(inout CustomUseEntity customUseEntity);

    void registerCallBack(ICallBack callBack);

    void unRegisterCallBack(ICallBack callBack);
}
