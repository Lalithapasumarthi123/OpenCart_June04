package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	WebElement MyAccountele=driver.findElement(By.xpath("//span[text()='My Account']"));
	@FindBy(linkText="Register")
	WebElement regAccount;
	// Action Methods
	public void clickMyAccount() {
		MyAccountele.click();
		}

	public void clickRegister() {
		regAccount.click();
		}

}
