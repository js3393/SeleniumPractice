package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderAutomation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		DropDownPractice.runTest(driver);
		
		//this will select the from and to destinations and will automatically open the calender
		
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
