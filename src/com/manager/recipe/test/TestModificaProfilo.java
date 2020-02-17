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

class TestModificaProfilo {

   @BeforeEach
   void setUp() {
   }

   @BeforeEach
   void tearDown() {
	   
   }

   @Test
   public void testModificaDati1() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebElement user = browser.findElement(By.id("userLogin"));
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordLogin")));
       WebElement login= browser.findElement(By.id("btnModalLogin"));
       user.sendKeys("nomeutente01");
       password.sendKeys("ciaociao"); 
       login.click();
       browser.get("http://localhost:12419/RecipeManager/profile.jsp");
       WebElement fullName=browser.findElement(By.id("fullName"));
       WebElement cellulare=browser.findElement(By.id("cellulare"));
       WebElement indirizzo=browser.findElement(By.id("indirizzo"));
       WebElement pass=browser.findElement(By.id("password"));
       WebElement pass2=browser.findElement(By.id("password2"));
       WebElement salva= browser.findElement(By.id("salva"));
       fullName.clear();
       fullName.sendKeys("");
       cellulare.clear();
       cellulare.sendKeys("");
       indirizzo.clear();
       indirizzo.sendKeys("");
       pass.sendKeys("");
       pass2.sendKeys("");
       salva.click();
       String expectedUrl="http://localhost:12419/RecipeManager/ProfileServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   @Test
   public void testModificaDati2() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebElement user = browser.findElement(By.id("userLogin"));
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordLogin")));
       WebElement login= browser.findElement(By.id("btnModalLogin"));
       user.sendKeys("nomeutente01");
       password.sendKeys("ciaociao"); 
       login.click();
       browser.get("http://localhost:12419/RecipeManager/profile.jsp");
       WebElement fullName=browser.findElement(By.id("fullName"));
       WebElement cellulare=browser.findElement(By.id("cellulare"));
       WebElement indirizzo=browser.findElement(By.id("indirizzo"));
       WebElement pass=browser.findElement(By.id("password"));
       WebElement pass2=browser.findElement(By.id("password2"));
       WebElement salva= browser.findElement(By.id("salva"));
       fullName.clear();
       fullName.sendKeys("And Tra 2");
       cellulare.clear();
       cellulare.sendKeys("");
       indirizzo.clear();
       indirizzo.sendKeys("");
       pass.sendKeys("");
       pass2.sendKeys("");
       salva.click();
       String expectedUrl="http://localhost:12419/RecipeManager/ProfileServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   @Test
   public void testModificaDati3() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebElement user = browser.findElement(By.id("userLogin"));
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordLogin")));
       WebElement login= browser.findElement(By.id("btnModalLogin"));
       user.sendKeys("nomeutente01");
       password.sendKeys("ciaociao"); 
       login.click();
       browser.get("http://localhost:12419/RecipeManager/profile.jsp");
       WebElement fullName=browser.findElement(By.id("fullName"));
       WebElement cellulare=browser.findElement(By.id("cellulare"));
       WebElement indirizzo=browser.findElement(By.id("indirizzo"));
       WebElement pass=browser.findElement(By.id("password"));
       WebElement pass2=browser.findElement(By.id("password2"));
       WebElement salva= browser.findElement(By.id("salva"));
       fullName.clear();
       fullName.sendKeys("Andrea Tranquillo");
       cellulare.clear();
       cellulare.sendKeys("ciaooooo");
       indirizzo.clear();
       indirizzo.sendKeys("");
       pass.sendKeys("");
       pass2.sendKeys("");
       salva.click();
       String expectedUrl="http://localhost:12419/RecipeManager/ProfileServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   @Test
   public void testModificaDati4() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebElement user = browser.findElement(By.id("userLogin"));
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordLogin")));
       WebElement login= browser.findElement(By.id("btnModalLogin"));
       user.sendKeys("nomeutente01");
       password.sendKeys("ciaociao"); 
       login.click();
       browser.get("http://localhost:12419/RecipeManager/profile.jsp");
       WebElement fullName=browser.findElement(By.id("fullName"));
       WebElement cellulare=browser.findElement(By.id("cellulare"));
       WebElement indirizzo=browser.findElement(By.id("indirizzo"));
       WebElement pass=browser.findElement(By.id("password"));
       WebElement pass2=browser.findElement(By.id("password2"));
       WebElement salva= browser.findElement(By.id("salva"));
       fullName.clear();
       fullName.sendKeys("Andrea Tranquillo");
       cellulare.clear();
       cellulare.sendKeys("3371378183");
       indirizzo.clear();
       indirizzo.sendKeys("");
       pass.sendKeys("ciaociao");
       pass2.sendKeys("ciaociao");
       salva.click();
       String expectedUrl="http://localhost:12419/RecipeManager/ProfileServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   @Test
   public void testModificaDati5() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebElement user = browser.findElement(By.id("userLogin"));
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordLogin")));
       WebElement login= browser.findElement(By.id("btnModalLogin"));
       user.sendKeys("nomeutente01");
       password.sendKeys("ciaociao"); 
       login.click();
       browser.get("http://localhost:12419/RecipeManager/profile.jsp");
       WebElement fullName=browser.findElement(By.id("fullName"));
       WebElement cellulare=browser.findElement(By.id("cellulare"));
       WebElement indirizzo=browser.findElement(By.id("indirizzo"));
       WebElement pass=browser.findElement(By.id("password"));
       WebElement pass2=browser.findElement(By.id("password2"));
       WebElement salva= browser.findElement(By.id("salva"));
       fullName.clear();
       fullName.sendKeys("Andrea Tranquillo");
       cellulare.clear();
       cellulare.sendKeys("3371378183");
       indirizzo.clear();
       indirizzo.sendKeys("Via viosa 2");
       pass.sendKeys("");
       pass2.sendKeys("");
       salva.click();
       String expectedUrl="http://localhost:12419/RecipeManager/ProfileServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   @Test
   public void testModificaDati6() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebElement user = browser.findElement(By.id("userLogin"));
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordLogin")));
       WebElement login= browser.findElement(By.id("btnModalLogin"));
       user.sendKeys("nomeutente01");
       password.sendKeys("ciaociao"); 
       login.click();
       browser.get("http://localhost:12419/RecipeManager/profile.jsp");
       WebElement fullName=browser.findElement(By.id("fullName"));
       WebElement cellulare=browser.findElement(By.id("cellulare"));
       WebElement indirizzo=browser.findElement(By.id("indirizzo"));
       WebElement pass=browser.findElement(By.id("password"));
       WebElement pass2=browser.findElement(By.id("password2"));
       WebElement salva= browser.findElement(By.id("salva"));
       fullName.clear();
       fullName.sendKeys("Andrea Tranquillo");
       cellulare.clear();
       cellulare.sendKeys("3371378183");
       indirizzo.clear();
       indirizzo.sendKeys("Via viosa 2");
       pass.sendKeys("ciaociao");
       pass2.sendKeys("");
       salva.click();
       String expectedUrl="http://localhost:12419/RecipeManager/ProfileServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   @Test
   public void testModificaDati7() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebElement user = browser.findElement(By.id("userLogin"));
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordLogin")));
       WebElement login= browser.findElement(By.id("btnModalLogin"));
       user.sendKeys("nomeutente01");
       password.sendKeys("ciaociao"); 
       login.click();
       browser.get("http://localhost:12419/RecipeManager/profile.jsp");
       WebElement fullName=browser.findElement(By.id("fullName"));
       WebElement cellulare=browser.findElement(By.id("cellulare"));
       WebElement indirizzo=browser.findElement(By.id("indirizzo"));
       WebElement pass=browser.findElement(By.id("password"));
       WebElement pass2=browser.findElement(By.id("password2"));
       WebElement salva= browser.findElement(By.id("salva"));
       fullName.clear();
       fullName.sendKeys("Andrea Tranquillo");
       cellulare.clear();
       cellulare.sendKeys("3371378183");
       indirizzo.clear();
       indirizzo.sendKeys("Via viosa 2");
       pass.sendKeys("ciaociao");
       pass2.sendKeys("ciaociaooooooo");
       salva.click();
       String expectedUrl="http://localhost:12419/RecipeManager/ProfileServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   @Test
   public void testModificaDati8() {   
       System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");   
       WebDriver browser = new ChromeDriver();
       browser.get("http://localhost:12419/RecipeManager/");    
       WebElement areaLogin=browser.findElement(By.id("btnUserLock"));
       areaLogin.click();
       WebElement user = browser.findElement(By.id("userLogin"));
       WebDriverWait wait = new WebDriverWait(browser, 10);
       WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordLogin")));
       WebElement login= browser.findElement(By.id("btnModalLogin"));
       user.sendKeys("nomeutente01");
       password.sendKeys("ciaociao"); 
       login.click();
       browser.get("http://localhost:12419/RecipeManager/profile.jsp");
       WebElement fullName=browser.findElement(By.id("fullName"));
       WebElement cellulare=browser.findElement(By.id("cellulare"));
       WebElement indirizzo=browser.findElement(By.id("indirizzo"));
       WebElement pass=browser.findElement(By.id("password"));
       WebElement pass2=browser.findElement(By.id("password2"));
       WebElement salva= browser.findElement(By.id("salva"));
       fullName.clear();
       fullName.sendKeys("Andrea Tranquillo");
       cellulare.clear();
       cellulare.sendKeys("3371378183");
       indirizzo.clear();
       indirizzo.sendKeys("Via viosa 2");
       pass.sendKeys("ciaociao");
       pass2.sendKeys("ciaociao");
       salva.click();
       String expectedUrl="http://localhost:12419/RecipeManager/ProfileServlet"; 
       String actualUrl= browser.getCurrentUrl(); 
       Assert.assertEquals(expectedUrl,actualUrl);
       browser.close();
       browser.quit();
   }
   
}