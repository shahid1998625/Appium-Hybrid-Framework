package com.QM.pageObjects.android;

import com.QM.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AndroidActions {
        private AndroidDriver driver;

    public CartPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this );
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement TOOLBAR_TITLE_ID;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> PRODUCT_PRICE_LIST ;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement TOTAL_AMOUNT_LABEL_ID ;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement TERMS_BUTTON_ID;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id = 'android:id/button1']")
    private WebElement Accept_BUTTON ;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@class = 'android.widget.CheckBox']")
    private WebElement CHECKBOX_XPATH;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement PROCEED_BUTTON_ID;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement longPressBtn;


    public double totalSumofProducts(){
            int productcount = PRODUCT_PRICE_LIST.size();
            double totalSum =0;
            for(int i = 0; i<productcount; i++)
        {
            String amountstring = PRODUCT_PRICE_LIST.get(i).getText();
            Double price = getFormattedAmount(amountstring);
            totalSum = totalSum + price;
        }
        return totalSum;
    }

    public double getTotalSumAmountDisplayed(){
        return getFormattedAmount(TOTAL_AMOUNT_LABEL_ID.getText());
    }
    public void acceptTermsConditions(){
        longPressActions(TERMS_BUTTON_ID);
        Accept_BUTTON.click();
    }
    public void SubmitOrder(){
        CHECKBOX_XPATH.click();
        PROCEED_BUTTON_ID.click();
    }


//
//        public void validateTotalCartAddedItems(String amountString){
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.attributeContains(TOOLBAR_TITLE_ID,"text","Cart"));
//            int productcount = PRODUCT_PRICE_IDs.size();
//            double totalSum = 0;
//            for(int i = 0 ; i<productcount; i++){
//                amountString = gene
//            }

        }



