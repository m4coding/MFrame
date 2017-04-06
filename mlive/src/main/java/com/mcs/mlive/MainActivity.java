package com.mcs.mlive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mCameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView()  {
        mCameraButton = (Button) findViewById(R.id.camera_id);
        mCameraButton.setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.camera_id:
                    intent = new Intent(MainActivity.this, CameraDemoActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    };
}
