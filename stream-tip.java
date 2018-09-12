package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testrun {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testrun() throws Exception {
	  
	//Enter to this URL
    driver.get("http://localhost:8080/#/");
	
	//clcik on the username field
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your username'])[1]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your username'])[1]/following::input[1]")).clear();
	
	//Enter 'admin' in the username field
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your username'])[1]/following::input[1]")).sendKeys("admin");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your password'])[1]/following::input[1]")).clear();
	
	//Enter password' in the password field
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your password'])[1]/following::input[1]")).sendKeys("password");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your password'])[1]/following::input[2]")).click();
    
	//Click logon
	driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.xpath("//div[@id='app']/div/div")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your password'])[1]/following::input[2]")).click();
	
	//select gif

    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Or select a gif'])[1]/following::video[1]")).click();
	
	//pres continue
    driver.findElement(By.linkText("Continue")).click();
	
	// new screen popp up
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter a tip amount (min $1)'])[1]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter a tip amount (min $1)'])[1]/following::input[1]")).clear();
	
	//Enter 10
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter a tip amount (min $1)'])[1]/following::input[1]")).sendKeys("10");
	
	//click submit
    driver.findElement(By.linkText("Submit")).click();
	
	//click do it again
    driver.findElement(By.linkText("Do it again!")).click();
	
	//select gif
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Or select a gif'])[1]/following::video[2]")).click();
	
	//click on continue
    driver.findElement(By.linkText("Continue")).click();
	
	//click back
    driver.findElement(By.linkText("Back")).click();
	
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search for a gif'])[1]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search for a gif'])[1]/following::input[1]")).clear();
	
	//enter csgo on search field
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search for a gif'])[1]/following::input[1]")).sendKeys("csgo");
	
	//click search
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Logout'])[1]/following::div[3]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search for a gif'])[1]/following::i[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Or select a gif'])[1]/following::video[3]")).click();
	
	//click continue
    driver.findElement(By.linkText("Continue")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter a tip amount (min $1)'])[1]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter a tip amount (min $1)'])[1]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter a tip amount (min $1)'])[1]/following::input[1]")).clear();
	
	//Enter 5 in the field
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter a tip amount (min $1)'])[1]/following::input[1]")).sendKeys("5");
    driver.findElement(By.linkText("Submit")).click();
	
	//click do it again
    driver.findElement(By.linkText("Do it again!")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your username'])[1]/following::input[1]")).click();
	
	//logout
    driver.findElement(By.linkText("Logout")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
