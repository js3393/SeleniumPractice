package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckBoxPractice {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		runCheckBox(driver);
	}

	public static void runCheckBox(WebDriver driver) {
		//Get target website and initialize driver
		//driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily'")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily'")).isSelected());
		
		//print the number of checkboxes present. findElements will find all elemers with tag
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		// TODO Auto-generated method stub
		

		//Assert.assertFalse(true);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		//driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		

		

	}

}
