package Alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javascriptalert {

		@Test
		public void alert() throws InterruptedException
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get("https://the-internet.herokuapp.com/javascript_alerts");
			
			//normal alert
			WebElement normalAlert = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
			normalAlert.click();
			Alert alert= driver.switchTo().alert();
			alert.accept();
			
			//confirm alert - accept
			WebElement confirmAlert = driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"));
			confirmAlert.click();
			driver.switchTo().alert().accept();
			
			//confirm alert -cancel
			WebElement confirmAlert2 = driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"));
			confirmAlert2.click();
			driver.switchTo().alert().accept();
			
			//prompt alert
			WebElement promptAlert = driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"));
			promptAlert.click();
			Alert prompt = driver.switchTo().alert();
			prompt.sendKeys("hi");
			Thread.sleep(5000);
			prompt.accept();
			WebElement actual = driver.findElement(By.xpath("//*[@id=\"result\"]"));
			String expected = "You entered: hi";
			
			Assert.assertEquals(actual.getText(), expected);
			
			driver.close();
		}
}
