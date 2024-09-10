package Priyanshu.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;


public class LoginPage extends AbstractComponents{
	WebDriver driver;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "login")
    WebElement submitButton;

    @FindBy(css = ".toast-error")
    WebElement toastError;
    By byToastError = By.cssSelector(".toast-error");

    public ProductPage loginMethod(String emailId, String pass){
        email.sendKeys(emailId);
        password.sendKeys(pass);
        submitButton.click();
        ProductPage pp = new ProductPage(driver);
        return pp;
    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }
    public String errorMessage(){
        waitUntil(byToastError);
        return toastError.getText();
    }
}
