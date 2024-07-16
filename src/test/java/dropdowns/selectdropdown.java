package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectdropdown {

	@Test
	public static  void dropdown()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@id=\"country\"]"));
		Select drpdwn = new Select(dropdown);
		drpdwn.selectByIndex(1);
		try
		{
			Thread.sleep(5000);
		}catch(Exception e){
			e.printStackTrace();
		}
		drpdwn.selectByValue("india");
		drpdwn.selectByVisibleText("China");
		System.out.println("count of the dropdowns "+dropdown.getSize());
		List<WebElement> options = drpdwn.getOptions();
		System.out.println(options.size());
		
		//normal forloop
		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}
		
		System.out.println(" ");
		
		//enhanced forloop
		for(WebElement op: options)
		{
			System.out.println(op.getText());
		}
		
		driver.quit();
	
		
	}
}
