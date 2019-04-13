//
// Created by 吴新禹 on 2019/3/10.
//
#include <jni.h>


#ifndef AVDEMO_NATIVE_COLOR_H
#define AVDEMO_NATIVE_COLOR_H
#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL surfaceCreated(JNIEnv *, jobject, jint);

JNIEXPORT void JNICALL surfaceChanged(JNIEnv *, jobject, jint, jint);

JNIEXPORT void JNICALL onDrawFrame(JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
