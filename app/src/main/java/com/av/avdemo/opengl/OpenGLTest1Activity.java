package com.av.avdemo.opengl;

import android.app.Activity;
import android.graphics.Color;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by wuxinyu on 2019/3/10.
 */

public class OpenGLTest1Activity extends Activity {
    private static final String TAG = "OpenGLTest1Activity";

    private GLSurfaceView mGLSurfaceView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGLSurfaceView = new GLSurfaceView(this);
        setContentView(mGLSurfaceView);
        //设置版本
//        mGLSurfaceView.setEGLContextClientVersion(3);
//        GLSurfaceView.Renderer renderer = new ColorRenderer(Color.RED);
//        GLSurfaceView.Renderer renderer = new NativeColorRenderer(Color.GRAY);
        GLSurfaceView.Renderer renderer = new TriangleRenderer();
        mGLSurfaceView.setRenderer(renderer);
    }



}
