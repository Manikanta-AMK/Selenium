package Alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingAlertsWithExpectedCondition {

	//handling alerts with switch to alerts
	@Test
	public static void alert(){
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//normal alert
		driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Alert alert = mywait.until(ExpectedConditions.alertIsPresent());
		System.out.println("text is "+alert.getText());
		alert.accept();
		
		//confirm alert - accept
		driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
		Alert confirmAlert = mywait.until(ExpectedConditions.alertIsPresent());
		confirmAlert.accept();
		
		//confirm alert -cancel
		driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
	    Alert confirmAlert2 = mywait.until(ExpectedConditions.alertIsPresent());
		confirmAlert2.dismiss();
		
		//prompt alert
		driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
		Alert promptAlert = mywait.until(ExpectedConditions.alertIsPresent());
		promptAlert.sendKeys("hi");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		promptAlert.accept();
		WebElement actual = driver.findElement(By.xpath("//*[@id=\"result\"]"));
		String expected = "You entered: hi";
		
		Assert.assertEquals(actual.getText(), expected);
		
		driver.switchTo().newWindow(WindowType.TAB).switchTo();
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
	/*	Alert authAlert = mywait.until(ExpectedConditions.alertIsPresent());
		authAlert.sendKeys("admin");
		authAlert.sendKeys("admin");
		authAlert.accept(); */
		
		String actualtext = driver.findElement(By.xpath("//*[@class=\"example\"]//p")).getText();
		String expectedtext = "Congratulations! You must have the proper credentials.";
		Assert.assertEquals(actualtext, expectedtext);
		driver.quit();
		
	}
}
