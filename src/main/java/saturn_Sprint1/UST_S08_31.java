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
		//Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dd_1stRow = driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]/span/div"));
		WebElement acc_Name_1stRow = driver.findElement(By.xpath("//table/tbody/tr[1]/th/span/a"));
		wait.until(ExpectedConditions.attributeToBe(acc_Name_1stRow, "title", "testleaf"));
		dd_1stRow.click();

		driver.findElement(By.xpath("//a[@title='Edit']")).click();

		//8) Select Type as Technology Partner
		driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input')])[2]")).click();
		
		driver.findElement(By.xpath("(//div[contains(@class,'slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left slds')]/lightning-base-combobox-item)[7]")).click();
		
		//9) Select Industry as Healthcare
		driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input')])[4]")).click();
		
		driver.findElement(By.xpath("//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left slds-dropdown_length-with-icon-7']/lightning-base-combobox-item[19]")).click();
		
		//10)Enter Billing Address
		WebElement bill_Addr_Field = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[1]"));
		bill_Addr_Field.clear();
		bill_Addr_Field.sendKeys("121,1st Cross Street, Chennai");
		
		//11)Enter Shipping Address
		WebElement ship_Addr_Field = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
		ship_Addr_Field.clear();
		ship_Addr_Field.sendKeys("121,1st Cross Street, Chennai");
		
		//12)Select Customer Priority as Low
		WebElement cus_Priority_Field = driver.findElement(By.xpath("//button[contains(@aria-label,'Customer Priority')]"));
		driver.executeScript("arguments[0].scrollIntoView(true);", cus_Priority_Field);
		cus_Priority_Field.click();
		driver.findElement(By.xpath("//span[text()='Low']")).click();
		
		//13)Select SLA as Silver
		driver.findElement(By.xpath("//button[contains(@aria-label,'SLA')]")).click();
		driver.findElement(By.xpath("//span[text()='Silver']")).click();	
		
		//14) Select Active as NO
		driver.findElement(By.xpath("//button[contains(@aria-label,'Active')]")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown')])[9]/div[2]/lightning-base-combobox-item[2]/span[2]/span")).click();
		
		//15) Enter Unique Number in Phone Field
		WebElement phone_field = driver.findElement(By.xpath("//input[@name='Phone']"));
		driver.executeScript("arguments[0].scrollIntoView(true);", phone_field);
		phone_field.clear();
		phone_field.sendKeys("9962165493");
		
		//16)Select Upsell Oppurtunity as No
		WebElement upsell_Oppurtunity_Field = driver.findElement(By.xpath("//button[contains(@aria-label,'Upsell Opportunity')]"));
		driver.executeScript("arguments[0].scrollIntoView(true);", upsell_Oppurtunity_Field);
		upsell_Oppurtunity_Field.click();
		driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown')])[8]/div[2]/lightning-base-combobox-item[3]/span[2]/span")).click();
		
		//17)Click on save and verfiy Phone number
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		Thread.sleep(3000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(search_List));
		driver.findElement(By.xpath("//button[@data-element-id='searchClear']")).click();
		search_List.sendKeys("testleaf", Keys.ENTER);
		
		Thread.sleep(3000);
		String phone = driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]/span/span[1]")).getText();
		System.out.println(phone);
		phone = phone.replace("(", "");
		phone = phone.replace(")", "");
		phone = phone.replace("-", "");
		phone = phone.replaceAll(" ", "");
		System.out.println(phone);
		
		if(phone.contains("9962165493")) {
			System.out.println("Phone number Verified successfully");
		} else {
			System.out.println("Phone number NOT Verified successfully");
		}

	}

}
