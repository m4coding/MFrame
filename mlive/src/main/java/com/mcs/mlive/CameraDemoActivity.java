package com.mcs.mlive;

import android.Manifest;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mcs.mframe.log.MLog;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.io.IOException;
import java.util.List;

import rx.functions.Action1;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/4/6
 * @changeRecord [修改记录] <br/>
 */

public class CameraDemoActivity extends AppCompatActivity {

    private SurfaceView mSurfaceView;
    private Button mSwitchButton;
    private Camera mCamera;
    private int mSwitchId = 1;//1 前置，0 后置

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_demo);

        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            RxPermissions rxPermissions = new RxPermissions(this);
            rxPermissions
                    .request(Manifest.permission.CAMERA)
                    .subscribe(new Action1<Boolean>() {
                        @Override
                        public void call(Boolean aBoolean) {
                            if (aBoolean) {
                                initCamera();
                            } else {
                                Toast.makeText(CameraDemoActivity.this, "not Camera Permissions",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        } else {
            initCamera();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        releaseCamera();
    }

    private void initView() {
        mSurfaceView = (SurfaceView) findViewById(R.id.surface_view_camera);
        mSwitchButton = (Button) findViewById(R.id.switch_camera);

        mSurfaceView.getHolder().addCallback(mCallback);
        mSwitchButton.setOnClickListener(mOnClickListener);
    }

    //Android中默认的预览方向是：横屏，旋转度是：0
    private void initCamera() {

        try {

            mCamera = Camera.open(mSwitchId);

            /*int width = 720;
            int height = 480;*/

            Camera.Parameters parameters = mCamera.getParameters();
            parameters.setPreviewFormat(ImageFormat.NV21);
            //设置预览方向
            mCamera.setDisplayOrientation(90);
            //设置拍照之后图片方向
            //parameters.setRotation(90);

            //获取摄像头支持的数据格式
            List<Integer> list = parameters.getSupportedPreviewFormats();
            for(Integer val : list) {
                MLog.i("camera support formats val:"+val);
            }

            // 选择合适的预览尺寸
            List<Camera.Size> sizeList = parameters.getSupportedPreviewSizes();
            // 如果sizeList只有一个我们也没有必要做什么了，因为就他一个别无选择
            if (sizeList.size() > 1) {
                for (int i = 0; i < sizeList.size() - 1; i++) {
                    Camera.Size cur = sizeList.get(i);
                    MLog.i("index " + i + " width==" + cur.width + "; height==" + cur.height);
                }
            }

            //设置预览尺寸
            parameters.setPreviewSize(sizeList.get(0).width, sizeList.get(0).height);
            //设置拍照图片尺寸
            parameters.setPictureSize(sizeList.get(0).width, sizeList.get(0).height);

            //parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);

            mCamera.setParameters(parameters);

            mCamera.setPreviewCallback(new Camera.PreviewCallback() {
                @Override
                public void onPreviewFrame(byte[] data, Camera camera) { //每帧预览数据回调
                    Camera.Size size = camera.getParameters().getPreviewSize();
                    MLog.d("data size==" +
                            data.length + "; preViewSize.width==" + size.width + "; preViewSize.height==" + size.height);
                }
            });
            mCamera.startPreview();


            mCamera.autoFocus(mAutoFocusCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void releaseCamera() {
        if (mCamera == null) {
            return;
        }

        mCamera.setPreviewCallback(null);
        mCamera.stopPreview();
        mCamera.release();
        mCamera = null;
    }

    private Camera.AutoFocusCallback mAutoFocusCallback = new Camera.AutoFocusCallback() {
        @Override
        public void onAutoFocus(boolean success, Camera camera) {
            Toast.makeText(CameraDemoActivity.this, "autoFocusCallback", Toast.LENGTH_SHORT).show();
        }
    };

    private SurfaceHolder.Callback mCallback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            try {
                if (mCamera != null) {
                    mCamera.setPreviewDisplay(holder);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    };

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.switch_camera: //转换前置、后置摄像头
                    releaseCamera();
                    mSwitchId = 1 - mSwitchId;
                    initCamera();
                    if (mCamera != null) {
                        try {
                            mCamera.setPreviewDisplay(mSurfaceView.getHolder());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    };
}
