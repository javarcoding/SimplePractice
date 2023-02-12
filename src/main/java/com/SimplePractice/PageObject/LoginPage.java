package com.SimplePractice.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtusername;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[text()=\"Log out\"]")
	@CacheLookup
	WebElement lnkLogout;
	
	public void getUserName(String uname)
	{
		txtusername.sendKeys(uname);
	}
	
	public void getPassWord(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void ClickLogin()
	{
		btnLogin.click();
	}
	
	public void ClickLogOut()
	{
		lnkLogout.click();	
	}
	
}
