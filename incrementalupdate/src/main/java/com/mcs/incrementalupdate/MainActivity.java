package com.mcs.incrementalupdate;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.update);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementUpdate();
            }
        });

        Log.i("MainActivity", Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    private void incrementUpdate() {
        final File destApk = new File(Environment.getExternalStorageDirectory(), "dest.apk");
        final File patch = new File(Environment.getExternalStorageDirectory(), "PATCH.patch");

        //一定要检查文件都存在

        BsPatch.doPatch(ApkExtract.extract(this),
                destApk.getAbsolutePath(),
                patch.getAbsolutePath());

        if (destApk.exists()) {
            Log.i("MainActivity", destApk.getAbsolutePath() + ": md5==" + ApkExtract.getFileMD5(destApk));
            ApkExtract.install(this, destApk.getAbsolutePath());
        }
    }

}
