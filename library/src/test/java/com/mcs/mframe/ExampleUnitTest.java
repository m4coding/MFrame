package com.mcs.mframe;

import android.util.Log;

import com.mcs.mframe.log.MLog;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        //MLog.d("addition_isCorrect");
        android.util.Log.d("TAG", "This is Log.d");
        System.out.println("This is System.out.println");
        assertEquals(4, 2 + 2);
    }
}