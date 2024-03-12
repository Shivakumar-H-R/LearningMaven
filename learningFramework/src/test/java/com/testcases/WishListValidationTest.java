package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass1;

public class WishListValidationTest extends BaseClass1 {
	String url = "https://demowebshop.tricentis.com/";
	String loginUrl = "https://demowebshop.tricentis.com/login";
	String email = "suhashgowda1234567@gmail.com";
	String password = "suhash@143";
	String wishlistMessage="The product has been added to your wishlist";
	@Test
	public void wishListValidation() {
		

		
	
		// search product and add to cart
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Book", Keys.ENTER);
	    driver.findElement(By.xpath("(//a/img[@alt='Picture of Health Book'])[2]")).click();
	    driver.findElement(By.xpath("//input[@id='add-to-wishlist-button-22']")).click();
	    WebElement message = driver.findElement(By.xpath("//p[contains(text(),'The product has been added to your')]"));
	    assert1.assertEquals(wishlistMessage, message,"product is not addded to wishlist");
	    Reporter.log("product is addded to wishlist",true);
	}
}
