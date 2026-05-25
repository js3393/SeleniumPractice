package assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utils.WaitUtils;

public class MultiWindow {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		
		WaitUtils.waitForVisible(driver, By.xpath("//div[@class='example']/h3"));
		
		String firstWindowText = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		System.out.println(firstWindowText);
		
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> windows = driver.getWindowHandles();  //[parentid, childid]
		Iterator<String> it = windows.iterator();
		
		String windowPage = it.next();
		String childPage = it.next();
		driver.switchTo().window(childPage);
		WaitUtils.waitForVisible(driver, By.xpath("//h3[text()='New Window']"));

		String newWindowText = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
		System.out.println(newWindowText);
	}

}
