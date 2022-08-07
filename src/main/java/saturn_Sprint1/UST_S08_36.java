package saturn_Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UST_S08_36 {

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

		// 1. Login to https://login.salesforce.com
		// Enter Username
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		// Enter Password
		driver.findElement(By.id("password")).sendKeys("India$321");
		// Click Login Button
		driver.findElement(By.id("Login")).click();

		// 2. Click on the toggle menu button from the left corner
		driver.findElement(
				By.xpath("//button[@data-aura-class='forceHeaderButton salesforceIdentityAppLauncherHeader']")).click();

		// 3. Click View All and click Legal Entities from App Launcher
		// Click View All link
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		// Click Legal Entities
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Legal Entities", Keys.ENTER);
		driver.findElement(By.xpath("//mark[text()='Legal Entities']")).click();

		// 4. Click on the Dropdown icon in the legal Entities tab
		Thread.sleep(3000);
		// driver.findElement(By.xpath("(//*[local-name()='svg' and @class='slds-icon
		// slds-icon-text-default slds-icon_xx-small'])[14]")).click();
		driver.findElement(
				By.xpath("//a[contains(@title,'Legal Entities')]/following-sibling::one-app-nav-bar-item-dropdown"))
				.click();

		// 5. Click on New Legal Entity
		Thread.sleep(3000);
		WebElement newLegalEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", newLegalEntity);

		// 6. Enter the Company name as 'Tetsleaf'. Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Company Name']/../following-sibling::input")).sendKeys("TestLeaf");

		// 7. Enter Description as 'SalesForce'.
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys("salesForce");

		// 8. Select Status as 'Active' WebElement StatusDD =
		WebElement StatusDD = driver.findElement(By.xpath("//a[@class='select']"));
		js.executeScript("arguments[0].scrollIntoView()", StatusDD);
		StatusDD.click();
		driver.findElement(By.xpath("//a[@title='Active']")).click();
		
		//9. Click on Save
		driver.findElement(By.xpath("(//span[ text()='Save'])[2]")).click();
		
		//10. Verify the Alert message (Complete this field) displayed for Name
		WebElement nameField = driver.findElement(By.xpath("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Name']"));
		js.executeScript("arguments[0].scrollIntoView()", nameField);
		
		WebElement inlineError = driver.findElement(By.xpath("//li[text()='Complete this field.']"));
		if(inlineError.isDisplayed()) {
			System.out.println("Complete this field message should be displayed for Name field");
		} else {
			throw new RuntimeException("Testfailed");		}
	}

}
