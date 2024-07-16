 package Alerts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import blogSpotSite.AllFunctionalities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class alerts extends AllFunctionalities{

	@Test
	public void alert()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement normalAlert = driver.findElement(By.xpath("//*[@onclick=\"myFunctionAlert()\"]"));
		normalAlert.click();
		AllFunctionalities.screenshot();
		driver.switchTo().alert().accept();
		
	}
}
