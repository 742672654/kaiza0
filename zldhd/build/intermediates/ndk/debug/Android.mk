LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := H264Decoder-prebuilt
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_SRC_FILES := \
	F:\parkingos_android\zldhd\src\main\jni\Android.mk \
	F:\parkingos_android\zldhd\src\main\jni\Application.mk \
	F:\parkingos_android\zldhd\src\main\jni\prebuilt\libBaiduMapSDK_v3_1_0.so \
	F:\parkingos_android\zldhd\src\main\jni\prebuilt\libH264Decoder.so \
	F:\parkingos_android\zldhd\src\main\jni\prebuilt\libMediaConverter.so \
	F:\parkingos_android\zldhd\src\main\jni\prebuilt\libMP4Recorder.so \
	F:\parkingos_android\zldhd\src\main\jni\prebuilt\libmsc.so \
	F:\parkingos_android\zldhd\src\main\jni\prebuilt\libRTSP.so \
	F:\parkingos_android\zldhd\src\main\jni\prebuilt\libRTSP1.so \
	F:\parkingos_android\zldhd\src\main\jni\prebuilt\libRTSP_bak_2014.so \
	F:\parkingos_android\zldhd\src\main\jni\prebuilt\libtcpsdk.so \
	F:\parkingos_android\zldhd\src\main\jni\prebuilt\libvztcpsdk_dynamic.so \
	F:\parkingos_android\zldhd\src\main\jni\prebuilt\libYITIJI.so \
	F:\parkingos_android\zldhd\src\main\jni\tcpclient.c \
	F:\parkingos_android\zldhd\src\main\jni\yitiji.c \

LOCAL_C_INCLUDES += F:\parkingos_android\zldhd\src\debug\jni
LOCAL_C_INCLUDES += F:\parkingos_android\zldhd\src\main\jni

include $(BUILD_SHARED_LIBRARY)
