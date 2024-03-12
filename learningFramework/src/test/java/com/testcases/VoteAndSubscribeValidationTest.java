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

public class VoteAndSubscribeValidationTest  extends BaseClass1{
	String url = "https://demowebshop.tricentis.com/";
	String loginUrl = "https://demowebshop.tricentis.com/login";
	String email = "basavaraju123@gmail.com";
	String password = "1234567";

	@Test
	public void voteValidation() {
	


		//click on vote option
		driver.findElement(By.xpath("//label[contains(text(),'Excellent')]")).click();
		boolean selected = driver.findElement(By.xpath("//label[contains(text(),'Excellent')]")).isSelected();
	    assert1.assertEquals(selected, true,"vote is not selected");
	    Reporter.log("vote is selected",true);
	    
	    driver.findElement(By.xpath("//input[@value='Vote']")).click();
	    Reporter.log("Vote is submited",true);
	}
}
