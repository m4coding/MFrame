LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
#一部分代码取自bsdiff-4.3  一部分代码取自bzip2-1.0.6
LOCAL_SRC_FILES := \
    bspatch.c \
    bzip2/blocksort.c \
    bzip2/bzip2.c \
    bzip2/bzlib.c \
    bzip2/compress.c \
    bzip2/crctable.c \
    bzip2/decompress.c \
    bzip2/huffman.c \
    bzip2/randtable.c

LOCAL_MODULE := bspatch

include $(BUILD_SHARED_LIBRARY)