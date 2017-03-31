package com.mcs.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mcs.mframe.log.MLog;
import com.mcs.retrofitdemo.model.SearchUserEntity;
import com.mcs.retrofitdemo.model.UserEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Button mGetButton, mSearchUsersButton, mGetRxButton;
    private TextView mContentText;
    private ProgressBar mProgressBar;

    private DemoService mDemoService;
    private Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mContentText = (TextView) findViewById(R.id.text_response);
        mGetButton = (Button) findViewById(R.id.button_get);
        mSearchUsersButton = (Button) findViewById(R.id.button_search_users);
        mGetRxButton = (Button) findViewById(R.id.button_get_with_rxjava);
        mGetButton.setOnClickListener(mOnClickListener);
        mSearchUsersButton.setOnClickListener(mOnClickListener);
        mGetRxButton.setOnClickListener(mOnClickListener);

        //内容过多时滚动显示
        mContentText.setMovementMethod(ScrollingMovementMethod.getInstance());

        initRetrofit();
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_get:
                    showOrHideProgress(true);
                    Call<UserEntity> call = mDemoService.getName("mcshengInworking");
                    call.enqueue(new Callback<UserEntity>() {
                        @Override
                        public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                            String content =  response.body().toString();
                            mContentText.setText(content);
                            showOrHideProgress(false);
                        }

                        @Override
                        public void onFailure(Call<UserEntity> call, Throwable t) {
                            String error =  t.toString();
                            MLog.e("throwable==" + t.toString());
                            mContentText.setText(error);
                            showOrHideProgress(false);
                        }
                    });
                    break;
                case R.id.button_search_users:
                    showOrHideProgress(true);
                    Call<SearchUserEntity> call2 = mDemoService.searchUser("mcshengInworking");
                    call2.enqueue(new Callback<SearchUserEntity>() {
                        @Override
                        public void onResponse(Call<SearchUserEntity> call, Response<SearchUserEntity> response) {
                            String content =  response.body().toString();
                            mContentText.setText(content);
                            showOrHideProgress(false);
                        }

                        @Override
                        public void onFailure(Call<SearchUserEntity> call, Throwable t) {
                            String error =  t.toString();
                            MLog.e("throwable==" + t.toString());
                            mContentText.setText(error);
                            showOrHideProgress(false);
                        }
                    });
                    break;
                case R.id.button_get_with_rxjava:
                    showOrHideProgress(true);
                    mDemoService.getNameWithRxjava("mcshengInworking")
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Subscriber<UserEntity>() {
                                @Override
                                public void onCompleted() {
                                    showOrHideProgress(false);
                                }

                                @Override
                                public void onError(Throwable e) {
                                    String error =  e.toString();
                                    MLog.e("throwable==" + e.toString());
                                    mContentText.setText(error);
                                    showOrHideProgress(false);
                                }

                                @Override
                                public void onNext(UserEntity userEntityCall) {
                                    String content =  userEntityCall.toString();
                                    mContentText.setText(content);
                                }
                            });

                    break;
            }
        }
    };

    private void initRetrofit() {
        // com.google.gson.stream.MalformedJsonException:
        // Use JsonReader.setLenient(true) to accept malformed JSON at line 3 column 1 path $
        //问题解答：http://stackoverflow.com/questions/39918814/use-jsonreader-setlenienttrue-to-accept-malformed-json-at-line-1-column-1-path
        Gson gson = new GsonBuilder()
                //.setLenient()
                .create();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson)) //注意添加转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //添加Rxjava适配器
                .build();

        mDemoService = mRetrofit.create(DemoService.class);
    }

    private void showOrHideProgress(boolean isShow) {
        if (isShow) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }
    }
}
