package com.allianz.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentDay1Task4 {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		driver.get("https://nasscom.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//li[text()='register']")).click();
		driver.findElement(By.xpath("//label[text()='First Name']//following-sibling::input")).sendKeys("admin");
		driver.findElement(By.xpath("//label[text()='Last name']//following-sibling::input")).sendKeys("pass");
		driver.findElement(By.id("edit-mail")).sendKeys("admin@gmail.com");
		driver.findElement(By.xpath("//input[contains(@id,'edit-field-company-name')]")).sendKeys("Google");
		Select selectOption=new Select(driver.findElement(By.id("edit-field-business-focus-reg")));
		selectOption.selectByVisibleText("IT Consulting");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
//		String errorMessage=driver.findElement(By.xpath("//div[aria-label='Error message']")).getText();
//		System.out.println("text---->"+errorMessage);
		
		driver.quit();

	}

}
