package com.QM.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

public class AndroidDriverManager {
        private static AndroidDriver driver;
        protected static AppiumDriverLocalService service;

    public AndroidDriverManager() throws FileNotFoundException {
    }


    public static AndroidDriver getDriver() {
            if (driver == null) {
                try {
                    setUpDriver();
                } catch (MalformedURLException | URISyntaxException | FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return driver;
        }

        private static void setUpDriver() throws MalformedURLException, URISyntaxException, FileNotFoundException {
            UiAutomator2Options options = new UiAutomator2Options();
//            Properties prop = new Properties();
//            FileInputStream fis = new FileInputStream(System.getProperty("user.dir" + "\\src\\main\\java\\com\\QM\\resources\\data.properties"));

            service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Abdulsami_Mohammed\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
            service.start();
//          options.setDeviceName("TestPhone");
            options.setDeviceName("Android Device");
            options.setChromedriverExecutable(System.getProperty("user.dir") + "\\src\\test\\java\\com\\QM\\Setups\\chromedriver1.exe"); // Set path where Chromedriver is located
//            options.setApp("D:\\Appium Automation\\AppiumSha\\src\\main\\java\\APK Files\\General-Store.apk");
            options.setApp(System.getProperty("user.dir") + "\\src\\main\\java\\com\\QM\\APK Files\\General-Store.apk");
            options.setAutomationName("UiAutomator2");

            driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        }

        public static void quitDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }

