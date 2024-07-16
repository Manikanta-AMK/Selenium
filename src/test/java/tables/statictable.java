package tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class statictable {

	@Test
	public void staticTable()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		
		List<WebElement> tr = driver.findElements(By.xpath("//*[@name=\"BookTable\"]//tr"));
		System.out.println("Number of table rows: "+tr.size());
		int trcount=tr.size();
		
		List <WebElement> td = driver.findElements(By.xpath("//*[@name=\"BookTable\"]//tr//td"));
		System.out.println("Number of table data: "+td.size());
		int tdcount = td.size();
		
		List <WebElement> th = driver.findElements(By.xpath("//*[@name=\"BookTable\"]//tr//th"));
		System.out.println("Number of table coloumns: "+th.size());
		
	    String bookname = "nulll";
		for(WebElement tablerow: tr)
		{
			 bookname = tablerow.getText();
			if(bookname.contains("Master In Selenium")) 
			{
				System.out.println("bookname: "+bookname);
				for(int i=2;i<=trcount;i++)
				{
					for(int j=1;j<=tdcount;j++)
					{
						String data = driver.findElement(By.xpath("//*[@name=\"BookTable\"]//tr["+i+"]//td["+j+"]")).getText();
					      if(bookname.contains("Master In Selenium"))
					      {
					    	  System.out.println(data);
					      }
					
					}
				}
			}
		}

	}
}
