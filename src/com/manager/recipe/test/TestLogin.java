package com.manager.recipe.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class TestLogin {

   @BeforeEach
   void setUp() {
   }

   @BeforeEach
   void tearDown() {
   }

   @Test
   public void testaLogin() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebElement user = browser.findElement(By.id("userLogin"));
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordLogin")));
       WebElement login= browser.findElement(By.id("btnModalLogin"));
       user.sendKeys("andrea@email.it");
       password.sendKeys("ciaociao"); 
       login.click();
       String expectedUrl="http://localhost:12419/RecipeManager/LoginServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
   }
}
