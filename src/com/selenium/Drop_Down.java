package com.selenium;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Drop_Down {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver dd = new ChromeDriver();
		dd.manage().window().maximize();

		dd.get("https://www.facebook.com/");
		Thread.sleep(2000);

		WebElement create = dd.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));
		create.click();
		Thread.sleep(2000);
//selectBy Index		
		WebElement day = dd.findElement(By.id("day"));
		Select d = new Select(day);
		d.selectByIndex(5);
//selectBy Value		
		WebElement mon = dd.findElement(By.id("month"));
		Select m = new Select(mon);
		m.selectByValue("6");
//selectBy VisibleText	
		WebElement year = dd.findElement(By.id("year"));
		Select y = new Select(year);
		y.selectByVisibleText("1996");

		Thread.sleep(2000);

		TakesScreenshot sc = (TakesScreenshot) dd;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\screenshot\\screendd.png");
		FileUtils.copyFile(src, dest);

		dd.close();

	}

}
