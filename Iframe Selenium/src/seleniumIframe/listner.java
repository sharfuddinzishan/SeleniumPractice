package seleniumIframe;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class listner implements WebDriverEventListener 
{

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		System.out.println("Alert Accepted");	
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		System.out.println("Alert Dismissed");	
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		System.out.println("Value Changes");	
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("After Click On");	
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("After FindBy Element");	
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		System.out.println("ScreenShot Taken");	
	}

	@Override
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		System.out.println("Desired Text Taken " +arg2);	
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		System.out.println("After Navigate Back");	
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		System.out.println("After Navigate Forword");	
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		System.out.println("After Navigate Refresh");	
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		System.out.println("After Navigate To " +arg0);	
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		System.out.println("After Script");	
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("After Switch To Window " +arg0);	
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		System.out.println("Before Alert Accept");	
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		System.out.println("Before Alert Dismiss");	
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		System.out.println("Before Change Value");	
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("Before Click On Item");
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("Before FindBy Web Element");
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		System.out.println("Before GetScreenShot");
	}

	@Override
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		System.out.println("Before Get Text");	
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		System.out.println("Before Navigate Back");	
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		System.out.println("Before Navigate Forword");	
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		System.out.println("Before Navigate Refresh");
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		System.out.println("Before Navigate To " +arg0);
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		System.out.println("Before Script");
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("Before Switch To Window");
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		System.out.println("onException");
	}

}
