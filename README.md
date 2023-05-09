# ATAK-Dev-Docker

This repository is created to support the possibility to set an Linux-like Android Development environment to compile ATAK (Android Tactical Awareness Kit) plugins for specific version.

## Folders

| ATAK Dev | zip location |
|--- | --- |
| ATAK - 4.6.0 | [Github - release](https://github.com/deptofdefense/AndroidTacticalAssaultKit-CIV/releases/download/4.6.0.5/atak-civ-sdk-4.6.0.5.zip) |
| ATAK - 4.7.0.3 | [TAK.gov](https://tak.gov/rails/active_storage/blobs/redirect/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaHBBcEFuIiwiZXhwIjpudWxsLCJwdXIiOiJibG9iX2lkIn19--b2f99f60cf208fcb0c001c9ddda4cd46a57e9616/ATAK-CIV-4.7.0.3-SDK.zip)
| ATAK - 4.8.1.16 | [TAK.gov](https://tak.gov/rails/active_storage/blobs/redirect/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaHBBdmhSIiwiZXhwIjpudWxsLCJwdXIiOiJibG9iX2lkIn19--4074e8845344c8e322b37b25ec63ba6e2ec3a58c/ATAK_CIV_4.8.1.16_SDK.zip)
| ATAK - 4.9.0.2 | [TAK.gov](https://tak.gov/rails/active_storage/blobs/redirect/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaHBBdnMrIiwiZXhwIjpudWxsLCJwdXIiOiJibG9iX2lkIn19--9bf6e3127e708122318c37b3826caf214a89d45f/ATAK_CIV_4.9.0_SDK_5530E38.zip)

## Who to create your image and container

Fork or clone the repository.

### Set up image
Ensure that you have docker on your machine .Go to the folder where the `Dockerfile` is and launch the command :

```console
docker build -t <image_name> .
```

The image take time to be created due to download of some part of the minimum required tools.

### Set up plugins folder

create or move  the folder `plugins` present in each directory where your plugins are. By default `plugins` folder have the `plugintemplate`.

### Set up container

```console
docker run -it -v <path_to_folder>\plugins:/home/androiddev/atak/atak-civ-<version>/plugins -t <image_name>
```

The `docker run` command will create the container by attaching the volume defined in local to the subdirectory in the atak release you define.

### Final test
In the docker environment you can test if the environment is correctly set by launching :

```console
./gradlew assembleCivDebug
./gradlew assembleCivRelease
 ```

# Content of Dockerfile
