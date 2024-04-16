package com.allianz.tabs;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo3 {

	public static void main(String[] args) {


		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        driver.get("https://db4free.net");
        
        driver.findElement(By.partialLinkText("phpMyAdmin")).click();
        ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
       
        for(String win : windows) {
        	
        	System.out.println(win);
			driver.switchTo().window(win);
			System.out.println(driver.getTitle());
			if(driver.getTitle().equals("phpMyAdmin"))
			{
				break;
			}
			System.out.println("----------------------------------");
		}

		System.out.println(driver.getCurrentUrl());
        
        driver.findElement(By.id("input_username")).sendKeys("admin");
        driver.findElement(By.id("input_password")).sendKeys("admin123");
        driver.findElement(By.id("input_go")).click();
        
		
//		driver.quit();
		
		

	}

}
