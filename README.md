# ATAK-Dev-Docker

This repository is created to support the possibility to set an Linux-like Android Development environment to compile ATAK (Android Tactical Awareness Kit) plugins for specific version.

## Folders

| ATAK Dev | zip location |
|--- | --- |
| ATAK - 4.6.0.5 | [Github - release](https://github.com/deptofdefense/AndroidTacticalAssaultKit-CIV/releases/download/4.6.0.5/atak-civ-sdk-4.6.0.5.zip) |
| ATAK - 4.7 | [TAK.gov](https://tak.gov/products/atak-civ?product_version=atak-civ-4-7-0)
| ATAK - 4.8 | [TAK.gov](https://tak.gov/products/atak-civ?product_version=atak-civ-4-8-1)
| ATAK - 4.9 | [TAK.gov](https://tak.gov/products/atak-civ?product_version=atak-civ-4-9-0)
| ATAK - 4.10 | [TAK.gov](https://tak.gov/products/atak-civ?product_version=atak-civ-4-10-0)

!! New version from 06 July 2023. After downloading the version of ATAK you want from tak.gov, the name of the file need to be changed to ATAK-CIV-x.x_SDK.zip where X.X is the version of ATAK.

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
docker run -it -t <image_name>
```

The `docker run` command will create the container by attaching the volume defined in local to the subdirectory in the atak release you define.

### Final test
In the docker environment you can test if the environment is correctly set by launching :

```console
./gradlew assembleCivDebug
./gradlew assembleCivRelease
 ```

# Content of Dockerfile
