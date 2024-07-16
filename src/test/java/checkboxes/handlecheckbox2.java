package checkboxes;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class handlecheckbox2 {
		@Test
		public static void checkbox() {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().deleteAllCookies();
			
			driver.findElement(By.id("name")).sendKeys("Manikanta");
			driver.findElement(By.id("email")).sendKeys("manikantaarige219@gmail.com");
			Random number = new Random();
			long randomnumber = number.nextLong(10);
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value=\"Male\"]")));
			
			WebElement num =  driver.findElement(By.id("phone"));
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript(String.valueOf(randomnumber), num);
		    
		    Random text = new Random();
		    String randomtext = text.toString();
		    
		    driver.findElement(By.id("textarea")).sendKeys(randomtext);
		//driver.findElement(By.xpath("//*[@class=\"form-check-label\" and text()='Male']")).click();
			WebElement Male = driver.findElement(By.xpath("//*[@class=\"form-check-label\" and text()='Male']"));
			WebElement Female = driver.findElement(By.xpath("//*[@class=\"form-check-label\" and text()='Female']"));
			
			Boolean MaleStatus = Male.isSelected();
			Boolean FemaleStatus = Female.isSelected();
			
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
			}driver.quit();
		}
		
	}