package saturn_Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UST_S08_29 {

	public static void main(String[] args) throws InterruptedException {
		
		//Setup WebdriverManager
		WebDriverManager.edgedriver().setup();
		
		//Setup ChromeOptions to disable browser notifications
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");
		
		//1.Login to https://login.salesforce.com
		EdgeDriver driver = new EdgeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		
		//2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle_container')]")).click();
		
		//3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Sales");
		
		driver.findElement(By.xpath("//a[@class='slds-text-heading_small']/following-sibling::p[contains(@title,'Manage')]")).click();
		
		//4. Click on Opportunity tab
		WebElement opp_Tab = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", opp_Tab);
		
		//5. Select the Table view
		driver.findElement(By.xpath("//button[@title='Display as Table']")).click();
		
		driver.findElement(By.xpath("(//span[@class='slds-truncate']/lightning-primitive-icon)[1]")).click();
		
		//6. Sort the Opportunities by Close Date in ascending order
		WebElement sort_CloseDate = driver.findElement(By.xpath("//table/thead/tr/th[@title='Close Date']/div/a"));
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.elementToBeClickable(sort_CloseDate));
		//js.executeScript("arguments[0].click()", sort_CloseDate);
		sort_CloseDate.click();
		Thread.sleep(2000);
		sort_CloseDate.click();
		
		//7. Verify the Opportunities displayed in ascending order by Close date
		WebElement sort_Val = driver.findElement(By.xpath("//table/thead/tr/th[@title='Close Date']/div/span"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.attributeToBe(sort_Val,"innerHTML","Sorted Ascending"));
		String sort_Order = sort_Val.getAttribute("innerHTML");
		System.out.println(sort_Order);
		if(sort_Order.equalsIgnoreCase("Sorted Ascending")) {
			System.out.println("Records sorted in Ascending Order");
		}
		else {
			throw new RuntimeException("Testcase Failed");
		}
		
	}

}
