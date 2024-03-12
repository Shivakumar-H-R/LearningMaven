package com.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass1;
import com.objectRepositoryx.HomePage;
import com.objectRepositoryx.LoginPage;
import com.utilityclasses.DataUtilityClass;

public class ToLoginAndLogOutValidationTest extends BaseClass1 {

		@Test
	public void logInLogOut() throws InterruptedException, IOException {
			DataUtilityClass data=new DataUtilityClass();
			String url = data.readingDataFromPropertyFile(path,"url");
			String loginUrl = data.readingDataFromPropertyFile(path,"loginurl");
			String email =data.readingDataFromPropertyFile(path,"email");
			String password = data.readingDataFromPropertyFile(path,"password");
			String cartMessage = data.readingDataFromPropertyFile(path,"cartMessage");


		// search product and add to cart
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Book", Keys.ENTER);
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		WebElement cartmessage1 = driver
				.findElement(By.xpath("//p[contains(text(),'The product has been added to your')]"));
		assert1.assertEquals(cartMessage, cartmessage1, "product not added to cart");
		Reporter.log("Product added to cart", true);
		
		Thread.sleep(2000);
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		executor.executeScript("window.scrollBy(0,500);");
		

	}
}
