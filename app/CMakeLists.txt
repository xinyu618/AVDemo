cmake_minimum_required(VERSION 3.4.1)

add_library( # Sets the name of the library.
             native-color

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/native-color.cpp)


target_link_libraries( # Specifies the target library.
                       native-color

                       # Links the target library to the log library
                       # included in the NDK.
                       GLESv3
                       android
                       EGL
                       log
                       m)