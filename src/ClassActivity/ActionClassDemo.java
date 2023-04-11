package ClassActivity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo {
	public static void main(String[] args) {
		String projectDir = System.getProperty("user.dir");
		String driverPath = projectDir + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		etsyCase();
		
	}
	
	public static void etsyCase() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://etsy.com");
		driver.manage().window().maximize();
		String mainWindow = driver.getWindowHandle();
		String homeTitle = driver.getTitle();
		
		Duration dur = Duration.ofSeconds(5);
		driver.manage().timeouts().implicitlyWait(dur);
		
		Actions letsDo = new Actions(driver);
		WebElement jewelTab = driver.findElement(By.xpath("//span[contains(text(), 'Jewelry & Accessories')]"));
		
		letsDo.moveToElement(jewelTab).build().perform();
		
	}
}
