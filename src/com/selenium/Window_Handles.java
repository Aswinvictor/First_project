package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Window_Handles {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(2000);

		WebElement dress = driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));

		Actions a = new Actions(driver);
		Robot r = new Robot();

		a.contextClick(dress).perform();
		for (int i = 0; i < 2; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		WebElement tshirt = driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]"));
		a.contextClick(tshirt).perform();
		for (int i = 0; i < 2; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		Set<String> window = driver.getWindowHandles();

		for (String id : window) {
			String title = driver.switchTo().window(id).getTitle();
			System.out.println(title);
		}

		String tshirt_id = "T-shirts - My Store";

		for (String id1 : window) {
			if (driver.switchTo().window(id1).getTitle().equals(tshirt_id)) {
				break;
			}
		}

		a.click(tshirt);
		driver.findElement(By.className("checkbox")).click();

		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\screenshot\\win_handles.png");
		FileUtils.copyFile(src, dest);

		Thread.sleep(2000);
		driver.quit();
	}

}
