package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AngularPracticeAssignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		
		driver.findElement(By.name("name")).sendKeys("Jose");
		driver.findElement(By.name("email")).sendKeys("cito@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("sparrow1");
		driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
		WebElement staticDropDown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticDropDown);
		dropdown.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("09/04/1999");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		// TODO Auto-generated method stub

	}

}
