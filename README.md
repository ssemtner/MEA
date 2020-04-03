# MEA

This is the github for MEA (specificaly the UI)


# How To Run On Windows
First Time:
  1) Install openjdk 11 (https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot)
  2) Open command prompt````````
  3) git clone https://www.github.com/ssemtner/mea.git
  4) cd mea/mea
  5) gradlew run
  
Updating:
  1) Open folder where build.gradle file is
  2) cd ..
  3) git pull
  
 ##THIS IS NOT CORRECT:
  
 # How To Run On Raspberry Pi
 First Time:
  1) Open command prompt
  2) wget https://download.bell-sw.com/java/11.0.6+10/bellsoft-jdk11.0.6+10-linux-arm32-vfp-hflt-full.deb
  3) sudo apt-get install ./bellsoft-jdk11.0.6+10-linux-arm32-vfp-hflt-full.deb
  4) Copy path of new folder created
  5) Navigate to a folder that you want to code to be in
  6) git clone https://www.github.com/ssemtner/mea.git
  7) cd mea/mea
  8) nano build.gradle
  9) replace line "version=13" with "skd=" + the copied path
  10) chmod +x gradlew
  11) ./gradlew run
 
