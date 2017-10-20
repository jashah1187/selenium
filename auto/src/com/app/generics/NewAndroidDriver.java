package com.app.generics;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.SessionId;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewAndroidDriver<AndroidElement> extends AndroidDriver {
    private final String deviceID;
    private String deviceName = "";
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public NewAndroidDriver(URL remoteAddress, Capabilities desiredCapabilities) {

        super(remoteAddress, desiredCapabilities);

        this.deviceID = (String) desiredCapabilities.getCapability("udid");
        try {
            this.deviceName = ((String) desiredCapabilities.getCapability("deviceName")).replace(" ", "_").replace("'", "-").trim();
        } catch (Exception e) {
            this.deviceName = deviceID;
        }

    }

    @Override
    protected void log(SessionId sessionId, String commandName, Object toLog, When when) {
        if (commandName.equals("newSession")) sdf = new SimpleDateFormat("HH:mm:ss");
        super.log(sessionId, commandName, toLog, when);

        System.out.println(sdf.format(new Date(System.currentTimeMillis())) + ": " + deviceID + " - " + when + ": " + commandName + " toLog:" + toLog);
        if (deviceName != null) {
            System.out.println(deviceName + sdf.format(new Date(System.currentTimeMillis())) + when + ": " + commandName + " toLog:" + toLog);

        }
    }

}
