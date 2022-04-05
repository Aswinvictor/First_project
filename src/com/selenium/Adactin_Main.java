package com.selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Adactin_Main {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://adactinhotelapp.com/");
		driver.findElement(By.name("username")).sendKeys("Aswinvictor");
		driver.findElement(By.name("password")).sendKeys("Aswinadams103");
		driver.findElement(By.name("login")).click();

		WebElement loc = driver.findElement(By.name("location"));
		Select sl = new Select(loc);
		sl.selectByValue("New York");

		WebElement htls = driver.findElement(By.name("hotels"));
		Select sh = new Select(htls);
		sh.selectByIndex(1);

		WebElement room = driver.findElement(By.name("room_type"));
		Select sr = new Select(room);
		sr.selectByVisibleText("Double");

		WebElement no = driver.findElement(By.name("room_nos"));
		Select sn = new Select(no);
		sn.selectByValue("1");

		driver.findElement(By.name("datepick_in")).sendKeys("07/03/2022");
		driver.findElement(By.name("datepick_out")).sendKeys("09/03/2022");

		WebElement adult = driver.findElement(By.name("adult_room"));
		Select sa = new Select(adult);
		sa.selectByValue("2");

		WebElement child = driver.findElement(By.name("child_room"));
		Select sc = new Select(child);
		sc.selectByValue("0");

		driver.findElement(By.xpath("//input[@value='Search']")).click();

		driver.findElement(By.xpath("//input[@type='radio']")).click();

		driver.findElement(By.name("continue")).click();

		driver.findElement(By.id("first_name")).sendKeys("Aswin");
		driver.findElement(By.id("last_name")).sendKeys("Victor");
		driver.findElement(By.className("txtarea")).sendKeys("Newyork ");
		driver.findElement(By.id("cc_num")).sendKeys("1234567890123456");

		WebElement card = driver.findElement(By.name("cc_type"));
		Select sct = new Select(card);
		sct.selectByVisibleText("VISA");

		WebElement mon = driver.findElement(By.id("cc_exp_month"));
		Select sm = new Select(mon);
		sm.selectByVisibleText("June");

		WebElement year = driver.findElement(By.name("cc_exp_year"));
		Select sy = new Select(year);
		sy.selectByValue("2022");

		driver.findElement(By.name("cc_cvv")).sendKeys("658");
		driver.findElement(By.id("book_now")).click();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\ADMIN\\Downloads\\backup\\Selenium\\screenshot\\adactin.png");
		FileUtils.copyFile(src, dest);

		driver.findElement(By.id("logout")).click();
		driver.close();

	}

}
