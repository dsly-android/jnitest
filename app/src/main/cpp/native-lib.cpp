#include <jni.h>
#include <string>
#include "utils/LogUtils.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_jnitest_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */,jobject obj) {
    //c++调java
    jclass clazz = env->GetObjectClass(obj);
    jmethodID jmd_toast = env->GetMethodID(clazz, "toast", "(Ljava/lang/String;)V");
    std::string hello = "also from C++";
    jstring saaaaa = env->NewStringUTF(hello.c_str());
    env->CallVoidMethod(obj, jmd_toast, saaaaa);
    //返回结果
    return env->NewStringUTF(hello.c_str());
}