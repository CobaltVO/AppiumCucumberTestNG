package ru.falseteam.appiumcucumbertestng.util;

import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import ru.falseteam.appiumcucumbertestng.driver.Driver;

public class Helpers {

    public static String findApk() {
        Pattern patternApk = Pattern.compile(".+([^apk].apk)");
        try (Stream<Path> stream = Files.walk(Paths.get(Constants.PROJECT_APP_SEARCH_PATH))) {
            Optional<Path> optionalPath = stream
                    .filter(path -> patternApk.matcher(path.getFileName().toString()).matches())
                    .findFirst();
            return optionalPath.orElseThrow(() -> new FileNotFoundException(
                    "Can not find apk at the resources/apk/ folder of project"))
                    .toAbsolutePath().toString();
        } catch (IOException e) {
            Assert.fail("Can't find apk to test", e);
        }
        return null;
    }

    public static int findFreePort() {
        try {
            ServerSocket socket = new ServerSocket(0);
            int port = socket.getLocalPort();
            socket.close();
            return port;
        } catch (IOException e) {
            Assert.fail("Can not find available port");
        }
        return -1;
    }

    public static void logDriverCapabilities() {
        Logger.debug("Driver capabilities: ");
        Driver.driver
                .getCapabilities()
                .asMap()
                .forEach((key, value) -> Logger.debug((key + ": " + value)));
    }

    public static String toOneWord(String s) {
        StringBuilder sb = new StringBuilder();
        Arrays.asList(s.split("\\W")).forEach(
                out -> sb.append(out.replace(out.charAt(0), Character.toUpperCase(out.charAt(0))))
        );
        return sb.toString();
    }
}
