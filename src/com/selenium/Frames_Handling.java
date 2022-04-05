package com.selenium;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames_Handling {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.get("http://demo.automationtesting.in/Frames.html");
		Thread.sleep(2000);

		List<WebElement> frame = driver.findElements(By.tagName("iframe"));
		int framesize = frame.size();
		System.out.println("Number of Frames: "+framesize);

		driver.switchTo().frame("singleframe");
		WebElement single_frame = driver.findElement(By.xpath("//input[@type='text']"));
		single_frame.sendKeys("singleframe");
		
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File dest = new File ("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\screenshot\\sin frame.png");
		FileUtils.copyFile(src, dest);
		
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).sendKeys("ASCII VALUE FOR Left Click");;
		WebElement outer = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(outer);

		WebElement inner = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(inner);

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("NestedFrames");
		TakesScreenshot sc1 = (TakesScreenshot) driver;
		File src1 = sc1.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\screenshot\\Mul frame.png");
		FileUtils.copyFile(src1, dest1);
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

	}

}
