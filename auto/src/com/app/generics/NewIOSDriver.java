package com.app.generics;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.SessionId;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewIOSDriver<IOSElement> extends IOSDriver {
    private String deviceID = null;
    private String deviceName = null;

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public NewIOSDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);
        try {
            this.deviceID = (String) desiredCapabilities.getCapability("udid");
            this.deviceName = ((String) desiredCapabilities.getCapability("deviceName")).replace(" ", "_").replace("'", "-").trim();

        } catch (Exception e) {
            System.out.println("No Id or Name");
        }

    }

    @Override
    protected void log(SessionId sessionId, String commandName, Object toLog, When when) {
        if (commandName.equals("newSession")) sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(new Date(System.currentTimeMillis())) + ": " + deviceID + " - " + when + ": " + commandName + " toLog:" + toLog);
        super.log(sessionId, commandName, toLog, when);
        if (deviceName != null) {
            System.out.println(deviceName +" - "+ sdf.format(new Date(System.currentTimeMillis())) + when + ": " + commandName + " toLog:" + toLog);
        }
    }
}