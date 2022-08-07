package saturn_Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UST_S08_31 {

	public static void main(String[] args) throws InterruptedException {

		// Setup Firefox driver and path
		WebDriverManager.firefoxdriver().setup();

		WebDriverManager.edgedriver().setup();

		// 1) Launch the app
		/*
		 * FirefoxOptions options = new FirefoxOptions();
		 * //options.addArguments("--disable-notifications");
		 * options.addPreference("dom.webnotifications.enabled", false);
		 * 
		 * FirefoxDriver driver = new FirefoxDriver(options);
		 */

		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");

		EdgeDriver driver = new EdgeDriver(options);

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 2) Click Login 3) Login with the credentials
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();

		// 4) Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle_container')]")).click();

		// 5) Click on Accounts
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Accounts");

		driver.findElement(By.xpath("//b[text()='Accounts']")).click();

		// 6) Search for the Account Using the unique account name created by you
		WebElement search_List = driver.findElement(By.xpath(
				"//div[@class='slds-col slds-no-flex slds-grid slds-align-bottom slds-shrink']//div//div/input"));
		// wait.until(ExpectedConditions.stalenessOf(search_List));
		search_List.sendKeys("testleaf", Keys.ENTER);

		// 7) Click on the displayed Account Dropdown icon and select Edit
		Thread.sleep(3000);
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dd_1stRow = driver.findElement(By.xpath("(//table/tbody/tr/td[6]//div//span/span[1])[1]"));
		//wait.until(ExpectedConditions.elementToBeClickable(dd_1stRow));
		
		dd_1stRow.click();

		driver.findElement(By.xpath("//a[@title='Edit']")).click();

		//8) Select Type as Technology Partner
		driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input')])[2]")).click();
		
		driver.findElement(By.xpath("(//div[contains(@class,'slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left slds')]/lightning-base-combobox-item)[7]")).click();
		
		//9) Select Industry as Healthcare
		driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input')])[4]")).click();
		
		driver.findElement(By.xpath("//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left slds-dropdown_length-with-icon-7']/lightning-base-combobox-item[19]")).click();
		/*
		 *  
		 * 10)Enter Billing Address 11)Enter Shipping Address 12)Select Customer
		 * Priority as Low 13)Select SLA as Silver 14) Select Active as NO 15) Enter
		 * Unique Number in Phone Field 16)Select Upsell Oppurtunity as No 17)Click on
		 * save and verfiy Phone number
		 */

	}

}
