package com.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver al = new ChromeDriver();
		al.manage().window().maximize();
		Thread.sleep(2000);

		al.get("http://demo.automationtesting.in/Alerts.html");
		Thread.sleep(2000);

//simple Alert
		WebElement pa = al.findElement(By.xpath("(//a[@class='analystic'])[3]"));
		pa.click();
		WebElement dm = al.findElement(By.xpath("//button[contains(text(),'demon')]"));
		dm.click();

		Alert tx = al.switchTo().alert();
		tx.sendKeys("text box");
		tx.accept();
		
		TakesScreenshot sc = (TakesScreenshot) al;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\screenshot\\alert.png");
		FileUtils.copyFile(src, dest);

		String t = al.findElement(By.xpath("//p[contains(text(),'Hel')]")).getText();
		System.out.println(t);

	}

}
