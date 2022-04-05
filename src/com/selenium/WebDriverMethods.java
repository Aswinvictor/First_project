package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		Upcasting
		WebDriver wm = new ChromeDriver();
//		WebDriver Methods
		wm.get("https://www.facebook.com/");
		wm.manage().window().maximize();
		String title = wm.getTitle();
		System.out.println(title);
		String url = wm.getCurrentUrl();
		System.out.println(url);
//		Navigation methods
		wm.navigate().to("https://www.instagram.com/");
		wm.navigate().back();
		wm.navigate().forward();
		wm.navigate().refresh();
		wm.close();
		wm.quit();
	}

}
