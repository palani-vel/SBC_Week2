package saturn_Sprint1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Param_Sort_Code {

	public static void main(String[] args) throws InterruptedException {
				// Setup Edge driver and path
				WebDriverManager.edgedriver().setup();

				// Launch Edge Browser
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--disable-notifications");

				EdgeDriver driver = new EdgeDriver(options);

				//1. Launch login.salesforce.com site
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
				
				//Get AccountNames
				Thread.sleep(2000);
				//driver.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				//driver.executeScript("window.scrollBy(0,250)", "");
				driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table/tbody/tr[15]")));
				Thread.sleep(2000);
				driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table/tbody/tr[45]")));
				Thread.sleep(2000);
				driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table/tbody/tr[75]")));
				Thread.sleep(2000);
				driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table/tbody/tr[100]")));
				Thread.sleep(2000);
				driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table/tbody/tr[150]")));
				Thread.sleep(2000);
				List<WebElement> acc_Name = driver.findElements(By.xpath("//table/tbody/tr"));
				System.out.println("No of Rows: "+acc_Name.size());
				
				ArrayList<String> acc_Name_List = new ArrayList<String>();
				
				for(int i=1;i<=acc_Name.size();i++) {
					String dis_Text = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/th//a")).getAttribute("title");
					acc_Name_List.add(dis_Text);
				}
				
				Collections.sort(acc_Name_List);
				System.out.println(acc_Name_List);
				
				System.out.println("Size of acc_Name_List: "+acc_Name_List.size());
				
				//Click Sort Arrow
				WebElement scroll = driver.findElement(By.xpath("//table/thead/tr/th[3]//a"));
				driver.executeScript("arguments[0].scrollIntoView(true);", scroll);
				Thread.sleep(2000);
				scroll.click();
				Thread.sleep(5000);
				
				driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table/tbody/tr[15]")));
				Thread.sleep(2000);
				driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table/tbody/tr[45]")));
				Thread.sleep(2000);
				driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table/tbody/tr[75]")));
				Thread.sleep(2000);
				driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table/tbody/tr[100]")));
				Thread.sleep(2000);
				driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table/tbody/tr[150]")));
				Thread.sleep(2000);
				List<WebElement> acc_Name_Sort = driver.findElements(By.xpath("//table/tbody/tr"));
				System.out.println("No of Rows: "+acc_Name_Sort.size());
				
				ArrayList<String> acc_Name_List_Sort = new ArrayList<String>();
				
				for(int i=1;i<=acc_Name_Sort.size();i++) {
					String dis_Text = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/th//a")).getAttribute("title");
					acc_Name_List_Sort.add(dis_Text);
				}
				
				System.out.println("Size of acc_Name_List: "+acc_Name_List_Sort.size());
				System.out.println(acc_Name_List_Sort);
				
				if(acc_Name_List.equals(acc_Name_List_Sort)) {
					System.out.println("Account Name Sorted in Ascending Order");
				} else {
					System.out.println("Account Name NOT Sorted in Ascending Order");
				}
	}

}
