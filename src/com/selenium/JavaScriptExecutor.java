package com.selenium;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.get("https://www.amazon.in/");

//Scroll by pixels
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4000)", "");
		Thread.sleep(1000);
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\\\Users\\\\ADMIN\\\\eclipse-workspace\\\\Selenium\\\\screenshot\\\\scrl pixel.png");
		FileUtils.copyFile(src, dest);

//Scroll up a little form that instant		
		js.executeScript("window.scrollBy(0,-3000)", "");
		Thread.sleep(1000);

//Scroll to bottom of the page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		Thread.sleep(1000);
		TakesScreenshot sc1 = (TakesScreenshot) driver;
		File src1 = sc1.getScreenshotAs(OutputType.FILE);
		File Dest1 = new File("C:\\\\Users\\\\ADMIN\\\\eclipse-workspace\\\\Selenium\\\\screenshot\\\\srcl bottom.png");
		FileUtils.copyFile(src1, Dest1);

//Scroll by WebElement    
		Thread.sleep(1000);
		WebElement echo = driver.findElement(By.xpath("(//img[contains(@alt,'iQOO')])[1]"));
		js.executeScript("arguments[0].scrollIntoView();", echo);
		TakesScreenshot sc2 = (TakesScreenshot) driver;
		File src2 = sc2.getScreenshotAs(OutputType.FILE);
		File Dest2 = new File(
				"C:\\\\Users\\\\ADMIN\\\\eclipse-workspace\\\\Selenium\\\\screenshot\\\\srcl element.png");
		FileUtils.copyFile(src2, Dest2);

//Return to Starting Page
		js.executeScript("window.scrollTo(0,0)", "");

	}

}
