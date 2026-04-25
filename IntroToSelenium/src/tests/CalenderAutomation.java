package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CalenderAutomation {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		runCalenderSelection(driver);
	}
	

	public static void runCalenderSelection(WebDriver driver) throws InterruptedException {
		//Uncomment below if you want to run class stand alone
		//DropDownPractice.runDropDownTest(driver);
		
		
		//this will select the from and to destinations and will automatically open the calender
		WaitUtils.wait(driver, 2).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-state-default.ui-state-active")));
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
			System.out.println("Calender 2 is enabled");
			Assert.assertTrue(true);
			
		}
		else {
			Assert.assertTrue(false);
		}
		// TODO Auto-generated method stub

	}

}
