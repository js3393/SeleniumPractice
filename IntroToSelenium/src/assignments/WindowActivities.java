package assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.WaitUtils;

public class WindowActivities {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://google.com"); 
//		driver.navigate().to("https://rahulshettyacademy.com"); //this wont wait until page is fully loaded unlike the driver.get(url) method
//		driver.navigate().back();   //will take you to previous website google.com
//		driver.navigate().forward(); // will take you back to rahul website
//		
//		
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		selectChildWindow(driver);

	}
	
	public static void selectChildWindow(WebDriver d) {
		d.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
		Set<String> windows = d.getWindowHandles();  //[parentid, childid]
		Iterator<String> it = windows.iterator();
		String parentId = it.next(); //will go to the next window (child)
		
		//Can go back to parent window by it.next twice
		String childId = it.next();
		d.switchTo().window(childId);
		By redEmailTextLocator = By.xpath("//p[@class='im-para red']");
		WaitUtils.waitForVisible(d, redEmailTextLocator);
		String redEmailText = d.findElement(redEmailTextLocator).getText();
		System.out.println(redEmailText);
		String emailId = d.findElement(redEmailTextLocator).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(emailId);
		d.switchTo().window(parentId);
		d.findElement(By.id("username")).sendKeys(emailId);

	}

}
