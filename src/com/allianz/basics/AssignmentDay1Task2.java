package com.allianz.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentDay1Task2 {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		driver.get("https://www.citibank.co.in/ssjsps/forgetuserid.jsp");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.className("sbSelector")).click();
		driver.findElement(By.linkText("Credit Card")).click();
		driver.findElement(By.id("citiCard1")).sendKeys("4545");
		driver.findElement(By.id("citiCard2")).sendKeys("5656");
		driver.findElement(By.id("citiCard3")).sendKeys("8887");
		driver.findElement(By.id("citiCard4")).sendKeys("9998");
		driver.findElement(By.id("cvvnumber")).sendKeys("123");
		driver.findElement(By.name("DOB")).click();
		Select selYear=new Select(driver.findElement(By.className("ui-datepicker-year")));
		selYear.selectByVisibleText("2022");
//		driver.findElement(By.xpath("//option[text()='2022']")).click();
		driver.findElement(By.className("ui-datepicker-month")).click();
		driver.findElement(By.xpath("//option[text()='Apr']")).click();
		driver.findElement(By.xpath("//a[text()='14']")).click();
		driver.findElement(By.xpath("//input[@value='PROCEED']")).click();
		String actualText=driver.findElement(By.className("ui-dialog-content")).getText();
		System.out.println("Text---->"+actualText);
		
		driver.quit();
		

	}

}
