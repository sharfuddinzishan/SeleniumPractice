package com.openqa.selenium.firefox;

import com.openqa.selenium.WebDriver;

public class FirefoxDriver implements WebDriver
{
	
	public FirefoxDriver()
	{
		System.out.println("FireFox Driver Initialized");
	}
	
	@Override
	public void click(String location) 
	{
		System.out.println("You Click an element in FireFox- "+location);
	}

	@Override
	public void sendKeys(String location, String value) 
	{
		System.out.println("You type an element in FireFox- "+location+" with value "+value);	
	}
}
