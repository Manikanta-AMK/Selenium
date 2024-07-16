package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class annotations {

	@BeforeSuite
	public void a()
	{
		System.out.println("this is before suite");
	}
	
	@AfterSuite
	public void b()
	{
		System.out.println("this is after suite");
	}
	
	@BeforeTest
	public void c()
	{
		System.out.println("this is before test");
	}
	
	@AfterTest
	public void d()
	{
		System.out.println("this is after test");
	}
	
	@BeforeMethod
	public void e()
	{
		System.out.println("this is before method");
	}
	
	@AfterMethod
	public void f()
	{
		System.out.println("this is after method");
	}
	
	@BeforeClass
	public void g()
	{
		System.out.println("this is before class");
	}
	
	@AfterClass
	public void h()
	{
		System.out.println("this is after  class");
	}
	
}
