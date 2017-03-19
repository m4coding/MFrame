package com.mcs.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mcs.mframe.log.MLog;
import com.mcs.retrofitdemo.model.UserEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Button mGetButton, mPostButton;
    private TextView mContentText;

    private DemoService mDemoService;
    private Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContentText = (TextView) findViewById(R.id.text_response);
        mGetButton = (Button) findViewById(R.id.button_get);
        mPostButton = (Button) findViewById(R.id.button_post);
        mGetButton.setOnClickListener(mOnClickListener);
        mPostButton.setOnClickListener(mOnClickListener);

        initRetrofit();
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_get:
                    Call<UserEntity> call = mDemoService.getName("mcshengInworking");
                    call.enqueue(new Callback<UserEntity>() {
                        @Override
                        public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                            String content =  response.body().toString();
                            MLog.d("getName==" + content);
                            mContentText.setText(content);
                        }

                        @Override
                        public void onFailure(Call<UserEntity> call, Throwable t) {
                            String error =  t.toString();
                            MLog.d("throwable==" + t.toString());
                            mContentText.setText(error);
                        }
                    });
                    break;
                case R.id.button_post:
                    break;
            }
        }
    };

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://github.com")
                .build();

        mDemoService = mRetrofit.create(DemoService.class);
    }
}
