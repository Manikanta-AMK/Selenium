package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hiddendropdown {

	@Test
	public void hiddendrpdwn()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//*[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[text()=' Login ']")).click();
		
		driver.findElement(By.xpath("//*[text()='PIM']")).click();
		driver.findElement(By.xpath("//*[text()='Job Title']//parent::div//following-sibling::div")).click();
		driver.findElement(By.xpath("//*[text()='Automaton Tester']")).click();
		
		driver.findElement(By.xpath("//*[text()='Job Title']//parent::div//following-sibling::div")).click();
		List<WebElement> options =  driver.findElements(By.xpath("//*[@role=\"option\"]"));
		
		System.out.println("count of options "+options);
		
		for(WebElement option: options)
		{
			System.out.println("roles "+option.getText());
			
		}
		System.out.println("roles "+options.size());
	}
}
