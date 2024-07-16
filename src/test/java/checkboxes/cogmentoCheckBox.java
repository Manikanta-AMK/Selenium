package checkboxes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cogmentoCheckBox {

	public static void main(String[] args) {
		
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://ui.cogmento.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	  
	  String actualTitle = driver.getTitle();
	  String expectedTitle = "Cogmento CRM";
	  System.out.println("Titlle is "+actualTitle);
	  Assert.assertEquals(actualTitle, expectedTitle);
	  
	  driver.findElement(By.name("email")).sendKeys("manikantaarige219@gmail.com");
	  driver.findElement(By.name("password")).sendKeys("Blackbeast319@");
	  driver.findElement(By.xpath("//*[text()='Login']")).click();
	  	  
	  driver.switchTo().frame(0);
	  driver.findElement(By.xpath("//*[text()='Contacts']")).click();
	  
	  WebElement dashboard = driver.findElement(By.xpath("//*[text()='Free account']"));
	  Assert.assertEquals(dashboard, "Free account");
		
	}
}
