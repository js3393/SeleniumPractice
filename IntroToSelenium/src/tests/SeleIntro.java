package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleIntro {

	public static void main(String[] args) {
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("inputUsername")).sendKeys("cito91");
		driver.findElement(By.name("inputPassword")).sendKeys("sparrowx1");
		//driver.findElement(By.name("chkboxtwo")).click();
		driver.findElement(By.className("submit")).click();
		//The below print statement needs to wait a few seconds for the error message to pop up
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); 
		driver.findElement(By.linkText("Forgot your password?")).click();
		//Since this is a single page application, after you click forgot password, need time for the page to load the form with buttons
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("cito91");
		driver.findElement(By.xpath("//input[@placeholder='Name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("cito91");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("cito@gmail.com");
		//Below code is the xpath version of the above code except it will clear the text box
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("someEmail@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("password1");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("cito91");
		
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.id("chkboxOne")).click();
		
		driver.findElement(By.id("chkboxTwo")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		try {
			Thread.sleep(6000); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(d -> ((ChromeDriver)d).getTitle().length() > 0);
		driver.close();
		//can also do driver.quit(); it closes every associated window
		
		//Firefox- FirefoxDriver -> Methods
		//FirefoxDriver foxDriver = new FirefoxDriver();
		// TODO Auto-generated method stub

	}

}
