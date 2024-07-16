package webDriverMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class conditionalMethods {

	@Test
	public static void conditionalmethods() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
		
		driver.get("https://artoftesting.com/samplesiteforselenium");
		
		//is displayed
		WebElement headline = driver.findElement(By.xpath("//*[text()='Sample Webpage for Automation Practice']"));
		if(headline.isDisplayed())
		{
			System.out.println("head line is displayed");
		}
		
		//is enabled
		WebElement textbox = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
		if(textbox.isDisplayed())
		{
			System.out.println("text box is displayed");
			if(textbox.isEnabled())
			{
				System.out.println("textbox is enabled");
				textbox.sendKeys("Hello");
				driver.findElement(By.xpath("//*[@id=\"idOfButton\"]")).click();
				System.out.println("Message is: "+textbox.getText());
			}
		}
		
		//is selected
		WebElement radiobtn = driver.findElement(By.id("male"));
		radiobtn.click();
		if(radiobtn.isSelected())
		{
			System.out.println("Radio button has been selected ");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
		
		WebElement checkbx = driver.findElement(By.className("Automation"));
		checkbx.click();
		boolean checkbox = checkbx.isSelected();
		if(checkbx.isSelected())
		{
			System.out.println("checkbox has been selected");
			System.out.println(checkbox);
		}
		
		driver.quit();		
		
	}
}
