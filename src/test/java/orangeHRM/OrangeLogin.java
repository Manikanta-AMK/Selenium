package orangeHRM;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExcellUtil;

public class OrangeLogin {

	 static WebDriver driver;
	
	@Test
	public void Login() throws Throwable {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		String filepath = "C:\\Users\\phani\\eclipse-workspace\\Selenium\\testdata\\accoutdetails2.xlsx";
	    int rows  = ExcellUtil.getRowCount(filepath, "Sheet1");
	    
	    for(int i=1;i<=rows;i++)
	    {
	    	String username = ExcellUtil.getCellData(filepath, "Sheet1", i, 0);
	    	String password = ExcellUtil.getCellData(filepath, "Sheet1", i, 1);
	    	
	    	driver.findElement(By.xpath("//*[@name=\"username\"]")).sendKeys(username);
	    	driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys(password);
	    }
	    screenshot();
	    driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

	    String  expected = "Dashboard";
	    String actual = driver.findElement(By.xpath("//*[@class=\"oxd-topbar-header-breadcrumb\"]")).getText();
	    System.out.println("actual text: "+actual);
	    Assert.assertEquals(actual, expected);
     }
	
	public static void screenshot() throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String location = "C:\\Users\\phani\\eclipse-workspace\\Selenium\\Screenshots\\img";
		File dest = new File(location+".png");
		Files.copy(src, dest);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}

