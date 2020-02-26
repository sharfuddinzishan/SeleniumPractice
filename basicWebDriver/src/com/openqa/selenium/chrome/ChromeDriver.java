package com.openqa.selenium.chrome;

import com.openqa.selenium.WebDriver;

public class ChromeDriver implements WebDriver
{
	
	public ChromeDriver()
	{
		System.out.println("Chrome Driver Initialized");
	}
	
	@Override
	public void click(String location) 
	{
		System.out.println("You Click an element in Chrome- "+location);
	}

	@Override
	public void sendKeys(String location, String value) 
	{
		System.out.println("You type an element in Chrome- "+location+" with value "+value);	
	}
}
