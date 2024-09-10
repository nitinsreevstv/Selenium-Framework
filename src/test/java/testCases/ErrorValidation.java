package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import Priyanshu.Selenium.CartPage;
import Priyanshu.Selenium.ConfirmationPage;
import Priyanshu.Selenium.PaymentPage;
import Priyanshu.Selenium.ProductPage;
import TestComponents.BaseTest;
import TestComponents.Retry;

public class ErrorValidation extends BaseTest{
	@Test(retryAnalyzer=Retry.class)
    public void loginValidation() throws InterruptedException{
        lp.loginMethod("priyanshu@qwerty.in","IamKing!123");
        AssertJUnit.assertEquals("Incorrect email or password.", lp.errorMessage());
    }
    @Test
    public void productErrorValidation() throws IOException {
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/Resource/Global.properties");
        pro.load(fis);
        String email = pro.getProperty("email");
        String password = pro.getProperty("password");
        String product1 = "ADIDAS ORIGINAL";
        String product2 = "ZARA COAT 3";
        String successMessage = "THANKYOU FOR THE ORDER.";
        String countryName = "India";
        ProductPage pp = lp.loginMethod(email, password);
        pp.getProduct();
        pp.addToCart(product1);
        pp.addToCart(product2);
        CartPage cp = pp.goToCart();
        cp.cartItems();
        AssertJUnit.assertTrue(cp.checkForProduct(product1));
        AssertJUnit.assertTrue(cp.checkForProduct(product2));
        PaymentPage Payment = cp.checkOut();
        Payment.choice(countryName);
        ConfirmationPage conPage = Payment.submitOrder();
        AssertJUnit.assertTrue(conPage.successMssg().equalsIgnoreCase(successMessage));
    }
    

}
