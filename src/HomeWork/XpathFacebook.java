package HomeWork;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathFacebook {
	public static void main(String[] args) {
		
		String projectDir = System.getProperty("user.dir");
		String driverPath = projectDir + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		XpathFacebook fbProj = new XpathFacebook();
		fbProj.facebookLogin();
		fbProj.facebookSignUp();
		fbProj.indeedSearch();
	}
		
		public void facebookLogin() {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(ops);
			
			driver.get("https://facebook.com");
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Automation");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Automation");
			driver.findElement(By.xpath("//button[@value='1']")).click();	
	}
		
		public void facebookSignUp() {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(ops);
			
			Duration dur = Duration.ofSeconds(3);
			driver.manage().timeouts().implicitlyWait(dur);
			
			driver.get("https://facebook.com");
			driver.findElement(By.xpath("//a[@ajaxify='/reg/spotlight/']")).click();
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Automation");
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Automation");
			driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Automation");
			driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Automation");
			driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		}
		
		public void indeedSearch() {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(ops);
			
			String position = "SDET";
			String location = "Washington, DC";
			String actualMessage;
			String expectedMessage = position + " jobs in " + location;
			String homeURL;
			String searchURL;
			String homeTitle;
			String searchTitle;
			
			
			driver.get("https://indeed.com");
			
			homeURL = driver.getCurrentUrl();
			homeTitle = driver.getTitle();
			
			driver.findElement(By.xpath("//input[@id='text-input-what']")).sendKeys(position);
			driver.findElement(By.xpath("//input[@id='text-input-where']")).sendKeys(Keys.CONTROL + "a");
			driver.findElement(By.xpath("//input[@id='text-input-where']")).sendKeys(location, Keys.ENTER);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			searchURL = driver.getCurrentUrl();
			searchTitle = driver.getTitle();
			
			if(!searchURL.equals(homeURL)) {
				System.out.println("URL Verification PASSED");
			} else {
				System.out.println("URL Verification FAILED. URLs matched.");
			}
			
			if(!searchTitle.equals(homeTitle)) {
				System.out.println("Title Verification PASSED");
			} else {
				System.out.println("Title Verification FAILED. Titles matched.");
			}
			
			actualMessage = driver.findElement(By.xpath("//h1[@class='jobsearch-SerpTitle i-unmask']")).getText();
			
			if(actualMessage.equals(expectedMessage)) {
				System.out.println("JobsInLocation field Verification PASSED");
			} else {
				System.out.println("JobsInLocation field Verification FAILED. Messaged didn't match.");
			}
			
		}
}
