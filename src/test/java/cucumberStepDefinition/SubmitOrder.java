package cucumberStepDefinition;

import java.io.IOException;

import org.testng.AssertJUnit;

import Priyanshu.Selenium.CartPage;
import Priyanshu.Selenium.ConfirmationPage;
import Priyanshu.Selenium.LoginPage;
import Priyanshu.Selenium.PaymentPage;
import Priyanshu.Selenium.ProductPage;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubmitOrder extends BaseTest{ 
	public LoginPage lp;
	public ProductPage pp;
	public CartPage cp;
	public PaymentPage payment;
	public ConfirmationPage conPage;
	@Given("I landed on Ecommerce Page")
	public void LandingEcommercePage() throws IOException {
		lp = launchApplication();
	}
	
	@Given("^Logged In with the (.+) and (.+)$")
	public void Logging_with_username(String username, String password) {
		 pp = lp.loginMethod(username, password);
	}
	
	@When("^I add (.+) to the cart$")
	public void AddToCart(String product) {
		pp.getProduct();
		pp.addToCart(product);
	}
	
	@When("^checkout (.+) name and submit the order$")
	public void Checkout_for_submit_order(String product) {
		cp = pp.goToCart();
        cp.cartItems();
        AssertJUnit.assertTrue(cp.checkForProduct(product));
        payment = cp.checkOut();
        payment.choice("india");
        conPage = payment.submitOrder();
	}
	
	@Then("{string} message is displayed on Confirmation Page")
	public void DisplayedConfirmationMessage(String string) {
		AssertJUnit.assertEquals(string, conPage.successMssg());
		driver.close();
	}
	
	@Then("verify the success message {string}")
	public void successMessageValidation(String string) {
		AssertJUnit.assertEquals(string, lp.errorMessage());
		driver.close();
	}
}
