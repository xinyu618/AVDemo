//
// Created by 吴新禹 on 2019/2/22.
//

#include <jni.h>
#include <string>
#include <iostream>

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_av_avdemo_MainActivity_testNative(
        JNIEnv *env,
        jobject /* this */) {
    //获取class
    jclass clas = env->FindClass("com/av/avdemo/JniTest");
    //获取方法
    jmethodID nativeCallTest = env->GetStaticMethodID(clas , "nativeCallTest" , "()Ljava/lang/String;");
    //调用
    jstring result = (jstring) env->CallStaticObjectMethod(clas, nativeCallTest);

    using namespace std;
    cout << "wuxinyu";
    return result;
}

