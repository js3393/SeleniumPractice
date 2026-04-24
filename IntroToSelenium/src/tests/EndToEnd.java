package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EndToEnd {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		DropDownPractice.runDropDownTest(driver);
		CalenderAutomation.runCalenderSelection(driver);
	}

}
