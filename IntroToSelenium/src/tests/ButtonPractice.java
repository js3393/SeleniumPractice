package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonPractice {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		runButtonTest(driver);

	}
	
	public static void runButtonTest(WebDriver driver) throws InterruptedException {
		//Click submit button
		//Problem with this is that there are two elements for submit
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		Thread.sleep(3000);
		
		//this is the second item associated with submit. Not clickable
		//driver.findElement(By.id("ctl00_mainContent_ButtonSubmit_MST")).click();

	}

}
