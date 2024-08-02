package com.QM.Runner;

import com.QM.drivers.AndroidDriverManager;
import com.QM.pageObjects.android.FormPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class BaseClass {

    protected static AndroidDriver driver;
    protected AppiumDriverLocalService service;
    protected FormPage fp;

//    public BaseClass(AndroidDriver driver) {
//        super(driver);
//        this.driver = driver;
//    }

    //    @BeforeClass
    @BeforeClass
//    @BeforeMethod
    public void startApp() throws InterruptedException {
        driver = AndroidDriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        fp = new FormPage(driver);
//        Thread.sleep(10000);
    }

   /* @BeforeMethod
    public void setupAppium() throws URISyntaxException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Abdulsami_Mohammed\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
//        options.setDeviceName("TestPhone");
        options.setDeviceName("Android Device");
        options.setChromedriverExecutable("D:\\Appium Automation\\AppiumSha\\src\\test\\java\\Setups\\chromedriver.exe"); // Set path where Chromedriver is located
        options.setApp("D:\\Appium Automation\\AppiumSha\\src\\main\\java\\APK Files\\General-Store.apk");
//        appackages
//        options.setAppPackage("com.androidsample.generalstore");
//        options.setAppActivity("com.androidsample.generalstore.MainActivity");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        fp = new FormPage(driver);
    }*/

/*    @BeforeMethod
    public void preSetup() {
// For JavaScript executor method

        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
                "intent", "com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"
        ));
        // Start the activity using JavascriptExecutor
//        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
//                "appPackage", "com.androidsample.generalstore",
//                "appActivity", "com.androidsample.generalstore.SplashActivity"
//        ));

        System.out.println("Activity started using JavaScript executor");
//        } catch (Exception e) {
//            e.printStackTrace();

    }*/

        @AfterClass
//    @AfterMethod
    public void tearDown() throws InterruptedException {
//            Thread.sleep(4000);
//            driver.quit();
//            service.stop();
//            Thread.sleep(2000);
            Thread.sleep(4000);
            if (driver != null) {
                driver.quit();
//                driver.close();
            }
            if (service != null) {
                service.stop();
            }
            Thread.sleep(2000);
        }


    public static AndroidDriver getDriver() {
        return driver;
    }

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
//        System.getProperty("user.dir") + "//src//test//java//com//QM//testData//eComm.json"
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {

                });
        return data;
    }
}
