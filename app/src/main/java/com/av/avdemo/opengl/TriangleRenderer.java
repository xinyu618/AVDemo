package com.av.avdemo.opengl;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by wuxinyu on 2019/3/11.
 */

public class TriangleRenderer implements GLSurfaceView.Renderer {
    private FloatBuffer triangleVB;

    public TriangleRenderer() {

        float triangleCoords[] = {
                // X, Y, Z 这是一个等边三角形
                -0.5f, -0.25f, 0,
                0.5f, -0.25f, 0,
                0.0f, 0.559016994f, 0
        };
        // 初始化三角形的顶点缓存
        ByteBuffer vbb = ByteBuffer.allocateDirect(
                // (# of coordinate values * 4 bytes per float)
                triangleCoords.length * 4);
        vbb.order(ByteOrder.nativeOrder());// 使用设备硬件本身的字节序
        triangleVB = vbb.asFloatBuffer(); // 从ByteBuffer中创建一个浮点缓存
        triangleVB.put(triangleCoords); // 向浮点缓存中添加顶点坐标
        triangleVB.position(0); // 使缓存读第一个坐标
    }

    public void draw(GL10 gl)
    {
        gl.glColor4f(0.63671875f, 0.76953125f, 0.22265625f, 0.0f); //设置当前颜色
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, triangleVB);//设置顶点
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);//绘制三角形
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        gl10.glViewport(0, 0, 480, 1080);
        float ratio = (float) 480 / 1080;
        gl10.glMatrixMode(GL10.GL_PROJECTION); // 设置当前矩阵为投影矩阵
        gl10.glLoadIdentity(); // 重置矩阵为初始值
        gl10.glFrustumf(-ratio, ratio, -1, 1, 3, 7); // 根据长宽比设置投影矩阵
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {
        gl10.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        gl10.glEnableClientState(GL10.GL_VERTEX_ARRAY);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        gl10.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        // 设置当前矩阵为模型视图模式
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();  // reset the matrix to its default state
        // 设置视点
        GLU.gluLookAt(gl10, 0, 0, -5, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
        draw(gl10);
    }
}
