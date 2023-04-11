package Presentation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chatGPT {
	public static void main(String[] args) {
		String projectDir = System.getProperty("user.dir");
		String driverPath = projectDir + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		promptCase();
	}
	
	public static void promptCase() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://wikipedia.org");
		driver.manage().window().maximize();
		
		Duration dur = Duration.ofSeconds(5);
		driver.manage().timeouts().implicitlyWait(dur);
		
		WebElement searchBar = driver.findElement(By.id("searchInput"));
		searchBar.sendKeys("Lionel Messi" + Keys.ENTER);
		
		String name = driver.findElement(By.xpath("//span[text()='Lionel Messi']")).getText();
		System.out.println(name);
		
		
	}
}
