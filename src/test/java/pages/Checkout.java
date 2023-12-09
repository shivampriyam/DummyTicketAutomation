package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.PropertyUtility;

public class Checkout {
	WebDriver driver = null;
	public Checkout(WebDriver driver){
		this.driver = driver;
		Properties props = new PropertyUtility().loadProperty();
	}
	public Checkout fillShippingAddress() {
		fillShippingDetails();
		return this;
	}
	public Checkout submitShippingAddress() {
		driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div/button")).click();
		ThreadSleep();ThreadSleep();ThreadSleep();
		checkPasswordField();
		driver.findElement(By.xpath("//button[@class='action login primary']")).click();
//		driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div/button")).click();
		return this;
	}
	

	private void fillShippingDetails() {
		ThreadSleep();ThreadSleep();ThreadSleep();
		fillElement("ById", "customer-email", "abc@gmail.com");
		fillElement("ByXpath", "//div[@name='shippingAddress.firstname']/div/input", "Shivam");
		fillElement("ByXpath", "//div[@name='shippingAddress.lastname']/div/input", "Shivam");
		fillElement("ByXpath", "//div[@name='shippingAddress.company']/div/input", "ABC Corp. Ltd");
//		fillElement("ByXpath", "//div[@name='shippingAddress.street']/div/input", "ABC Corp. Ltd");
		fillElement("ByXpath", "//div[@name='shippingAddress.street.0']/div/input", "ABC Corp. Ltd");
		fillElement("ByXpath", "//div[@name='shippingAddress.city']/div/input", "ABC Corp. Ltd");
		SelectElement("ByName", "country_id", "India");
		SelectElement("ByName", "region_id", "Karnataka");
		fillElement("ByXpath", "//div[@name='shippingAddress.postcode']/div/input", "ABC Corp. Ltd");
		fillElement("ByXpath", "//div[@name='shippingAddress.telephone']/div/input", "ABC Corp. Ltd");
	}
	
	private void checkPasswordField() {
		try {System.out.println("Password Checking");
			if(driver.findElement(By.id("customer-password")).isDisplayed())
				fillElement("ById", "customer-password", "Abcd1234");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void SelectElement(String locatorType, String locatorText, String textField) {
		Select select = new Select(driver.findElement(By.name(locatorText)));
		select.selectByVisibleText(textField);
	}
	private void fillElement(String locatorType, String locatorText, String textField) {
		WebElement elem = null;
		if(locatorType.equalsIgnoreCase("ById"))
			elem = driver.findElement(By.id(locatorText));
		else if(locatorType.equalsIgnoreCase("ByClass"))
			elem = driver.findElement(By.className(locatorText));
		else if(locatorType.equalsIgnoreCase("ByName"))
			elem = driver.findElement(By.name(locatorText));
		else if(locatorType.equalsIgnoreCase("ByXpath"))
			elem = driver.findElement(By.xpath(locatorText));
		elem.clear();
		elem.sendKeys(textField);
	} 

	private void ThreadSleep() {
		try {
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
