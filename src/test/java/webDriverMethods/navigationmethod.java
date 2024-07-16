package webDriverMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class navigationmethod {

	@Test
	public static void navigationMethod() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://artoftesting.com/samplesiteforselenium");
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//ul//li//a[text()='Selenium Sample Script']")).click();
		String expectedName = "Selenium WebDriver Commands";
		
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(10));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expectedName)));
		
		WebElement actualName= driver.findElement(By.xpath("//*[text()='Selenium WebDriver Commands']"));
	    System.out.println(actualName);
		Assert.assertEquals(actualName, expectedName);
	    driver.navigate().back();
	    WebElement ActualTitle = driver.findElement(By.xpath("//*[text()='Sample Webpage for Automation Practice']"));
	    String expectedTitle = "Sample Webpage for Automation Practice";
	    
	   Assert.assertEquals(ActualTitle, expectedTitle);
	    
	    
	    System.out.println("done");
	    
	    driver.close();
	}
}
