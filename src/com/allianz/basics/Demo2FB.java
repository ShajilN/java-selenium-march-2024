package com.allianz.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2FB {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		
		String actualTitle = driver.getTitle();
		System.out.println("title----->"+actualTitle);
		String currentUrl = driver.getCurrentUrl();
		System.out.println("current url ----->"+currentUrl);
		String pageSource = driver.getPageSource();
		System.out.println("page source-->"+pageSource);
		
		driver.quit();

	}

}
