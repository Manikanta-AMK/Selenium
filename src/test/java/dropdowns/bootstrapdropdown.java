package dropdowns;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bootstrapdropdown {

	@Test
	public void bootstrap() throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_6");
		/*driver.findElement(By.xpath("//*[@class=\"btn-group\"]")).click();
		WebElement css = driver.findElement(By.xpath("//*[text()='CSS']"));
		css.click();
		
		String exepctedtitile = "CSS";
		
		Assert.assertEquals(driver.getTitle(), exepctedtitile, "title is correct");
		Thread.sleep(5000);
		driver.navigate().back();*/
		String exepctedtitile = "CSS";
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class=\"btn-group\"]")).click();
		List<WebElement> options = driver.findElements(By.xpath("//*[@class=\"dropdown-menu show\"]"));
		
		int count = options.size();
		System.out.println("count is "+count);
		
		for(WebElement option: options)
		{
			String text = option.getText();
			if(text.equals(exepctedtitile))
			{
				option.click();
		
			}
		}
		Assert.assertEquals(driver.getTitle(), exepctedtitile, "title is correct");
	}
	
}
