package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItemsToCart {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		runGreenKartTest(driver);
		// TODO Auto-generated method stub

	}
	
	public static void runGreenKartTest(WebDriver driver) {
		
		String[] productName = {"Cucumber", "Brocolli"};
		List<WebElement> products = driver.findElements(By.cssSelector
		("h4.product-name"));
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getText().contains(productName[i])) {
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
		}
		
		}
	}

}
