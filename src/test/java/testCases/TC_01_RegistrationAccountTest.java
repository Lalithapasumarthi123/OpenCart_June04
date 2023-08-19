package testCases;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;

import testBase.BaseClass;

public class TC_01_RegistrationAccountTest extends BaseClass {
@Test
public void account_registration() throws InterruptedException{
	//logger.debug("App logs");
	logger.info("Registration Account started");
	try {
	
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickRegister();
	
	AccountRegistration regpage=new AccountRegistration(driver);
	logger.info("Entering the user details");
	regpage.setFirstName(randomeString().toUpperCase());
	regpage.setLastName(randomeString().toUpperCase());
	
	regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
	logger.info("Email entered entered successfully");
	regpage.setTelephone(randomeNumeric());
	logger.info("Telephone number entered successfully");
	String password=randomAlphaNumeric();
	regpage.setPassword(password);
	regpage.confirmPassword(password);
	logger.info("Password entered successfully");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)", "");
	regpage.setPrivacyPolicy();
	regpage.clickContinue();
	String confmsg=regpage.getConfirmationMsg();
	logger.info("Validating the expected result");
	Assert.assertEquals(confmsg, "Your Account Has Been Created!","Issue while creating the account");
	}
	catch(Exception e) {
		logger.error("Test failed");
		Assert.fail();
		e.printStackTrace();
	}
	logger.info("Account registration is completed");	
	
}


}
