package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass1;
import com.objectRepositoryx.LoginPage;

public class ShoppingCartValidationTest extends BaseClass1{
	String url = "https://demowebshop.tricentis.com/";
	String loginUrl = "https://demowebshop.tricentis.com/login";
	String email = "suhashgowda1234567@gmail.com";
	String password = "suhash@143";
	String cartUrl="https://demowebshop.tricentis.com/cart";

	@Test
	public void clickOnShoppingCart() {
		

		
		
		//click on shopping cart
		driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
		assert1.assertEquals(driver.getCurrentUrl(), cartUrl,"Shopping cart not able to click");
		Reporter.log("Shopping cart able to click",true);
	}
}
