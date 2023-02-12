package com.SimplePractice.TestCases;



import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.SimplePractice.PageObject.LoginPage;

public class TC001_LoginPage extends BaseClass
{
	
	@Test
	public void loginPage() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.getUserName(username);
		lp.getPassWord(password);
		lp.ClickLogin();
		
		System.out.println("WebPage Title is::"+driver.getTitle());
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);
		}
		else 
		{
			CaptureScreenshot(driver, "Login-Test");
			Assert.assertTrue(false);
			lp.ClickLogOut();
		}
	}
}
