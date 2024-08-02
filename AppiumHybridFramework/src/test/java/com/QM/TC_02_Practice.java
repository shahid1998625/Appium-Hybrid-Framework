package com.QM;

import com.QM.pageObjects.android.CartPage;
import com.QM.pageObjects.android.FormPage;
import com.QM.pageObjects.android.ProductCataloguePage;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TC_02_Practice extends BaseClass {

//    Activity activity;

//    public TC_02_Practice(AndroidDriver driver) {
//        super(driver);
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }


  //  @Test
    public void EcomappTest1() throws InterruptedException {
        fp = new FormPage(driver);
        fp.setNamefield("Shahid");
        fp.setGender("male");
        fp.setCountryselection("Australia");
        ProductCataloguePage pcp = fp.submitForm();
        pcp.addItemtoCartByIndex(0);
        pcp.addItemtoCartByIndex(1);
        CartPage cp = pcp.goToCartPage();
        double totalSum = cp.totalSumofProducts();
        double totalFormattedSum = cp.getTotalSumAmountDisplayed();
        Assert.assertEquals(totalSum, totalFormattedSum);
        cp.acceptTermsConditions();
        cp.SubmitOrder();

    }


    @Test(dataProvider = "getData")
    public void EcomappTest2(HashMap<String, String> input) throws InterruptedException {
        fp = new FormPage(driver);
        fp.setNamefield(input.get("name"));
        Thread.sleep(5000);
        fp.setGender(input.get("gender"));
        fp.setCountryselection(input.get("country"));
//        fp.submitForm();
        ProductCataloguePage pcp = fp.submitForm();
        pcp.addItemtoCartByIndex(0);
        pcp.addItemtoCartByIndex(1);
        CartPage cp = pcp.goToCartPage();
        double totalSum = cp.totalSumofProducts();
        double totalFormattedSum = cp.getTotalSumAmountDisplayed();
        Assert.assertEquals(totalSum, totalFormattedSum);
        cp.acceptTermsConditions();
        cp.SubmitOrder();
    }

    @DataProvider()
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//com//QM//testData//eComm.json");
//        return new Object[][] { {"Shahid", "male", "Australia"},{"Pranjal", "female", "Australia"} };
//        return new Object[][]{{data.get(0)}, {data.get(1)}, {data.get(2)}, {data.get(3)}};
//        return new Object[][]{{data.get(0)}, {data.get(1)}};
        return new Object[][]{{data.get(0)}};
    }

}