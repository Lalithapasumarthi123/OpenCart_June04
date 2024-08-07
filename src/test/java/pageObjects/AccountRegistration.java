package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistration extends BasePage{

	public AccountRegistration(WebDriver driver) {
		super(driver);
	}
	// Elements
			@FindBy(name = "firstname")
			WebElement txtFirstname;

			@FindBy(name = "lastname")
			WebElement txtLasttname;

			@FindBy(name = "email")
			WebElement txtEmail;

			@FindBy(name = "telephone")
			WebElement txtTelephone;

			@FindBy(name = "password")
			WebElement txtPassword;
			
			@FindBy(name = "confirm")
			WebElement confirmPassword;

			@FindBy(xpath = "//input[@name='agree']")
			WebElement chkdPolicy;

			@FindBy(xpath = "//input[@value='Continue']")
			WebElement btnContinue;

			@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
			WebElement msgConfirmation;
			
			public String user_email="";

			public void setFirstName(String fname) {
				txtFirstname.sendKeys(fname);

			}

			public void setLastName(String lname) {
				txtLasttname.sendKeys(lname);

			}

			public void setEmail(String email) {
				user_email=email;
				txtEmail.sendKeys(email);

			}
			public String getEmail() {
				return user_email;

			}
			public void setTelephone(String telephone) {
				txtTelephone.sendKeys(telephone);

			}

			public void setPassword(String pwd) {
				txtPassword.sendKeys(pwd);

			}

			public void confirmPassword(String pwd) {
				confirmPassword.sendKeys(pwd);

			}
			public void setPrivacyPolicy() {
				//driver.manage().window().setSize(new Dimension(650, 800));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				chkdPolicy.click();
			}

			public void clickContinue() {
				//sol1 
				btnContinue.click();
				
				//sol2 
				//btnContinue.submit();
				
				//sol3
				//Actions act=new Actions(driver);
				//act.moveToElement(btnContinue).click().perform();
							
				//sol4
				//JavascriptExecutor js=(JavascriptExecutor)driver;
				//js.executeScript("arguments[0].click();", btnContinue);
				
				//Sol 5
				//btnContinue.sendKeys(Keys.RETURN);
				
				//Sol6  
				//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
				//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
				
			}

			public String getConfirmationMsg() {
				try {
					return (msgConfirmation.getText());
				} catch (Exception e) {
					return (e.getMessage());

				}

}
}
