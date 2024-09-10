package Priyanshu.Selenium;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;


public class CartPage extends AbstractComponents{
	WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".cartSection h3")
    List<WebElement> cartItem;

    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkOutButton;

    public List<WebElement> cartItems(){
        return cartItem;
    }

    public boolean checkForProduct(String productName){
        for(int i = 0; i < cartItems().size(); i++){
            if((cartItems().get(i).getText().equals(productName))){
               return true;
            }   
        }
        return false;
    }
    public PaymentPage checkOut(){
        checkOutButton.click();
        PaymentPage Payment = new PaymentPage(driver);
        return Payment;
    }
}
