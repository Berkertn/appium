package Driver;

import java.io.File;

public class Driver {

    public enum PlatformNames {
        ios("iOS"),
        android("Android");

        private String value;

        PlatformNames(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


    private String platformName;
    private String automationName;
    private String deviceName;
    private String UdId;
    private String appPath;

    public Driver(PlatformNames platformName) {
        if (platformName == PlatformNames.ios) {
            setPlatformName("iOS");
            setAutomationName("XCUITest");
            setDeviceName("iPhone 14 Pro Max");
            setUdId("493BF52D-FC9F-482A-A1AB-5601846C0E63");
            setAppPath("");
        } else if (platformName == PlatformNames.android) {
            setPlatformName("iOS");
            setAutomationName("UiAutomator2");
            setDeviceName("pixel_6_pro");
            setUdId("emulator-5554");
            String appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                    File.separator + "resources" + File.separator + "apks" + File.separator + "ApiDemos.apk";
            setAppPath(appPath);
        } else {
            throw new IllegalArgumentException("Invalid name. Allowed names are " + PlatformNames.android + "or" + PlatformNames.ios);
        }
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getAutomationName() {
        return automationName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getUdId() {
        return UdId;
    }

    public String getAppPath() {
        return appPath;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public void setAutomationName(String automationName) {
        this.automationName = automationName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setUdId(String udId) {
        UdId = udId;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }
}
