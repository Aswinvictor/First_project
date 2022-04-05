import java.io.File;
import java.io.IOException;

import javax.swing.text.Document;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Mini_Project {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.manage().window().maximize();

		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(3000);

		WebElement signin = driver.findElement(By.className("login"));
		signin.click();

		WebElement email = driver.findElement(By.name("email_create"));
		email.sendKeys("sdyujkcfc@gmail.com");
		WebElement create = driver.findElement(By.id("SubmitCreate"));
		create.click();

		Thread.sleep(4000);
		WebElement mr = driver.findElement(By.name("id_gender"));
		mr.click();
		WebElement first = driver.findElement(By.id("customer_firstname"));
		first.sendKeys("Aswin");
		WebElement last = driver.findElement(By.id("customer_lastname"));
		last.sendKeys("Victor");
		WebElement pass = driver.findElement(By.name("passwd"));
		pass.sendKeys("aswimdklmds");

		WebElement days = driver.findElement(By.id("days"));
		Select s = new Select(days);
		s.selectByValue("6");
		WebElement month = driver.findElement(By.id("months"));
		Select s1 = new Select(month);
		s1.selectByValue("6");
		WebElement year = driver.findElement(By.id("years"));
		Select s2 = new Select(year);
		s2.selectByValue("1996");

		WebElement add = driver.findElement(By.name("address1"));
		add.sendKeys("Newyork Public library");

		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("Washington DC");

		WebElement state = driver.findElement(By.id("id_state"));
		Select s3 = new Select(state);
		s3.selectByValue("32");

		WebElement zip = driver.findElement(By.id("postcode"));
		zip.sendKeys("62917");

		WebElement ph = driver.findElement(By.id("phone_mobile"));
		ph.sendKeys("7708525323");

		WebElement alias = driver.findElement(By.name("alias"));
		alias.sendKeys("Address");

		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\screenshot\\mini.png");
		FileUtils.copyFile(src, dest);

		WebElement submit = driver.findElement(By.id("submitAccount"));
		submit.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");

		TakesScreenshot sc1 = (TakesScreenshot) driver;
		File src1 = sc1.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\screenshot\\mini1.png");
		FileUtils.copyFile(src1, dest1);

		Thread.sleep(1500);
		driver.close();

	}

}
