package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com"); 
		driver.navigate().to("https://rahulshettyacademy.com"); //this wont wait until page is fully loaded unlike the driver.get(url) method
		driver.navigate().back();   //will take you to previous website google.com
		driver.navigate().forward(); // will take you back to rahul website
		// TODO Auto-generated method stub

	}

}
