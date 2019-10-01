package ru.falseteam.appiumcucumbertestng;

import java.nio.file.Paths;

public class Constants {
    public static final String PROJECT_FEATURES_PATH =
            "src/test/resources/ru/falseteam/appiumcucumbertestng/features/";
    public static final String PROJECT_PACKAGE_NAME = "ru.falseteam.appiumcucumbertestng";
    public static final String GLUE = PROJECT_PACKAGE_NAME + ".steps";
    public static final String PROJECT_APP_SEARCH_PATH =
            Paths.get("").toAbsolutePath().toString() + "\\src\\test\\resources\\apk";

    public static final String CHROME_CANARY_PACKAGE_NAME = "com.chrome.canary";
    public static final String CHROME_CANARY_LAUNCHER_ACTIVITY_NAME =
            "org.chromium.chrome.browser.document.ChromeLauncherActivity";

}
