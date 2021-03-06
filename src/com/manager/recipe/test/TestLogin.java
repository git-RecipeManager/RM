package com.manager.recipe.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jdk.nashorn.internal.runtime.logging.Logger;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class TestLogin {

   @BeforeEach
   void setUp() {
   }

   @BeforeEach
   void tearDown() {
	   
   }

   @Test
   public void testLogin() {   
       System.setProperty("webdriver.chrome.driver","C:\\Users\\GAETANO\\Desktop\\INGEGNERIA DEL SOFTWARE\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:8080/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebElement user = browser.findElement(By.id("userLogin"));
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordLogin")));
       WebElement login= browser.findElement(By.id("btnModalLogin"));
       user.sendKeys("");
       password.sendKeys(""); 
       login.click();
       String expectedUrl="http://localhost:8080/RecipeManager/LoginServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   
   @Test
   public void testLogin2() {   
       System.setProperty("webdriver.chrome.driver","C:\\Users\\GAETANO\\Desktop\\INGEGNERIA DEL SOFTWARE\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:8080/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebElement user = browser.findElement(By.id("userLogin"));
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordLogin")));
       WebElement login= browser.findElement(By.id("btnModalLogin"));
       user.sendKeys("andrea#email.it");
       password.sendKeys(""); 
       login.click();
       String expectedUrl="http://localhost:8080/RecipeManager/LoginServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   @Test
   public void testLogin3() {   
       System.setProperty("webdriver.chrome.driver","C:\\Users\\GAETANO\\Desktop\\INGEGNERIA DEL SOFTWARE\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:8080/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebElement user = browser.findElement(By.id("userLogin"));
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordLogin")));
       WebElement login= browser.findElement(By.id("btnModalLogin"));
       user.sendKeys("andrea@email.it");
       password.sendKeys("sbagliata"); 
       login.click();
       String expectedUrl="http://localhost:8080/RecipeManager/LoginServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   
   @Test
   public void testLogin4() {   
       System.setProperty("webdriver.chrome.driver","C:\\Users\\GAETANO\\Desktop\\INGEGNERIA DEL SOFTWARE\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:8080/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebElement user = browser.findElement(By.id("userLogin"));
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordLogin")));
       WebElement login= browser.findElement(By.id("btnModalLogin"));
       user.sendKeys("andrea@email.it");
       password.sendKeys("ciaociao"); 
       login.click();
       String expectedUrl="http://localhost:8080/RecipeManager/LoginServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
}
