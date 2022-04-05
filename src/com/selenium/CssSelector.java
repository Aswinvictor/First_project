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

class CssSelector {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver cs = new ChromeDriver();
		cs.manage().window().maximize();
		Thread.sleep(2000);

		cs.get("http://demo.automationtesting.in/Register.html");

// Locate by Attribute
		WebElement first = cs.findElement(By.cssSelector("input[ng-model='FirstName']"));
		first.sendKeys("Aswin");
		String a = first.getAttribute("placeholder");
		System.out.println("\nAttribute value: "+a);
		String b = first.getAttribute("value");
		System.out.println("First Name: " +b);
// Locate by Matches-prefix
		WebElement last = cs.findElement(By.cssSelector("input[placeholder^='Las']"));
		last.sendKeys("Victor");
		String c = last.getAttribute("placeholder");
		System.out.println("\nAttribute value:" +c);
		String d = last.getAttribute("value");
		System.out.println("Last Name: " +d); 
// Locate by matches - suffix
		WebElement email = cs.findElement(By.cssSelector("input[ng-model$='ess']"));
		email.sendKeys("sajhdk@gmail.com");
// Locate by Id
		WebElement hby = cs.findElement(By.cssSelector("input#checkbox1"));
		hby.click();
// Take Screenshot
		TakesScreenshot ts = (TakesScreenshot) cs;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\screenshot\\screen1.png");
		FileUtils.copyFile(source, destination);
// Locate by Attribute
		WebElement submit = cs.findElement(By.cssSelector("button[type='submit']"));
		submit.click();
// Locate by Substring
		WebElement lng = cs.findElement(By.cssSelector("div[class*='widget']"));
		lng.click();

		cs.navigate().to("https://www.instagram.com/?hl=en");
		Thread.sleep(2000);
//Locate by Linktext		
		WebElement ln = cs.findElement(By.linkText("Forgot password?"));
		ln.click();
		Thread.sleep(2000);
		cs.navigate().back();
		Thread.sleep(2000);
//Locate by PartialLinktext		
		WebElement sg = cs.findElement(By.partialLinkText("Sign up"));
		sg.click();
		Thread.sleep(2000);
		cs.close();

	}

}
