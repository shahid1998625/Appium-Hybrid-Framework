package com.QM;

import com.QM.pageObjects.android.CartPage;
import com.QM.pageObjects.android.FormPage;
import com.QM.pageObjects.android.ProductCataloguePage;
import com.QM.utils.AndroidActions;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.List;

public class TC_01_NativeApp_to_WebMobile_Browser_Navigation extends BaseClass
{
    FormPage fp;
    Activity activity ;
    AndroidDriver driver;

//    public TC_01_NativeApp_to_WebMobile_Browser_Navigation(AndroidDriver driver) {
////        super(driver);
//    }


        @Test
    public void EcomappTest1()  {
        fp = new FormPage(driver);
        fp.setNamefield("Shahid");
        fp.setGender("male");
        fp.setCountryselection("Australia");
        fp.submitForm();
//        ProductCataloguePage pcp
//        pcp.addItemtoCartByIndex(0);
//        pcp.addItemtoCartByIndex(1);
//        CartPage cp = pcp.goToCartPage();
//        double totalSum = cp.totalSumofProducts();
//        double totalFormattedSum = cp.getTotalSumAmountDisplayed();
//        Assert.assertEquals(totalSum, totalFormattedSum);
//        cp.acceptTermsConditions();
//        cp.SubmitOrder();
    }



    @Test(dataProvider = "getData")
    public void EcomappTest2(String name, String gender, String country) throws InterruptedException {
        fp.setNamefield(name);
        Thread.sleep(5000);
        fp.setGender(gender);
        fp.setCountryselection(country);
        fp.submitForm();
//      ProductCataloguePage pcp =
//        pcp.addItemtoCartByIndex(0);
//        pcp.addItemtoCartByIndex(1);
//        CartPage cp = pcp.goToCartPage();
//        double totalSum = cp.totalSumofProducts();
//        double totalFormattedSum = cp.getTotalSumAmountDisplayed();
//        Assert.assertEquals(totalSum, totalFormattedSum);
//        cp.acceptTermsConditions();
//        cp.SubmitOrder();
    }

    @DataProvider()
    public Object[][] getData() throws IOException {
//        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//com//QM//testData//eComm.json");
        return new Object[][] { {"Shahid", "male", "Australia"},{"Pranjal", "female", "Australia"} };
    }

}

/*          Set<String> contexts = driver.getContextHandles();
            for(String IndividualContexts:contexts){
                System.out.println(IndividualContexts);
            }
        driver.context("WEBVIEW_com.androidsample.generalstore");
//        driver = new ChromeDriver();
            WebElement textBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
            textBox.sendKeys("Quality Matrix");
            textBox.sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.context("NATIVE_APP");
//        NATIVE_APP
//        WEBVIEW_com.androidsample.generalstore
        }

        private void enterName(String name) {
            driver.findElement(By.id(NAME_FIELD_ID)).sendKeys(name);
            driver.hideKeyboard();
        }

        private void selectGender() {
            driver.findElement(By.id(RADIO_FEMALE_ID)).click();
        }

        private void selectCountry(String country) {
            driver.findElement(By.id(SPINNER_COUNTRY_ID)).click();
            WebElement countryDropdown = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + country + "\"));"));
            countryDropdown.click();
        }

        private void clickLetsShopButton() throws InterruptedException {
            driver.findElement(By.id(LETS_SHOP_BUTTON_ID)).click();
            Thread.sleep(3000); // Consider using WebDriverWait instead of Thread.sleep
        }

        private void addItemToCart(int index) {
            List<WebElement> addToCartButtons = driver.findElements(By.id(PRODUCT_ADD_CART_ID));
            if (index < addToCartButtons.size()) {
                addToCartButtons.get(index).click();
            }
        }

        private void goToCart() {
            driver.findElement(By.id(CART_BUTTON_ID)).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id(TOOLBAR_TITLE_ID)), "text", "Cart"));
        }

        private void verifyTotalAmount() {
            List<WebElement> productPrices = driver.findElements(By.id(PRODUCT_PRICE_ID));
            double totalSum = productPrices.stream()
                    .mapToDouble(price -> getFormattedAmount(price.getText()))
                    .sum();

            String displaySum = driver.findElement(By.id(TOTAL_AMOUNT_LABEL_ID)).getText();
            double totalFormattedSum = getFormattedAmount(displaySum);

            System.out.println("Total Sum of Products is: " + totalSum);
            System.out.println("Total formatted sum: " + totalFormattedSum);

            Assert.assertEquals(totalSum, totalFormattedSum);
        }

        private void longPressTermsButton() throws InterruptedException {
            WebElement longPressBtn = driver.findElement(By.id(TERMS_BUTTON_ID));
            longPressActions(longPressBtn);
//            TouchAction action = new TouchAction(driver);
//            action.longPress(LongPressOptions.longPressOptions()
//                            .withElement(ElementOption.element(longPressBtn))
//                            .withDuration(Duration.ofSeconds(2)))
//                    .release()
//                    .perform();
//
            Thread.sleep(2000); // Consider using WebDriverWait instead of Thread.sleep
        }

        private void acceptTermsAndProceed() {
            WebElement popupBtn = driver.findElement(By.xpath(POPUP_BUTTON_XPATH));
            popupBtn.click();

            driver.findElement(By.xpath(CHECKBOX_XPATH)).click();
            driver.findElement(By.id(PROCEED_BUTTON_ID)).click();
        }
    }


//        }
//    }*/