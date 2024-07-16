package webDriverMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browsercommands {

	@Test
	public static void browserCommands() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));

		driver.get("https://artoftesting.com/samplesiteforselenium");
		// close
		//driver.close();

		// get window handle
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[text()='OrangeHRM, Inc']")).click();
		
		// close
		driver.close();
		
		Thread.sleep(5000);
		
		//quite
		driver.quit();
		
		System.out.println("done");

	}
}
