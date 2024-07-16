package dropdowns;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autosuggestdropdown {

	@Test
	public void autosuggest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//*[@title=\"Search\"]")).sendKeys("selenium");
		List<WebElement> dropdownlist = driver.findElements(By.xpath("//ul[@role=\"listbox\"]//div[@role='option']"));
		System.out.println("autosuggestions count: "+dropdownlist.size());
	
		for(int i=0;i<dropdownlist.size()-1;i++)
		{
			System.out.println(dropdownlist.get(i).getText());
		}
		
		for (WebElement value : dropdownlist) {
			value.click();
		}
		WebElement selectedvalue = driver.findElement(By.xpath("//*[@class=\"gLFyf\"]"));
		System.out.println("selected value: "+selectedvalue.getText());
		
/*		 String actualtext = null;
		for(WebElement option:dropdownlist)
		{
		    actualtext = option.getText();
		   if(actualtext.equalsIgnoreCase("selenium webdriver"))
		   {
			   option.click();
			   break;
		   }		   
		}
		
		WebElement selectedvalue = driver.findElement(By.xpath("//*[@class=\"gLFyf\"]"));
		String expectedtext = selectedvalue.getText();
		
		assertEquals(actualtext, expectedtext);
		
		System.out.println(actualtext);
		System.out.println(expectedtext);  */
		
	}
	
}
