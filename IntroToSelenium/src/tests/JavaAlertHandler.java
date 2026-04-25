package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaAlertHandler {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		runWindow2AlertTest(driver);

	}
	
	public static void runWindowAlertTest(WebDriver driver) {
		String text = "Cito";
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();

		// Gets to the alert window and print to console
		System.out.println(driver.switchTo().alert().getText());
		Assert.assertEquals(driver.switchTo().alert().getText(),
				"Hello " + text + ", share this practice page and share your knowledge");
		// accepts the alert (by clicking ok)
		driver.switchTo().alert().accept();
		
	}
	public static void runWindow2AlertTest(WebDriver driver) {
		String text = "Cito";
		driver.findElement(By.id("name")).sendKeys(text);

		// Alert with two options
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());

		Assert.assertEquals(driver.switchTo().alert().getText(),
				"Hello " + text + ", Are you sure you want to confirm?");
		// Cancel alert
		driver.switchTo().alert().dismiss();
		
	}

}
