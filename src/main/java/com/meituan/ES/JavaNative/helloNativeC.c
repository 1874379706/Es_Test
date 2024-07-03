##include <stdio.h>
#include "com_meituan_ES_JavaNative_HelloNative.h"

JNIEXPORT void JNICALL Java_HelloNative_greeting(JNIEnv *env, jclass cl)
{
    printf("this is hello native .c printf\n");
}