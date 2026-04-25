package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	private static final int DEFAULT_TIMEOUT = 10;
	
	public static WebDriverWait wait(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
	}
	
	public static WebDriverWait wait(WebDriver driver, int sec) {
		return new WebDriverWait(driver, Duration.ofSeconds(sec));
	}

}
