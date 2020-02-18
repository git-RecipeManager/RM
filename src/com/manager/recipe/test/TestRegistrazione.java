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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class TestRegistrazione {

   @BeforeEach
   void setUp() {
   }

   @Test
   public void testRegistrazione1() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement user = browser.findElement(By.id("userRegistrazione"));
       WebElement email = browser.findElement(By.id("emailRegistrazione"));
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("registrationPassword")));
       WebElement password2 = browser.findElement(By.id("passwordRegistrazione2"));
       WebElement registrazione= browser.findElement(By.id("btnModalRegistration"));
       user.sendKeys("");
       email.sendKeys("");
       password.sendKeys(""); 
       password2.sendKeys("");
       registrazione.click();
       String expectedUrl="http://localhost:12419/RecipeManager/LogoutServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   @Test
   public void testRegistrazione2() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement user = browser.findElement(By.id("userRegistrazione"));
       WebElement email = browser.findElement(By.id("emailRegistrazione"));
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("registrationPassword")));
       WebElement password2 = browser.findElement(By.id("passwordRegistrazione2"));
       WebElement registrazione= browser.findElement(By.id("btnModalRegistration"));
       user.sendKeys("nomeutente01");
       email.sendKeys("");
       password.sendKeys(""); 
       password2.sendKeys("");
       registrazione.click();
       String expectedUrl="http://localhost:12419/RecipeManager/LogoutServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   @Test
   public void testRegistrazione3() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement user = browser.findElement(By.id("userRegistrazione"));
       WebElement email = browser.findElement(By.id("emailRegistrazione"));
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("registrationPassword")));
       WebElement password2 = browser.findElement(By.id("passwordRegistrazione2"));
       WebElement registrazione= browser.findElement(By.id("btnModalRegistration"));
       user.sendKeys("nomeutente01");
       email.sendKeys("prova#email.it");
       password.sendKeys(""); 
       password2.sendKeys("");
       registrazione.click();
       String expectedUrl="http://localhost:12419/RecipeManager/LogoutServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   @Test
   public void testRegistrazione4() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement user = browser.findElement(By.id("userRegistrazione"));
       WebElement email = browser.findElement(By.id("emailRegistrazione"));
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("registrationPassword")));
       WebElement password2 = browser.findElement(By.id("passwordRegistrazione2"));
       WebElement registrazione= browser.findElement(By.id("btnModalRegistration"));
       user.sendKeys("nomeutente01");
       email.sendKeys("prova@email.it");
       password.sendKeys(""); 
       password2.sendKeys("");
       registrazione.click();
       String expectedUrl="http://localhost:12419/RecipeManager/LogoutServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   @Test
   public void testRegistrazione5() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement user = browser.findElement(By.id("userRegistrazione"));
       WebElement email = browser.findElement(By.id("emailRegistrazione"));
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("registrationPassword")));
       WebElement password2 = browser.findElement(By.id("passwordRegistrazione2"));
       WebElement registrazione= browser.findElement(By.id("btnModalRegistration"));
       user.sendKeys("nomeutente01");
       email.sendKeys("prova@email.it");
       password.sendKeys("ciao"); 
       password2.sendKeys("");
       registrazione.click();
       String expectedUrl="http://localhost:12419/RecipeManager/LogoutServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   @Test
   public void testRegistrazione6() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement user = browser.findElement(By.id("userRegistrazione"));
       WebElement email = browser.findElement(By.id("emailRegistrazione"));
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("registrationPassword")));
       WebElement password2 = browser.findElement(By.id("passwordRegistrazione2"));
       WebElement registrazione= browser.findElement(By.id("btnModalRegistration"));
       user.sendKeys("nomeutente01");
       email.sendKeys("prova@email.it");
       password.sendKeys("ciao"); 
       password2.sendKeys("ciao");
       registrazione.click();
       String expectedUrl="http://localhost:12419/RecipeManager/LogoutServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   
   @Test
   public void testRegistrazione7() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement user = browser.findElement(By.id("userRegistrazione"));
       WebElement email = browser.findElement(By.id("emailRegistrazione"));
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("registrationPassword")));
       WebElement password2 = browser.findElement(By.id("passwordRegistrazione2"));
       WebElement registrazione= browser.findElement(By.id("btnModalRegistration"));
       user.sendKeys("nomeutente01");
       email.sendKeys("prova@email.it");
       password.sendKeys("ciaociao"); 
       password2.sendKeys("ciaociao");
       registrazione.click();
       String expectedUrl="http://localhost:12419/RecipeManager/LogoutServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   
   @Test
   public void testRegistrazione8() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement user = browser.findElement(By.id("userRegistrazione"));
       WebElement email = browser.findElement(By.id("emailRegistrazione"));
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("registrationPassword")));
       WebElement password2 = browser.findElement(By.id("passwordRegistrazione2"));
       WebElement registrazione= browser.findElement(By.id("btnModalRegistration"));
       user.sendKeys("nomeutente01");
       email.sendKeys("prova@email.it");
       password.sendKeys("ciaociao01"); 
       password2.sendKeys("ciaociao01");
       registrazione.click();
       String expectedUrl="http://localhost:12419/RecipeManager/LogoutServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   
   @Test
   public void testRegistrazione9() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement user = browser.findElement(By.id("userRegistrazione"));
       WebElement email = browser.findElement(By.id("emailRegistrazione"));
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("registrationPassword")));
       WebElement password2 = browser.findElement(By.id("passwordRegistrazione2"));
       WebElement registrazione= browser.findElement(By.id("btnModalRegistration"));
       user.sendKeys("nomeutente02");
       email.sendKeys("prova2@email.it");
       password.sendKeys("ciaociao01"); 
       password2.sendKeys("ciaociao01");
       registrazione.click();
       String expectedUrl="http://localhost:12419/RecipeManager/LogoutServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }

@BeforeEach
   void tearDown() {
	   
   }
   
   
   
}
