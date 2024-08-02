package com.QM.pageObjects.android;

import com.QM.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends AndroidActions {
        private AndroidDriver driver;

    public FormPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this );
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement namefield;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement radioBtnfemale;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text = 'Male']")
    private WebElement radioBtnMale;

    @AndroidFindBy(id ="com.androidsample.generalstore:id/spinnerCountry")
    private WebElement spinnercountryid;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement lets_ShopBtn;


    public void setNamefield(String name){
        namefield.sendKeys(name);
        driver.hideKeyboard();
    }
    public void setGender(String gender){
        if(gender.contains("female")){
            radioBtnfemale.click();
        }
        else{
            radioBtnMale.click();
        }
    }
    public void setCountryselection(String country){
        spinnercountryid.click();
        scrollToText(country);
        driver.findElement(By.xpath("//android.widget.TextView[@text = '"+country+"']")).click();
    }
    public ProductCataloguePage submitForm(){
        lets_ShopBtn.click();
        return new ProductCataloguePage(driver);
    }
}
