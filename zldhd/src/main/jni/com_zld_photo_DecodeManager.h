/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_zld_photo_DecodeManager */

#ifndef _Included_com_zld_photo_DecodeManager
#define _Included_com_zld_photo_DecodeManager
#ifdef __cplusplus
extern "C" {
#endif


JNIEXPORT jstring JNICALL Java_com_zld_photo_DecodeManager_runYitiji
  (JNIEnv *, jclass, jobject, jstring);

JNIEXPORT jstring JNICALL Java_com_zld_photo_DecodeManager_stopYitiji
  (JNIEnv *, jclass);

JNIEXPORT jstring JNICALL Java_com_zld_photo_DecodeManager_controlPole
  (JNIEnv *, jclass, jint, jstring);

JNIEXPORT jstring JNICALL Java_com_zld_photo_DecodeManager_getOneImg
  (JNIEnv * env, jclass object, jstring);

JNIEXPORT jint JNICALL Java_com_zld_photo_DecodeManager_getConfidenceLevel
(JNIEnv *env, jclass object);

JNIEXPORT void JNICALL Java_com_zld_photo_DecodeManager_setConfidenceLevel
(JNIEnv *env, jclass object, jint level);

#ifdef __cplusplus
}
#endif
#endif