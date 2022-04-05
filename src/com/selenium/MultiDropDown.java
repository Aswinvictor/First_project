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
import org.openqa.selenium.support.ui.Select;

public class MultiDropDown {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver md = new ChromeDriver();
		md.manage().window().maximize();

		md.get("https://demoqa.com/select-menu/");
		Thread.sleep(2000);

		WebElement multi = md.findElement(By.id("cars"));
		Select s = new Select(multi);
		boolean a = s.isMultiple();
		System.out.println("is Multiple :" + a);

		s.selectByIndex(0);
		s.selectByVisibleText("Saab");
		s.selectByValue("audi");

		TakesScreenshot sc = (TakesScreenshot) md;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\screenshot\\screenmd.png");
		FileUtils.copyFile(src, dest);

		WebElement b = s.getFirstSelectedOption();
		System.out.println("\nFirst selected :" + b.getText());

		List<WebElement> allsel = s.getAllSelectedOptions();
		System.out.println("\nAll Selected options:");
		for (WebElement sel : allsel) {
			System.out.println(sel.getText());
		}

		List<WebElement> allopt = s.getOptions();
		int z = allopt.size();
		System.out.println("\nSize of all options :" + z);
		System.out.println("\nAll Options :");
		for (int i = 0; i < z; i++) {
			System.out.println(allopt.get(i).getText());

		}

	}

}
