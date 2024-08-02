package com.QM.pageObjects.android;

import com.QM.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductCataloguePage extends AndroidActions {
        private AndroidDriver driver;

    public ProductCataloguePage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this );
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private List<WebElement> PRODUCT_ADD_CART_ID ;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement CART_BUTTON_ID;


    public void addItemtoCartByIndex(int index){
        PRODUCT_ADD_CART_ID.get(index).click();
    }
    public CartPage goToCartPage() throws InterruptedException {
        CART_BUTTON_ID.click();
        Thread.sleep(3000);
        return new CartPage(driver);
    }
}



