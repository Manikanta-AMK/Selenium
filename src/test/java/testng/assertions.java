package testng;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assertions {

	@Test
	public void hardassert()
	{
		String name ="a";
		String name2 = "a";
		
		Assert.assertEquals(name, name2);
		
		Assert.assertTrue(false);
	}

	@Test
	public void softassert()
	{
		String name = "c";
		int a = 10;
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(name, a);
		
		sa.assertTrue(false);
	}

}
