package saturn_Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Param_Code {

	public static void main(String[] args) throws InterruptedException {
		// Download and Set the ChromerDriver Path
		WebDriverManager.chromedriver().setup();

		// Disable Browser Notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class = 'slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		WebElement element = driver.findElement(By.xpath("//p[text()='Sales']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		WebElement acc_Field = driver.findElement(By.xpath("(//span[text()='Accounts'])[1]"));
		js.executeScript("arguments[0].click();", acc_Field);

	}

}
