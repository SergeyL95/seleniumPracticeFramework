package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HW_14March {
	public static void main(String[] args) {
		String projectDir = System.getProperty("user.dir");
		String driverPath = projectDir + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		HW_14March homeWork = new HW_14March();
		
		homeWork.testCaseOne();
		
		homeWork.testCaseTwo();
		
	}
	
	public void testCaseOne() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://etsy.com/");
		
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")).click();
		driver.findElement(By.name("email")).sendKeys("automation");
		driver.findElement(By.name("password")).sendKeys("automation");
		driver.findElement(By.name("submit_attempt")).click();
		
		driver.close();
		
	}
	
	public void testCaseTwo() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://indeed.com/");
		
		String homeURL = driver.getCurrentUrl();
		String homeTitle = driver.getTitle();
		String position = "SDET";
		String location = "Miami, FL";
		String expectedResponse = position + " jobs in " + location;
		
		driver.findElement(By.id("text-input-what")).sendKeys(position);
		driver.findElement(By.id("text-input-where")).sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		driver.findElement(By.id("text-input-where")).sendKeys(location, Keys.ENTER);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String searchURL = driver.getCurrentUrl();
		String searchTitle = driver.getTitle();
		
		//URL Verification Test
		if(!homeURL.equals(searchURL)) {
			System.out.println("URL Verification Test - PASSED.");
		} else {
			System.out.println("URL Verification Test - FAILED. URLs matched.");
		}
		
		//Title Verification Test
		if(!homeTitle.equals(searchTitle)) {
			System.out.println("Title Verification Test - PASSED.");
		} else {
			System.out.println("Title Verification Test - FAILED. Titles matched.");
		}
		
		String actualResponse = driver.findElement(By.xpath("//h1[@class='jobsearch-SerpTitle i-unmask']")).getText();
		
		//Search Response Test
		if(actualResponse.equals(expectedResponse)) {
			System.out.println("Search Response Verification - PASSED.");
		} else {
			System.out.println("Search Response Verification - FAILED. Outputs didn't match.");
		}
		
		driver.close();
		

		
	}
}
