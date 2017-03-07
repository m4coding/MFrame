package com.mcs.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.mcs.mframe.log.MLog;

/**
 * @author mochangsheng
 * @version 1.0
 * @title 类的名称
 * @description 该类的主要功能描述
 * @created 2017/3/5 0005
 * @changeRecord [修改记录] <br/>
 */
public class MyService extends Service {

    public static final String TAG = MyService.class.getSimpleName();
    private static final int MSG = 1;
    private static final int MSG_DELAY = 2000;
    private RemoteCallbackList<ICallBack> mRemoteCallbackList = new RemoteCallbackList<>();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mHandler.sendEmptyMessageDelayed(MSG, MSG_DELAY);
        return new MyBinder();
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case MSG:
                    int size = mRemoteCallbackList.beginBroadcast();
                    for (int i = 0; i < size; i++) {
                        long time = System.currentTimeMillis();
                        Bundle bundle = new Bundle();
                        bundle.putString("StringKey","key==" + time);
                        try {
                            mRemoteCallbackList.getBroadcastItem(i).onCallBack(time, bundle);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                    mRemoteCallbackList.finishBroadcast();
                    sendEmptyMessageDelayed(MSG, MSG_DELAY);
                    break;
                default:
                    break;
            }
        }
    };

    private class MyBinder extends AidlService.Stub {

        @Override
        public String getName() throws RemoteException {
            return TAG;
        }

        @Override
        public CustomUseEntity getCustomUseEntity() throws RemoteException {
            CustomUseEntity customUseEntity = new CustomUseEntity(TAG  + " CustomUseEntity");
            return customUseEntity;
        }

        @Override
        public void setCustomUseEntity(CustomUseEntity customUseEntity) throws RemoteException {
            MLog.d("setCustomUseEntity name==" + customUseEntity.getName());

            customUseEntity.setName("mochangsheng");
        }

        @Override
        public void registerCallBack(ICallBack callBack) throws RemoteException {
            mRemoteCallbackList.register(callBack);
        }

        @Override
        public void unRegisterCallBack(ICallBack callBack) throws RemoteException {
            mRemoteCallbackList.unregister(callBack);
        }
    }
}
