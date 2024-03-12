package com.allianz.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo5FBSignUp {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		///click signup/create new account
		driver.findElement(By.linkText("Sign up for Facebook")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("John");
		driver.findElement(By.name("lastname")).sendKeys("Wick");
		//click radio button
		driver.findElement(By.xpath("//label[text()='Custom']")).click();
		
		Select selDay = new Select(driver.findElement(By.id("day")));
		selDay.selectByVisibleText("4");
		
		Select selMonth = new Select(driver.findElement(By.id("month")));
		selMonth.selectByVisibleText("Apr");
		
		Select selYear = new Select(driver.findElement(By.id("year")));
		selYear.selectByVisibleText("1970");
		
		driver.findElement(By.name("websubmit")).click();

	}

}
