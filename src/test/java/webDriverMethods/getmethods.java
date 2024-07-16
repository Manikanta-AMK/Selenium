package webDriverMethods;

import java.util.Set;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getmethods {

	@Test
	public static void getMethods() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		//get() 
		driver.get("https://flipkart.com");
		
		//get title()
		System.out.println("title of the page: "+driver.getTitle());
		
		//get currentUrl
		System.out.println("Url of the site is: "+driver.getCurrentUrl());
		
		//get window ID
		System.out.println("flipkart window id: "+driver.getWindowHandle());
		
		//get window handle
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[text()='OrangeHRM, Inc']")).click();

		
		//get window handles
		Set<String> windows = driver.getWindowHandles();
		System.out.println(" ");
		
		for(String allwindows: windows)
		{
			driver.switchTo().window(allwindows);
			System.out.println("current URL is: "+driver.getCurrentUrl());
			System.out.println("title of the page: "+driver.getTitle());
			System.out.println("window ID: "+windows);
			System.out.println(" ");
		}
		
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies);
		
		driver.quit();
		
	}
}
