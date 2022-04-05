package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTrail {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
	"C:\\Users\\ADMIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver dt = new ChromeDriver();
		dt.get("https://www.facebook.com/");
		dt.navigate().to("https://www.instagram.com/");
		dt.navigate().back();
		dt.navigate().to("https://www.youtube.com/");
		dt.navigate().back();
		dt.navigate().to("https://twitter.com/");
		dt.navigate().back();
		dt.navigate().forward();
		dt.navigate().refresh();
		String t = dt.getTitle();
		System.out.println(t);
		String u = dt.getCurrentUrl();
		System.out.println(u);
		dt.close();

	}

}
