package ClassActivity;

import java.awt.Image;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class classActivity2 {
	public static void main(String[] args) {
		
		String projectDir = System.getProperty("user.dir");
		String driverPath = projectDir + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		//amazonTask();
		listElement();
		
	}
	
	public static void amazonTask() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		
		Duration dur = Duration.ofSeconds(5);
		driver.manage().timeouts().implicitlyWait(dur);
		
		WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBar.sendKeys("Coffee mug" + Keys.ENTER);
		driver.navigate().back();
		WebElement searchBar2 = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBar2.sendKeys("Pretty coffee mug" + Keys.ENTER);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
	}
	
	public static void listElement() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		
		Duration dur = Duration.ofSeconds(5);
		driver.manage().timeouts().implicitlyWait(dur);
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce" + Keys.ENTER);
		
		List<WebElement> products = new ArrayList<WebElement>();
		List<WebElement> prices = new ArrayList<WebElement>();
		
		products = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		
		System.out.println("Size of the list: " + products.size());
		
		for (int i = 0; i < prices.size(); i++) {
			System.out.println("Price of element " + (i+1) + " is: " + prices.get(i).getText());
		}
	}
	
	public static void verifyEnabled() {
		
	}
}
