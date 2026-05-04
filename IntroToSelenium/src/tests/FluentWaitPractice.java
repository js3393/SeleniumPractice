package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.testng.AssertJUnit.assertEquals;
import static utils.WaitUtils.fluentWait;

public class FluentWaitPractice {
    public static void main(String[] args){
        WebDriver driver = new EdgeDriver();

        try{
            By startBtn = By.cssSelector("[id='start'] button");
            By finishText = By.cssSelector("[id='finish'] h4");

            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
            driver.findElement(startBtn).click();

            //See fluentWait in WaitUtils
            String text = fluentWait(driver, finishText).getText();

            assertEquals("Hello World!", text);

        } finally {

            driver.quit();
        }


    }
}
