package com.mcs.aidlclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mcs.aidlserver.AidlService;
import com.mcs.aidlserver.CustomUseEntity;
import com.mcs.aidlserver.ICallBack;
import com.mcs.mframe.log.MLog;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    private AidlService mAidlService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.binder_button);
        mButton.setOnClickListener(mOnClickListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mAidlService != null) {
            try {
                mAidlService.unRegisterCallBack(mICallBack);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        if (mAidlService != null) {
            unbindService(mServiceConnection);
            mAidlService = null;
        }
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.binder_button:
                    Intent intent = new Intent();
                    intent.setAction("com.mcs.aidlserver.action.binder");
                    intent.setClassName("com.mcs.aidlserver","com.mcs.aidlserver.MyService");
                    bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
                    Toast.makeText(MainActivity.this, "to binder", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MLog.d("onServiceConnected");
            mAidlService = AidlService.Stub.asInterface(service);

            try {
                MLog.d(mAidlService.getName());
                Toast.makeText(MainActivity.this, mAidlService.getName(), Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            try {
                MLog.d(mAidlService.getCustomUseEntity().getName());
                Toast.makeText(MainActivity.this, mAidlService.getName(), Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            try {
                mAidlService.registerCallBack(mICallBack);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            CustomUseEntity custom = new CustomUseEntity("mo");
            try {
                mAidlService.setCustomUseEntity(custom);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            MLog.d("===last setCustomUseEntity   name==" + custom.getName());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            MLog.d("onServiceDisconnected");
            mAidlService = null;
        }
    };

    private ICallBack.Stub mICallBack = new ICallBack.Stub() {
        @Override
        public void onCallBack(final long tick, Bundle data) throws RemoteException {
            MLog.d(Thread.currentThread());
            MLog.d("tick==" + tick + "; bundle==" + data.get("StringKey"));
            mButton.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this,"onCallBack",Toast.LENGTH_SHORT).show();
                    mButton.setText(tick + "");
                }
            });
        }
    };
}
