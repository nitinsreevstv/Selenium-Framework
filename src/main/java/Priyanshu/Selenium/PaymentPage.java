package Priyanshu.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class PaymentPage extends AbstractComponents{
	WebDriver driver;
    public PaymentPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;

    @FindBy(css = ".ta-item:nth-of-type(2)")
    WebElement selectChoice;

    @FindBy(css = ".action__submit")
    WebElement submit;

    By dropdown = By.cssSelector(".ta-results");

    public void choice(String countryName){
        Actions action = new Actions(driver);
        action.sendKeys(country,countryName).build().perform();
        waitUntil(dropdown);
        selectChoice.click();
    }
    public ConfirmationPage submitOrder(){
        submit.click();
        return new ConfirmationPage(driver);
    }
}
