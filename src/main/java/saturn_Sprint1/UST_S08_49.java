package saturn_Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UST_S08_49 {

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager - To download and set path of WebDriver
		//WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		
		//Firefox Options to disable firefox browser notifications
		//FirefoxOptions options = new FirefoxOptions();
		//options.addPreference("dom.webnotifications.enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//Launch Firefox Browser
		//FirefoxDriver driver = new FirefoxDriver(options);
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		//1. Login to https://login.salesforce.com
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();

		//2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle_container')]")).click();
		
		//3. Click View All and click Work Type Groups from App Launcher
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Work Type Groups");
		
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();
		
		//4. Click on the Dropdown icon in the Work Type Groups tab
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[10]")).click();
		
	}

}
