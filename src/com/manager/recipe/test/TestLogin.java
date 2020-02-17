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

class TestLogin {

   @BeforeEach
   void setUp() {
   }

   @BeforeEach
   void tearDown() {
   }

   @Test
   public void site_header_is_on_home_page() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement user = browser.findElement(By.id("userLogin"));
       WebElement password=browser.findElement(By.id("passwordLogin"));
       WebElement login= browser.findElement(By.id("btnModalLogin"));
       user.sendKeys("andrea@email.it");
       password.sendKeys("ciaociao"); 
       login.click();
       String actualUrl="http://localhost:12419/RecipeManager/"; 
       String expectedUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
browser.close();

}
}
