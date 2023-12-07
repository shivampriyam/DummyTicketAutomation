package WebDriver;

import org.openqa.selenium.WebDriver;

public class ChromeDriver {
	static WebDriver driver = null;
	
	public WebDriver getDriver() {
		driver = (WebDriver) new org.openqa.selenium.chrome.ChromeDriver();
		return driver;
	}
	
	public static void quitDriver() {
		driver.quit();
	}
}
