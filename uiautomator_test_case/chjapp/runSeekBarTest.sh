#!/bin/sh

# path for uiautomator test case project
testProjectPath="/Users/hengjiechen/Develop/uiautomator_test/uiautomator_test_case/chjapp/"
testProjectPath=$(pwd)

# name for uiautomator test case
name="chjappTest"
jarPath="bin/${name}.jar"

# sdk id. use "android list" command to get it. For example:
# $android list
# Available Android targets:
# ----------
# id: 1 or "android-19"
#      Name: Android 4.4.2
#      Type: Platform
#      ...
#
# The sdk id is 1 for android-19(android 4.4)
androidSDKId=1

# class name of test case, including package name
testCaseClassName=com.android.chjappTest.TestCase

# create build.xml
android create uitest-project -n ${name} -t ${androidSDKId} -p ${testProjectPath}

# go to project
cd ${testProjectPath}
rm -f ${jarPath}

# build
ant build

# check if jar exist
if [ -f ${jarPath} ]; then
   echo "Build success."
else
   echo "Build failed. Cannot find bin/${name}.jar"
   exit 1
fi

# move jar file to device
adb push ${jarPath} /data/local/tmp

# execute test
adb shell uiautomator runtest "${name}.jar" -c ${testCaseClassName}
