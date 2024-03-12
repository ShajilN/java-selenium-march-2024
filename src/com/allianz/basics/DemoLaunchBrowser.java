package com.allianz.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DemoLaunchBrowser {

	public static void main(String[] args) {
		
		WebDriver driver = null;
		String browser = "edge";
		
		if(browser.equalsIgnoreCase("ch")) {
			driver= new ChromeDriver();
		}
		else {
			driver = new EdgeDriver();
		}
		
		WebDriver driver1=new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		String actualTitle=driver.getTitle();
		System.out.println("title------>"+actualTitle);
		String actualPageSource=driver.getPageSource();
		System.out.println("page souce--------->"+actualPageSource);
		
		driver1.get("https://www.google.com");
		String actualTitle1=driver1.getTitle();
		System.out.println("title---------->"+actualTitle1);
		String actualPageSource1=driver1.getPageSource();
		System.out.println("page source--------->"+actualPageSource1);
		
		driver.quit();
		driver1.quit();
		

	}

}
