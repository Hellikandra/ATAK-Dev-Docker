# ---------------------- #
# import from Docker Hub #
# ---------------------- #
FROM debian:latest

USER root
RUN echo "root:pswd" | chpasswd

# ------- --------- #
# install essential #
# ------- --------- #
RUN dpkg --add-architecture i386
RUN apt-get update
RUN apt-get install -y openjdk-11-jdk wget unzip nano

# --- ---- #
# add user #
# --- ---- #
RUN useradd -rm -d /home/androiddev -s /bin/bash -g root -G sudo -u 1001 androiddev
USER androiddev

# ------------------    ------------------------------- #
# cmake installation -- from : https://cmake.org/files/ #
# ------------------    ------------------------------- #
WORKDIR /home/androiddev
RUN mkdir -p cmake-3.26.0
RUN wget https://cmake.org/files/v3.26/cmake-3.26.0-linux-x86_64.tar.gz 
RUN tar -xvzf cmake-3.26.0-linux-x86_64.tar.gz
RUN rm cmake-3.26.0-linux-x86_64.tar.gz

# --------------------- #
# install Android suite #
# --------------------- #
# ndk installation
WORKDIR /home/androiddev/Android
RUN wget https://dl.google.com/android/repository/android-ndk-r12b-linux-x86_64.zip 
RUN unzip -q android-ndk-r12b-linux-x86_64.zip
RUN rm android-ndk-r12b-linux-x86_64.zip

# sdk installation
WORKDIR /home/androiddev/Android/sdk
RUN wget https://dl.google.com/android/repository/commandlinetools-linux-9477386_latest.zip
RUN unzip -q commandlinetools-linux-9477386_latest.zip
RUN rm commandlinetools-linux-9477386_latest.zip
WORKDIR /home/androiddev/Android/sdk/cmdline-tools/bin
RUN yes | ./sdkmanager --sdk_root="/home/androiddev/Android/sdk" --licenses
RUN ./sdkmanager --sdk_root="/home/androiddev/Android/sdk" "build-tools;30.0.2" "platforms;android-26" "platform-tools"

# ------------ #
# install atak #
# ------------ #
# source code : tak.gov
# -----------   -------
# modify by sdk from TAK.gov
WORKDIR /home/androiddev/atak
COPY --chown=androiddev:root ATAK_CIV_4.8_SDK.zip ./
RUN unzip ATAK_CIV_4.8_SDK.zip
RUN mv atak-civ-maintenance-4.8 atak-civ
RUN rm ATAK_CIV_4.8_SDK.zip

WORKDIR /home/androiddev/atak/atak-civ
COPY --chown=androiddev:root local.properties ./
COPY --chown=androiddev:root atak-config.sh ./

RUN mkdir plugins
ADD ./plugins ./plugins

USER root
RUN chown -R androiddev:root ./plugins
USER androiddev
RUN /bin/bash ./atak-config.sh -- launch in the docker

# ----- #
# start #
# ----- #
CMD ["bash"]

