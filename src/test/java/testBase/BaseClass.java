package testBase;

import java.time.Duration;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger; //Creation of a logger object
	/*public FileReader reader=new FileReader("config.properties");
	public Properties appProps = new Properties();*/
	public ResourceBundle rb ;
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		rb=ResourceBundle.getBundle("config"); //Loading the config.properties
		logger= LogManager.getLogger(this.getClass()); //Add the current class file in log file
		if(br.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LALITHA\\eclipse-workspace\\OpenCart_June04\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver(); //Can create object for chromedriver directly
		}
		else if(br.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		//driver.get("https://naveenautomationlabs.com/opencart");
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	public String randomeNumeric() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return (generatedString);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	public String CaptureScreen(String val) throws IOException {
		/*SimpleDateFormat df=new SimpleDateFormat();
		Date date=new Date();
		String timestamp=df.format(date);*/
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + val + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
}
