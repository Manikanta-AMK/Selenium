package checkboxes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleCheckboxes {

	@Test
	public static void checkboxes2() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		//driver.manage().deleteAllCookies();
		
		driver.findElement(By.name("firstname")).sendKeys("Manikanta");
		driver.findElement(By.name("lastname")).sendKeys("A");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value=\"Male\"]")));
		WebElement Male = driver.findElement(By.xpath("//*[@value=\"Male\"]"));
		WebElement Female = driver.findElement(By.xpath("//*[@value=\"Female\"]"));
		
		Boolean MaleStatus = Male.isSelected();
		Boolean FemaleStatus = Female.isSelected();
		
		/*WebElement alert = driver.findElement(By.xpath("//*[@id=\"ez-video-ez-stuck-close-ez-3998\"]"));
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement close = wait2.until(ExpectedConditions.visibilityOf(alert));
		close.click();*/
		
		if(MaleStatus.equals(false))
		{
			if(FemaleStatus.equals(false))
			{
				if(Female.isSelected()==true)
				{
					Boolean femaleRdbtndsply = Female.isDisplayed();
					Boolean femaleRdbtnenbl = Female.isEnabled();
					System.out.println("femaleRdbtn is dispalyed: "+femaleRdbtndsply);
					System.out.println("femaleRdbtn is enabled: "+femaleRdbtnenbl);
				}
				if(Male.isSelected()==false)
				{
					Boolean maleRdbtndsply = Male.isDisplayed();
					Boolean maleRdbtnenbl = Male.isEnabled();
					System.out.println("maleRdbtn is dispalyed: "+maleRdbtndsply);
					System.out.println("femaleRdbtn is enabled: "+maleRdbtnenbl);
					Male.click();
					System.out.println("Male radio button has been selected: "+MaleStatus);
				}
			}
		}
		
	//	List<WebElement> expRadiobtns = driver.findElements(By.xpath("//*[@name=\"exp\"]"));
		
//		for(WebElement ExpRadioBtn: expRadiobtns)
		{
			
		}
				driver.quit();
		
	}
	
}
