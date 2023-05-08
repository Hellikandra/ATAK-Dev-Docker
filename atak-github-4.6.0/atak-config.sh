#!/bin/bash

keytool -genkey -v -keystore my-release-key.jks -keyalg RSA -keysize 2048 -validity 10000 -alias my-alias -keypass android -storepass android -dname "CN=tt, OU=tt, O=tt, C=tt, ST=tt, L=tt"
# NOTE : use `android´ for your password, type the cert info (just hit enter), enventually type yes

ln -s ~/atak/atak-civ/my-release-key.jks ~/atak/atak-civ/plugin-examples/plugintemplate/app/my-release-key.jks

ln -s ~/atak/atak-civ/local.properties ~/atak/atak-civ/plugin-examples/plugintemplate/local.properties
