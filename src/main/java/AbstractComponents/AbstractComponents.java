package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Priyanshu.Selenium.CartPage;
import Priyanshu.Selenium.OrderPage;


public class AbstractComponents {
	WebDriver driver;
    public AbstractComponents(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cartMenu;

    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    WebElement orders;

    public CartPage goToCart(){
        cartMenu.click();
        CartPage cp = new CartPage(driver);
        return cp;
    }

    public OrderPage goToOrders(){
        orders.click();
        OrderPage op = new OrderPage(driver);
        return op;
    }
    
    public void waitUntil(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void waitUntilDisapear(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
