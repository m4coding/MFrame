package com.mcs.mframe.log.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @author mochangsheng
 * @version 1.0
 * @description file打印实现
 * @created 2017/1/3
 * @changeRecord [修改记录] <br/>
 */

public class MFileLog {

    private static final String FILE_PREFIX = "MLog_";
    private static final String FILE_FORMAT = ".log";

    public static boolean printLog(int type, String tag, File targetDirectory, @Nullable String fileName, String msg) {

        fileName = (fileName == null) ? getDefaultFileName() : fileName;
        if (save(type, targetDirectory, fileName, msg)) {
            return true;
        } else {
            Log.e(tag, "save log to file fails !");
            return false;
        }
    }

    private static boolean save(int type, File dic, @NonNull String fileName, String msg) {

        File file = new File(dic, fileName);
        String tmpMsg = "";
        switch (type) {
            case MLogConstant.VERBOSE:
                tmpMsg = String.format("type:VERBOSE# " + msg);
                break;
            case MLogConstant.DEBUG:
                tmpMsg = String.format("type:DEBUG# " + msg);
                break;
            case MLogConstant.INFO:
                tmpMsg = String.format("type:INFO# " + msg);
                break;
            case MLogConstant.WARN:
                tmpMsg = String.format("type:WARN# " + msg);
                break;
            case MLogConstant.ERROR:
                tmpMsg = String.format("type:ERROR# " + msg);
                break;
            case MLogConstant.ASSERT:
                tmpMsg = String.format("type:ASSERT# " + msg);
                break;
        }


        try {
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            outputStreamWriter.write(tmpMsg);
            outputStreamWriter.flush();
            outputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    private static String getDefaultFileName() {
        Random random = new Random();
        return FILE_PREFIX + Long.toString(System.currentTimeMillis() + random.nextInt(10000)).substring(4) + FILE_FORMAT;
    }
}
