package calendar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datepicker {

	@Test
	public static void main() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/datepicker/");
		
		driver.switchTo().frame(0);
		
		String year = "2023"; 
		String month = "December";
		String Date = "28";
				
		driver.findElement(By.id("datepicker")).click();
		
		while(true)
		{
			String mon = driver.findElement(By.className("ui-datepicker-month")).getText();
			String yr = driver.findElement(By.className("ui-datepicker-year")).getText();
			
			if(mon.equals(month) && yr.equals(year))
			{
				break;
			}
		//	driver.findElement(By.xpath("//*[@class=\"ui-icon ui-icon-circle-triangle-e\"]")).click();   //date forward
			driver.findElement(By.xpath("//*[@class=\"ui-icon ui-icon-circle-triangle-w\"]")).click();   // date backward
			
		}
		
	 	List<WebElement> alldates = driver.findElements(By.xpath("//*[@class=\"ui-datepicker-calendar\"]//td"));
		
		for(WebElement dates:alldates)
		{
			if(dates.getText().equals(Date))
			{
				dates.click();
				break;
			}
			System.out.println("date is: "+dates.getText());
		} 
		
		driver.quit();
	}

}
