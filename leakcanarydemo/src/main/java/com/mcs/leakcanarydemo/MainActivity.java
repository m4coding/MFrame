package com.mcs.leakcanarydemo;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTestHandlerButton, mTestInstanceButton, mTestFragmentButton;
    private static final int MSG_DO = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestHandlerButton = (Button) findViewById(R.id.test_handler_button);
        mTestInstanceButton = (Button) findViewById(R.id.test_instance_button);
        mTestFragmentButton = (Button) findViewById(R.id.test_fragment_button);
        mTestHandlerButton.setOnClickListener(mOnClickListener);
        mTestInstanceButton.setOnClickListener(mOnClickListener);
        mTestFragmentButton.setOnClickListener(mOnClickListener);
    }


    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.test_handler_button:
                    mHandler.sendEmptyMessage(MSG_DO);
                    break;
                case R.id.test_instance_button:
                    Toast.makeText(MainActivity.this, "instance", Toast.LENGTH_SHORT).show();
                    DemoInstance.getInstance(MainActivity.this).setButton(mTestInstanceButton);
                    break;
                case R.id.test_fragment_button:
                    FragmentTransaction fragmentTransaction = MainActivity.this.getSupportFragmentManager().beginTransaction();
                    MainFragment mainFragment = new MainFragment();
                    fragmentTransaction.add(R.id.activity_main,mainFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                default:
                    break;
            }
        }
    };

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case MSG_DO:
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(50000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                    break;
                default:
                    break;
            }
        }
    };
}
