package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.utilityclasses.FrameworkConstants;

public class BaseClass1 implements FrameworkConstants {
	//push first time
 public WebDriver driver;
 public SoftAssert assert1;
  @Parameters("browserName")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) {
	  if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			Reporter.log("browser is launched",true);
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {

          driver=new FirefoxDriver();
		}
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     driver.get("https://demowebshop.tricentis.com/");
      assert1=new SoftAssert();
	}
	
	@BeforeMethod
	public void logIn() throws InterruptedException {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("shivakumar321123@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("1234567");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@AfterMethod
	public void logOut() {
		driver.findElement(By.linkText("Log out")).click();
	}
	
	@AfterClass
	public void quite() {
		driver.quit();
	}
}
