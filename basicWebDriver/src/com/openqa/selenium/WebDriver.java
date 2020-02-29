package com.openqa.selenium;
/*
 * 
 * basicWebDriver whole package export as .jar and add this .jar in another project build path
 * 
 */
public interface WebDriver 
{
	public void click(String location);
	public void sendKeys(String location, String value );
}
