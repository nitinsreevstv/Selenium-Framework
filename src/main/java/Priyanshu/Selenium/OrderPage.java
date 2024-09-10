package Priyanshu.Selenium;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
	 WebDriver driver;
	    public OrderPage(WebDriver driver){
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver,this);
	    }

	    @FindBy(xpath = "//tbody/tr/td[2]")
	    List<WebElement> orderList;

	    public List<WebElement> orderList(){
	        return orderList;
	    }

	    public boolean orderDisplay(String productName){
	        for(int i = 0; i < orderList().size(); i++){
	            if((orderList().get(i).getText().equals(productName))){
	               return true;
	            }   
	        }
	        return false;
	    }
}
