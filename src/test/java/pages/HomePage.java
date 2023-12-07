package pages;

import java.util.Properties;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.PropertyUtility;

public class HomePage {
	HomePage homepage;
	WebDriver driver = null;
	String homePageURL;
	String title;
	String searchBoxId;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		Properties props = new PropertyUtility().loadProperty();
		
		homePageURL = props.getProperty("HomePageURL");
		title = props.getProperty("homepageTitle");
		searchBoxId = props.getProperty("searchBoxId");
	}
	
	public HomePage getHomePage() {
		driver.get(homePageURL);
		driver.manage().window().maximize();
		Boolean verifyTitle = driver.getTitle().equalsIgnoreCase(title);
		Assertions.assertTrue(verifyTitle, "Page verified");
		
		ThreadSleep();
		return this;
	}
	
	public HomePage searchBox(String searchText) {
		WebElement searchBox = driver.findElement(By.id("search"));
		searchBox.clear();
		searchBox.sendKeys(searchText + Keys.ENTER);
		ThreadSleep();
		
		Scroll(600);
		return this;
	}

	public HomePage sortProduct() {
		
		return this;
	}

	public HomePage selectProduct() {
		WebElement product = driver.findElement(By.className("product-item-info"));
		Actions actions = new Actions(driver);
//		product.click();
		
		actions.moveToElement(product).perform();
		ThreadSleep();
		System.out.println("_____________________________");
		product.findElement(By.className("tocart")).click();
		
		ThreadSleep();ThreadSleep();ThreadSleep();

		product.click();
		driver.findElement(By.id("product-addtocart-button")).click();
		ThreadSleep();ThreadSleep();ThreadSleep();
		return this;
	}

	public void checkOut() {
		driver.findElement(By.className("showcart")).click();
		driver.findElement(By.id("top-cart-btn-checkout")).click();
	}

	private void Scroll(int i) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+i+")", "");
		ThreadSleep();
	}

	private void ThreadSleep() {
		try {
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
