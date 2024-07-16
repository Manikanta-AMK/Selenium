package tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class statictable2 {

	//@Test
	public void staticTable()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		
		int tr = driver.findElements(By.xpath("//*[@name=\"BookTable\"]//tr")).size();
		System.out.println("count of  table rows: "+tr);
		
		int td = driver.findElements(By.xpath("//*[@name=\"BookTable\"]//tr//td")).size();
		System.out.println("count of table data: "+td);
		
		int th = driver.findElements(By.xpath("//*[@name=\"BookTable\"]//tr//th")).size();
		System.out.println("count of table coloumns: "+th);
		
		for(int i=2;i<=tr;i++)
				{
					for(int j=1;j<=td;j++)
					{
						String data = driver.findElement(By.xpath("//*[@name=\"BookTable\"]//tr["+i+"]//td["+j+"]")).getText();
					      if(data.contains("Master In Selenium"))
					      {
					    	  System.out.println(data);
					      }
					
					}
				}
			}
	@Test
	public void statictable()
	{
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://testautomationpractice.blogspot.com/");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Find all rows in the table
	    List<WebElement> rows = driver.findElements(By.xpath("//*[@name='BookTable']//tr"));
	    System.out.println("Number of rows in the table: " + rows.size());

	    // Loop through each row (start from index 1 to skip header row)
	    for (int i = 1; i < rows.size(); i++) {
	        // Find all cells in the current row
	        List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
		    
	        // Loop through each cell in the current row
	        for (WebElement cell : cells) {
	            String data = cell.getText();
	            if (data.contains("Master In Selenium")) {
	                System.out.println(data);
	            }
	        }
	    }

	    driver.quit();
	}
}
