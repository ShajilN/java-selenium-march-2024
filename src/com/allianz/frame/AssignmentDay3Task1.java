package com.allianz.frame;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentDay3Task1 {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		driver.get("http://demo.openemr.io/b/openemr/");	
		
		driver.findElement(By.xpath("//input[@id='authUser']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='clearPass']")).sendKeys("pass");
		Select selectLang=new Select(driver.findElement(By.xpath("//select[@name='languageChoice']")));
		selectLang.selectByVisibleText("English (Indian)");
		driver.findElement(By.id("login-button")).click();
		//select New/search
		driver.findElement(By.xpath("//div[text()='Patient']")).click();
		driver.findElement(By.xpath("//div[text()='New/Search']")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pat']")));
		driver.findElement(By.id("form_fname")).sendKeys("tester");
		driver.findElement(By.id("form_lname")).sendKeys("lastname");
		
//		8.  Update DOB as today's date 
//		driver.findElement(By.id("form_DOB")).sendKeys("2024-03-22");
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = today.format(formatter);
		driver.findElement(By.id("form_DOB")).sendKeys(formattedDate);
		
//		9.  Update the gender
		Select selectGender = new Select(driver.findElement(By.xpath("//select[@id='form_sex']")));
		selectGender.selectByVisibleText("Male");
//		10. . Click on the create new patient button above the form
		driver.findElement(By.id("create")).click();
//		11. . Click on confirm create new patient button.
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'modalIframe')]")));
		driver.findElement(By.xpath("//button[text()='Confirm Create New Patient']")).click();
		driver.switchTo().defaultContent();
//		12. . Print the text from alert box (if any error before handling alert add 5 sec wait)
		 //wait for alert to be present - Explicit wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.alertIsPresent());
        
        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();
        System.out.println("Actual alert text---->"+actualAlertText);
        
//		13. . Handle alert
        alert.accept();
//		14. Close the Happy Birthday popup
        driver.findElement(By.className("closeDlgIframe")).click();
		
//		15. Get the added patient name and print in the console.
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pat']")));
		String actualPatientName=driver.findElement(By.xpath("//span[contains(text(),'Medical Record Dashboard')]")).getText();
		String[] text=actualPatientName.split("\\s+");
		
		//Extract the last 2 words
		String firstName=text[text.length -2];
		String lastName=text[text.length -1];
		
		//printing it in console
		System.out.println('\n'+"patient name--->"+firstName+" "+lastName);
//		driver.quit();
		
		

	}

}
