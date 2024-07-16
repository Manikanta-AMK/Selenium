package blogSpotSite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExcellUtil;

public class AllFunctionalities extends ExcellUtil {

	public static WebDriver driver;
	public static  ExcellUtil eu;
	public static Logger log;
	public static String log4jpath;

	@BeforeTest
	public void appLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String url = "https://testautomationpractice.blogspot.com/";
		driver.get(url);
		log4jpath = "C:\\Users\\phani\\eclipse-workspace\\Selenium\\testdata\\log4j";
		//log = Logger.getLogger("TestAutomationBlog");
	//	PropertyComparator.configure(log4jpath);
	}
	
	@Test
	public void pageTitleVerification()
	{
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = "Automation Testing Practice";
		
		if(actual.equals(expected))
		{
			Assert.assertEquals(actual, expected);
			System.out.println("Page Tilte is correct");
		}
	}

	@Test(priority=1)
	public  static void accDetails() throws Throwable {
		WebElement un = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement ph = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
		WebElement add = driver.findElement(By.xpath("//*[@id=\"textarea\"]"));

		String xlpath = "C:\\Users\\phani\\eclipse-workspace\\Selenium\\testdata\\blogspot.xlsx";
		eu = new ExcellUtil();
		int rowcount = eu.getRowCount(xlpath, "Sheet1");

		for (int i = 1; i <= rowcount; i++) {
			 String username = eu.getCellData(xlpath, "Sheet1", i, 0);
			String emailid = eu.getCellData(xlpath, "Sheet1", i, 1);
			String phonenumber = eu.getCellData(xlpath, "Sheet1", i, 2);
			String address = eu.getCellData(xlpath, "Sheet1", i, 3);

			un.sendKeys(username);
			email.sendKeys(emailid);
			ph.sendKeys(phonenumber);
			add.sendKeys(address);
		}	
		screenshot();
	}
	
	@Test(priority=2)
	public static  void checkboxes()
	{
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
		screenshot();
	}
}
	
	@Test(priority=3)
	public void weekcheckbox() throws InterruptedException
	{
		List<WebElement> wcheckbox = driver.findElements(By.xpath("//*[@class=\"form-check-input\" and @type='checkbox']"));
		
		//type1
		for(int i=0;i<wcheckbox.size();i++)
		{
			wcheckbox.get(i).click();
		}
		
		//type2
		for(WebElement checkbox:wcheckbox)
		{
			checkbox.click();
		}
		
		for(int j=0;j<wcheckbox.size();j++)
		{
			if(wcheckbox.get(j).isDisplayed())
			{
				if(wcheckbox.get(j).isEnabled())
				{
					if(wcheckbox.get(j).isSelected())
					{
						wcheckbox.get(j).clear();
						System.out.println("check boxs are unchecked");
					}else {
						wcheckbox.get(j).click();
						System.out.println("check boxs are checked");
					}
				}
			}
		}
		screenshot();
	}
	
	public void countrydrpdwn()
	{
		 driver.findElement(By.xpath("//*[@class=\"form-control\" and @id=\"country\"]")).click();
         List<WebElement> cntrydrpdwn = driver.findElements(By.xpath("//*[@class=\"form-control\" and @id=\"country\"]/option"));
         WebElement iterator =  driver.findElement(By.xpath("//*[@class=\"form-control\" and @id=\"country\"]/option"));
         
		 for(WebElement country: cntrydrpdwn)
		{
		      //country.
		}
	}

	@Test(priority=4)
	public void alerts()
		{ 
		
		//normal alert
			driver.findElement(By.xpath("//*[@onclick=\"myFunctionAlert()\"]")).click();
		    //screenshot();
		   Alert normalalert = driver.switchTo().alert();
		   System.out.println("alert text is: "+normalalert.getText());
		   normalalert.accept();
			
			//confirmation alert -accept
			driver.findElement(By.xpath("//*[@onclick=\"myFunctionConfirm()\"]")).click();
			//screenshot();
			Alert confirmalert = driver.switchTo().alert();
			System.out.println("confirmation alert text: "+confirmalert.getText());
			confirmalert.accept();
			
			//confirmation alert -dismiss/cancel
			driver.findElement(By.xpath("//*[@onclick=\"myFunctionConfirm()\"]")).click();
			//screenshot();
			driver.switchTo().alert().dismiss();
			
			//prompt alert
			driver.findElement(By.xpath("//*[@onclick=\"myFunctionPrompt()\"]")).click();
			Alert promptalert = driver.switchTo().alert();
			System.out.println(promptalert.getText());
			promptalert.sendKeys("Johnwick");
			driver.switchTo().alert().accept();
			WebElement actualtext = driver.findElement(By.xpath("//*[@id=\"demo\"]"));
			String expectedttext = "Hello Johnwick! How are you today?";
			Assert.assertEquals(actualtext.getText(),expectedttext);
			screenshot();
			
		}
	
	/*public void doubleclick()
	{
		WebElement dclick = driver.findElement(By .xpath("//*[@value=\"Hello World!\"]"));
		Actions action = new Actions(driver dclick);
		action.doubleClick();
	}*/
	
/*	public void actions(String )
	{
		Actions action = new Actions(driver);
		action.doubleClick();
	}*/
 
		
	public static File screenshot() 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String location = "C:\\Users\\phani\\eclipse-workspace\\Selenium\\screenshots\\"+System.currentTimeMillis();
		File dest = new File(location+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	

}
