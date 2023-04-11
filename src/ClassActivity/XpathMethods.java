package ClassActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathMethods {
	public static void main(String[] args) {
		
		String projectDir = System.getProperty("user.dir");
		String driverPath = projectDir + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		XpathMethods xpathObj = new XpathMethods();
		xpathObj.etsyCSS();
	}
	
	public static void etsyCSS() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://etsy.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector(".select-signin")).click();
		driver.findElement(By.cssSelector(".register-header-action")).click();
		driver.findElement(By.cssSelector("#join_neu_email_field")).sendKeys("jon.dow@gmail.com");
		driver.findElement(By.cssSelector("#join_neu_first_name_field")).sendKeys("Jon");
		driver.findElement(By.cssSelector("#join_neu_password_field")).sendKeys("Password");
		driver.findElement(By.cssSelector("button[value='register']")).click();
		
	}
}
