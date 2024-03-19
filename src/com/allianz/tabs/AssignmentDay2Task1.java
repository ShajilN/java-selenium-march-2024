package com.allianz.tabs;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentDay2Task1 {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		driver.get("https://www.online.citibank.co.in/");	
		
		driver.findElement(By.xpath("//a[@class='newclose']")).click();
		driver.findElement(By.xpath("//a[@class='newclose2']")).click();
		driver.findElement(By.linkText("Login")).click();
		
		ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		driver.findElement(By.xpath("//div[contains(@onclick,'ForgotUserID')]")).click();
		
		driver.findElement(By.linkText("select your product type")).click();
		driver.findElement(By.linkText("Credit Card")).click();
		driver.findElement(By.id("citiCard1")).sendKeys("4545");
		driver.findElement(By.id("citiCard2")).sendKeys("5656");
		driver.findElement(By.id("citiCard3")).sendKeys("8887");
		driver.findElement(By.id("citiCard4")).sendKeys("9998");
		driver.findElement(By.id("cvvnumber")).sendKeys("123");
		
		driver.findElement(By.id("bill-date-long")).click();
		Select selectYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		selectYear.selectByVisibleText("2022");
		Select selectMonth = new Select(driver.findElement(By.className("ui-datepicker-month")));
		selectMonth.selectByVisibleText("Apr");
		
		driver.findElement(By.linkText("14")).click();
		driver.findElement(By.xpath("//input[@value='PROCEED']")).click();
		String warningText=driver.findElement(By.xpath("//li[contains(text(),'Please accept Terms and Conditions')]")).getText();
		System.out.println("text------>"+warningText);
		
		
//		driver.quit();
		
		

	}

}
