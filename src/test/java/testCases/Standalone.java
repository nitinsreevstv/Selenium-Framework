package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.HashMap;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Priyanshu.Selenium.*;
import TestComponents.BaseTest;


public class Standalone extends BaseTest {
	 @Test(dataProvider = "getData")
	    public void submitOrder(HashMap<String, String> input) throws IOException {
	        String successMessage = "THANKYOU FOR THE ORDER.";
	        String countryName = "India";
	        ProductPage pp = lp.loginMethod(input.get("email"), input.get("password"));
	        pp.getProduct();
	        pp.addToCart(input.get("product1"));
	        pp.addToCart(input.get("product2"));
	        CartPage cp = pp.goToCart();
	        cp.cartItems();
	        AssertJUnit.assertTrue(cp.checkForProduct(input.get("product1")));
	        AssertJUnit.assertTrue(cp.checkForProduct(input.get("product2")));
	        PaymentPage Payment = cp.checkOut();
	        Payment.choice(countryName);
	        ConfirmationPage conPage = Payment.submitOrder();
	        AssertJUnit.assertEquals(successMessage, conPage.successMssg());
	    }
	    @Test(dependsOnMethods = {"submitOrder"})
	    public void orderHistoryTest() throws IOException{
	        String email = "priyanshu12@gmail.com";
	        String password = "123@Abc$#";
	        ProductPage pp = lp.loginMethod(email, password);
	        OrderPage op = pp.goToOrders();
	        String product = "ZARA COAT 3";
	        AssertJUnit.assertTrue(op.orderDisplay(product));
	    }

	    @DataProvider
	    public Object[][] getData(){
	        HashMap<String,String> map = new HashMap<String,String>();
	        map.put("email", "priyanshu12@gmail.com");
	        map.put("password", "123@Abc$#");
	        map.put("product1", "ZARA COAT 3");
	        map.put("product2", "ADIDAS ORIGINAL");

	        HashMap<String, String> map2 = new HashMap<String,String>();
	        map2.put("email", "priyanshu1@gmail.com");
	        map2.put("password", "Password$1#");
	        map2.put("product2", "ZARA COAT 3");
	        map2.put("product1", "ADIDAS ORIGINAL");
	        return new Object[][] {{map},{map2}};
	    }
}
