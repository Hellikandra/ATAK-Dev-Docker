#!/bin/bash

# https://docs.oracle.com/en/java/javase/17/docs/specs/man/keytool.html
keytool -genkey -v -keystore my-release-key.jks -keyalg RSA -keysize 2048 -validity 10000 -alias my-alias -keypass android -storepass android -dname "CN=Android Developer, OU=DevOps, O=atak-civ-4.8.1.5, C=US, L=Ft. Belvoir"
# NOTE : use `android´ for your password, type the cert info (just hit enter), enventually type yes

ln -s ~/atak/atak-civ-4.8.1.5/my-release-key.jks ~/atak/atak-civ-4.8.1.5/plugin-examples/plugintemplate/app/my-release-key.jks

ln -s ~/atak/atak-civ-4.8.1.5/local.properties ~/atak/atak-civ-4.8.1.5/plugin-examples/plugintemplate/local.properties
