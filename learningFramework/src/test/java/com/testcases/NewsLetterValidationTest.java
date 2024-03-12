package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass1;

public class NewsLetterValidationTest  extends BaseClass1{
	String url = "https://demowebshop.tricentis.com/";
	String email = "suhashgowda1234567@gmail.com";
	String message="Thank you for signing up! A verification email has been sent. We appreciate your interest.";
	@Test
	public void newsLetterValidation() {
		
		//enter Tricentis to get newsletter
		driver.findElement(By.linkText("Tricentis")).click();
		WebElement element = driver.findElement(By.id("newsletter-subscribe-button"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",element );
	
		//enter email id and click on subscribe button
		driver.findElement(By.id("newsletter-email")).sendKeys(email);
		driver.findElement(By.id("newsletter-subscribe-button")).click();
		WebElement element1 = driver.findElement(By.xpath("//div[@id='newsletter-result-block']"));
	    SoftAssert assert1=new SoftAssert();
	    assert1.assertEquals(message, element,"Subscribe not done");
	    Reporter.log("Subscribe done",true);
	}
}
