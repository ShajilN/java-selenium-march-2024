package com.allianz.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentDay1Task1 {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.name("UserFirstName")).sendKeys("John");
		driver.findElement(By.name("UserLastName")).sendKeys("wick");
		driver.findElement(By.name("UserEmail")).sendKeys("john@gmail.com");
		Select selectJobTitle=new Select(driver.findElement(By.name("UserTitle")));
		selectJobTitle.selectByVisibleText("IT Manager");

		Select selectEmployees=new Select(driver.findElement(By.name("CompanyEmployees")));
		selectEmployees.selectByVisibleText("101 - 200 employees");

		driver.findElement(By.xpath("//input[@id='SubscriptionAgreement']/following-sibling::div")).click();
		driver.findElement(By.name("CompanyName")).sendKeys("Allianz");
		Select selectCompanyCountry=new Select(driver.findElement(By.name("CompanyCountry")));
		selectCompanyCountry.selectByVisibleText("United Kingdom");
		driver.findElement(By.name("start my free trial")).click();
		String actualErrorText=driver.findElement(By.xpath("//span[text()='Enter a valid phone number']")).getText();
		System.out.println("Error text displayed----->"+actualErrorText);
		
//		driver.quit();
		
		

	}

}
