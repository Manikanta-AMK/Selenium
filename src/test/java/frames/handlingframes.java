package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingframes {

	@Test
	public void frames() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://ui.vision/demo/webtest/frames/");
		
		//frame1
		WebElement frame1 = driver.findElement(By.xpath("//*[@src=\"frame_1.html\"]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//*[@type=\"text\"]")).sendKeys("hello");
		driver.switchTo().defaultContent();
		
		//frame2
		WebElement frame2 = driver.findElement(By.xpath("//*[@src=\"frame_2.html\"]"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//*[@type=\"text\"]")).sendKeys("how");
		driver.switchTo().defaultContent();

		//frame3
		WebElement frame3 = driver.findElement(By.xpath("//*[@src=\"frame_3.html\"]"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//*[@type=\"text\"]")).sendKeys("are");
		
		//inner frame -part of frame3
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@class=\"Od2TWd hYsg7c\"]")).click();
		driver.findElement(By.xpath("//*[text()='General Web Automation']")).click();
		driver.findElement(By.xpath("//*[@class=\"ry3kXd\" and @jsname=\"d9BH4c\"]")).click();
		WebElement drpdwn = driver.findElement(By.xpath("//*[@class=\"ry3kXd\" and @jsname=\"d9BH4c\"]//child::div//span[text()='Yes']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", drpdwn);
		
		driver.switchTo().defaultContent();

		//frame4
		WebElement frame4 = driver.findElement(By.xpath("//*[@src=\"frame_4.html\"]"));
		driver.switchTo().frame(frame4);
		driver.findElement(By.xpath("//*[@type=\"text\"]")).sendKeys("you");
		driver.switchTo().defaultContent();

		//frame5
		WebElement frame5 = driver.findElement(By.xpath("//*[@src=\"frame_5.html\"]"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.xpath("//*[@type=\"text\"]")).sendKeys("whats u r name");
		
		driver.quit();
		
	}

}
