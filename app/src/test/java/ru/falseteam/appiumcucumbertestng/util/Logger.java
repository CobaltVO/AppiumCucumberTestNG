package ru.falseteam.appiumcucumbertestng.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    public final static String TAG = "FalseTeamAutotest";

    private static void log(String logLevel, String message) {
        String datePattern = "yyyy-MM-dd hh:mm:ss:SSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        System.out.println(
                simpleDateFormat.format(new Date()) +
                ' ' +
                logLevel +
                '/' +
                TAG +
                ':' +
                ' ' +
                message);
    }

    public static void verbose(String message) {
        log("V", message);
    }

    public static void debug(String message) {
        log("D", message);
    }

    public static void info(String message) {
        log("I", message);
    }

    public static void warn(String message) {
        log("W", message);
    }

    public static void error(String message) {
        log("E", message);
    }
}
