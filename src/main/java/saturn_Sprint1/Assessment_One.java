package saturn_Sprint1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assessment_One {

	public static void main(String[] args) throws InterruptedException {

		//Setup Browser Driver and Path
		WebDriverManager.chromedriver().setup();

		//Disable Browser Notification through ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		//Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

		//1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("saturn@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp$123");
		driver.findElement(By.id("Login")).click();

		//2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle')]/div")).click();

		//3. Click view All 
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		//4. Click Sales from App Launcher
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		driver.findElement(By.xpath("//one-app-launcher-app-tile[@data-name='Sales']")).click();

		//5. Select Home from the DropDown
		WebElement home_Tab = driver.findElement(By.xpath("//nav[@role='navigation' and @aria-label='Global']//one-app-nav-bar-item-root[1]/a"));
		driver.executeScript("arguments[0].click();", home_Tab);

		//6. Add CLOSED + OPEN values and result should set as the GOAL (If the result is less than 10000 then set the goal as 10000)
		Thread.sleep(3000);
		String closed = driver.findElement(By.xpath("//span[text()='Closed']/following-sibling::lightning-formatted-text")).getText();
		String open = driver.findElement(By.xpath("//span[contains(text(),'Open')]/following-sibling::lightning-formatted-text")).getText();
		closed = closed.replace('$',' ');
		closed = closed.replace(',',' ');
		closed = closed.replaceAll(" ", "");
		open = open.replace('$',' ');
		open = open.replace(',',' ');
		open = open.replaceAll(" ", "");
		System.out.println("Converted String Closed: "+closed);
		System.out.println("Converted String Open: "+open);

		int closed_Value = Integer.parseInt(closed);
		int open_Value = Integer.parseInt(open);
		System.out.println("Integer Closed: "+closed_Value);
		System.out.println("Integer Open: "+open_Value);

		int goal_Value = closed_Value+open_Value;

		if(goal_Value<10000) {
			goal_Value = 10000;
			System.out.println("Goal Value set to 10000");
		} else {
			System.out.println("Goal Value set to:"+goal_Value);
		}

		String goal = String.valueOf(goal_Value);
		System.out.println("Final GOAL value in String: "+goal);

		driver.findElement(By.xpath("//button[@title='Edit Goal']")).click();
		WebElement goal_Input = driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow']/input"));
		goal_Input.clear();
		goal_Input.sendKeys(goal);
		driver.findElement(By.xpath("//div[@class='buttonGroup']/button[2]")).click();
		Thread.sleep(2000);


		//7. Navigate to Dashboard tab
		WebElement dashboard_Tab = driver.findElement(By.xpath("//nav[@role='navigation' and @aria-label='Global']//one-app-nav-bar-item-root[9]/a"));
		driver.executeScript("arguments[0].click();", dashboard_Tab);

		//8. Click on New Dashboard
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();

		//9. Enter the Dashboard name as "YourName_Workout"
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='dashboard'])[1]")));
		driver.findElement(By.id("dashboardNameInput")).sendKeys("Palanivel_Workout");

		//10. Enter Description as Testing and Click on Create
		driver.findElement(By.id("dashboardDescriptionInput")).sendKeys("Testing");


		//11. Click on Create
		driver.findElement(By.xpath("//button[text()='Create']")).click();

		//12. Click on Done
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='dashboard'])[1]")));
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.switchTo().defaultContent();

		//13. Click on Dashboard tab
		driver.executeScript("arguments[0].click();", dashboard_Tab);

		//14. Verify the Dashboard is Created
		Thread.sleep(2000);
		List<WebElement> dash_Rows = driver.findElements(By.xpath("//table/tbody/tr"));
		for(int i=1;i<=dash_Rows.size();i++) {
			String name = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/th//span/div//a")).getText();
			if(name.equalsIgnoreCase("Palanivel_Workout")) {
				System.out.println("New Dashboard Created Successfully");
				break;
			}
		}

		//15. Click on the newly created Dashboard
		for(int i=1;i<=dash_Rows.size();i++) {
			String name = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/th//span/div//a")).getText();
			if(name.equalsIgnoreCase("Palanivel_Workout")) {
				WebElement dash_Name = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/th//span/div//a"));
				driver.executeScript("arguments[0].click();", dash_Name);
				break;
			}
		}

		//16. Click on Subscribe
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='dashboard'])[2]")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Subscribe']")).click();
		driver.switchTo().defaultContent();

		//14. Select Frequency as "Daily"
		driver.findElement(By.xpath("//span[text()='Daily']")).click();

		//15. Time as 10:00 AM
		Select time_DD = new Select(driver.findElement(By.id("time")));
		time_DD.selectByVisibleText("10:00 AM");

		//16. Click on Save
		driver.findElement(By.xpath("//span[text()='Save']")).click();

		//17. Verify "You started Dashboard Subscription" message displayed or not
		Thread.sleep(2000);
		WebElement toast_Message = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds')]"));
		if(toast_Message.isDisplayed()) {
			System.out.println("Message Dispalyed Successfully");
		}else {
			System.out.println("Message NOT Dispalyed");
		}

		//18. Click on Dashboards tab
		driver.executeScript("arguments[0].click();", dashboard_Tab);

		//19. Verify the newly created Dashboard is available
		for(int i=1;i<=dash_Rows.size();i++) {
			String name = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/th//span/div//a")).getText();
			if(name.equalsIgnoreCase("Palanivel_Workout")) {
				System.out.println("New Dashboard Created Successfully");
				break;
			}
		}

		//20. Click on dropdown for the item
		for(int i=1;i<=dash_Rows.size();i++) {
			String name = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/th//span/div//a")).getText();
			if(name.equalsIgnoreCase("Palanivel_Workout")) {
				driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]//span/div//lightning-button-menu/button")).click();
			}
		}

		//21. Select Delete
		driver.findElement(By.xpath("//span[text()='Delete']")).click();

		//22. Confirm the Delete
		driver.findElement(By.xpath("//button[@title='Delete']/span")).click();

		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[contains(@id,'toast')]/span")).isDisplayed()) {
			System.out.println("Dashboard Deleted Message Displayed");
		} else {
			System.out.println("Dashboard Deleted Message NOT Displayed");
		}

		//23. Verify the item is not available under Private Dashboard folder
		driver.findElement(By.xpath("//li/a[@title='Private Dashboards']")).click();
		int count=0;
		List<WebElement> private_dash_Rows = driver.findElements(By.xpath("//table/tbody/tr"));
		for(int i=1;i<=private_dash_Rows.size();i++) {
			String name = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/th//span/div//a")).getText();
			if(name.equalsIgnoreCase("Palanivel_Workout")) {
				count++;
				break;
			} 
		}
		if(count == 0) {
			System.out.println("Dashboard Not Present under Private Dashboard");
		} else {
			System.out.println("Dashboard Present under Private Dashboard, Its not deleted");
		}


	}

}
