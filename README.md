How to setup project:

1. Clone or download this project.
2. Install NodeJS (LTS) to make the Appium server possible to start from tests.
3. To prevent troubles with installation of Appium module via npm (at Windows 10) add to environment variables new line at var "Path": add path to folder with installed NodeJS at step 2.
4. Run cmd and execute command "npm install -g appium" or "npm install -g appium@x.y.z", where x,y,z are represent the version number. 
5. To check the Appium is installed correctly, you can install additional Appium module by executing the command "npm install appium-doctor" and executing "appium-doctor" command after installation. If appium-doctor doesn't show any errors then the Appium is installed normally.
6. For correct work of Appium driver you need to set ANDROID_HOME environment variable: specify the pass to Android SDK directory. After that, add to "Path" environment variable lines: 
  1) %ANDROID_HOME%\tools; 
  2) %ANDROID_HOME%\platform-tools.
