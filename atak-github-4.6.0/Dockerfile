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
RUN useradd -rm -d /home/devuserdev -s /bin/bash -g root -G sudo -u 1001 devuserdev
USER devuserdev

# ------------------    ------------------------------- #
# cmake installation -- from : https://cmake.org/files/ #
# ------------------    ------------------------------- #
WORKDIR /home/devuserdev
RUN mkdir -p cmake-3.26.0
RUN wget https://cmake.org/files/v3.26/cmake-3.26.0-linux-x86_64.tar.gz 
RUN tar -xvzf cmake-3.26.0-linux-x86_64.tar.gz
RUN rm cmake-3.26.0-linux-x86_64.tar.gz

# --------------------- #
# install Android suite #
# --------------------- #
# ndk installation
WORKDIR /home/devuserdev/Android
RUN wget https://dl.google.com/android/repository/android-ndk-r12b-linux-x86_64.zip 
RUN unzip -q android-ndk-r12b-linux-x86_64.zip
RUN rm android-ndk-r12b-linux-x86_64.zip

# sdk installation
WORKDIR /home/devuserdev/Android/sdk
RUN wget https://dl.google.com/android/repository/commandlinetools-linux-9477386_latest.zip
RUN unzip -q commandlinetools-linux-9477386_latest.zip
RUN rm commandlinetools-linux-9477386_latest.zip
WORKDIR /home/devuserdev/Android/sdk/cmdline-tools/bin
RUN yes | ./sdkmanager --sdk_root="/home/devuserdev/Android/sdk" --licenses
RUN ./sdkmanager --sdk_root="/home/devuserdev/Android/sdk" "build-tools;30.0.2" "platforms;android-26" "platform-tools"

# ------------ #
# install atak #
# ------------ #
# source code : https://github.com/deptofdefense/AndroidTacticalAssaultKit-CIV/archive/refs/tags/4.6.0.5.zip
# -----------   --------------------------------------------------------------------------------------------
# modify by sdk from TAK.gov
WORKDIR /home/devuserdev/atak
RUN wget https://github.com/deptofdefense/AndroidTacticalAssaultKit-CIV/releases/download/4.6.0.5/atak-civ-sdk-4.6.0.5.zip
RUN unzip atak-civ-sdk-4.6.0.5.zip -d /home/devuserdev/atak
RUN rm atak-civ-sdk-4.6.0.5.zip

WORKDIR /home/devuserdev/atak/atak-civ
COPY --chown=devuserdev:root local.properties /home/devuserdev/atak/atak-civ/
COPY --chown=devuserdev:root atak-config.sh /home/devuserdev/atak/atak-civ/
RUN /bin/bash ./atak-config.sh
RUN mkdir plugins

# ----- #
# start #
# ----- #
CMD ["bash"]

