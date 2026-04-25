package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EndToEnd {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		DropDownPractice.runDropDownTest(driver);
		CalenderAutomation.runCalenderSelection(driver);
		CheckBoxPractice.runCheckBox(driver);
		ButtonPractice.runButtonTest(driver);
		Thread.sleep(10000);
		driver.quit();
		
	}

}
