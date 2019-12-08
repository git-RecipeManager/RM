package com.manager.recipe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;  
public class HelloWord {

	public static void main(String[] args) {  
		        
		    // declaration and instantiation of objects/variables  
		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\GAETANO\\Desktop\\INGEGNERIA DEL SOFTWARE\\chromedriver.exe");  
		    WebDriver driver=new ChromeDriver();  
		      
		// Launch website  
		    driver.navigate().to("http://localhost:8080/extraordinary-italy.com/");  
		          
		    // Click on the search text box and send value  
		    driver.findElement(By.id("btnUserLock")).click();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		    driver.findElement(By.cssSelector("#loginForm input[name='email']")).sendKeys("gaetanoamoroso0@gmail.com");
		    driver.findElement(By.cssSelector("#loginForm input[name='password']")).sendKeys("gaeamo77WD");
		    driver.findElement(By.id("btnModalLogin")).click();
		  
		      
		    }  
		  
		


}
