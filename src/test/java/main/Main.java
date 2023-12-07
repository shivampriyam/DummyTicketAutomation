package main;

import org.openqa.selenium.WebDriver;

import WebDriver.ChromeDriver;
import pages.Checkout;
import pages.HomePage;

public class Main {
	static WebDriver driver = null;
	
	public static void main(String[] args) throws Exception {
		
		driver = new ChromeDriver().getDriver();
		
		new HomePage(driver).getHomePage()
							.searchBox("BackPack")
							.sortProduct()
							.selectProduct()
							.checkOut();
		
		new Checkout(driver).fillShippingAddress()
						.submitShippingAddress();
		
		ChromeDriver.quitDriver();
	}

}
