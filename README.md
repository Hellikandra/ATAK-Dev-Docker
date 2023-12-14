# ATAK-Dev-Docker

This repository provide the capability to set a Linux like docker.
This docker is used to compile ATAK (Android Tactical Awareness Kit) plugins for specific release version.
This repository is created to support the possibility to set an Linux-like Android Development environment to compile ATAK (Android Tactical Awareness Kit) plugins for specific version.


## Folders

| ATAK Dev | zip location |
|--- | --- |
| ATAK - 4.6.0.5 | [Github - release](https://github.com/deptofdefense/AndroidTacticalAssaultKit-CIV/releases/download/4.6.0.5/atak-civ-sdk-4.6.0.5.zip) |
| ATAK - 4.9.0 to 5.0.0 | [TAK.gov](https://tak.gov/products/atak-civ) |

The new implementation require you to set the file name in the Dockerfile. For example, you can check the next table.


## Environment configuration
| ATAK version | Java Version | Gradle | Android Gradle | Android SDK | Android NDK | CMAKE |
| --- | --- | --- | --- | --- | --- | --- |
| 4.6 | 11 | 6.9.1 | 4.2.2 | 26 | 12b
| 4.7 | 11 | | | | 12b |
| 4.8 | 11 | | | | 12b |
| 4.9 | 11 | 7.5.1 | 4.2.2 | 26 | 25b |
| 4.10 | 11 | 7.6.1 | | | 25b | |
| 5.0 | 11 | 7.6.x | 7.4.2 | 30 | 25b | |


## Who to create your image and container
Fork / Clone / Download this repository. 


### Configure the docker file
Before launching `docker build`, ensure that the `ENV` variables in the Dockerfile are correctly set depending on the table before.

| Variables Name | Description | example |
| --- | --- | --- |
| username | the name of the user | atakdev
| cmake_release_version | version of cmake which also corresponding to the extracted folder name| cmake-3.26.0-linux-x86_64 |
| cmake_release_link | web link where CMAKE is located | https://cmake.org/files/v3.26/${cmake_release_version}.tar.gz |
| ndk_release_version | version of the NDK | android-ndk-r12b-linux-x86_64.zip 
| sdk_release_version | Android Command Line for Linux|
| sdk_manager_build_tools | version of the build tools | commandlinetools-linux-9477386_latest.zip |
| sdk_manager_platforms | Version of Android |
| atak_release_version | zip filename of the ATAK SDK|
| atak_extract_foldername | folder name inside of the ATAK SDK |


### Set up image
Ensure that you have installed docker on your machine and **started**. Go to the folder where the `Dockerfile` is and launch the command :

```console
docker build -t <image_name> .
```
To clearly identify on which Docker you will be, the `<image_name>` can be set like this :
* atak-civ-sdk-4.7
* atak-civ-sdk-4.8
* ...

The image take time to be created due to download of some part of the minimum required tools.


### Set up container and plugins folder
This command is changed to include the plugins folder

```console
docker run -ti -v <path_of_plugins_folder>:/home/username/atak-civ/plugins <image_name>
```
To ensure that the previous line works, you need to take into account : 
- path of the folder where your(s) plugin(s) is(are).
- change username by the one you have choose in the Dockerfile (by default : `atakdev`)
- `<image_name>` the value you set on the `docker build ...`


### Final test - TO REWORK
In the docker environment you can test if the environment is correctly set by launching :

```console
./gradlew assembleCivDebug
./gradlew assembleCivRelease
 ```


### Test your plugin - TO DO