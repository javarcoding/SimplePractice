package com.SimplePractice.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.SimplePractice.Utilities.ReadConfig;


public class BaseClass 
{
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void SetUp(String br)
	{
		if (br.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if (br.equals("edge")) 
		{
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver=new EdgeDriver();
		}
		
		driver.get(baseURL);
		System.out.println("WebPage URL::"+driver.getCurrentUrl());
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	public void CaptureScreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/screenshot/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken");
	}
}
