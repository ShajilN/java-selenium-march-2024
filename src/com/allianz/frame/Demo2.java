package com.allianz.frame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo2 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        
        //switch to frame or iframe - by index
        driver.switchTo().frame(0);
        
      //enter userid as jack123
        driver.findElement(By.xpath("//input[contains(@name,'LoginUserId')]")).sendKeys("jack123");
        
        driver.findElement(By.linkText("CONTINUE")).click();
        
        //switch to main html
        driver.switchTo().defaultContent();

	}

}
