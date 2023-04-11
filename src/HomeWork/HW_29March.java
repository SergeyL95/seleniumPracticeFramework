package HomeWork;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import utils.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW_29March {
	public static void main(String[] args) {
		String projectDir = System.getProperty("user.dir");
		String driverPath = projectDir + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		testCaseOne();
		testCaseTwo();
	}
	
	public static void testCaseOne() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		String mainWindow = driver.getWindowHandle();
		String homeTitle = driver.getTitle();
		
		Duration dur = Duration.ofSeconds(5);
		driver.manage().timeouts().implicitlyWait(dur);
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();
		String firstWindow = it.next();
		String secondWindow = it.next();
		
		driver.switchTo().window(secondWindow);
		
		String emailReg = "sergey@gmail.com";
		WebElement emailInput = driver.findElement(By.xpath("//input[@name='emailid']"));
		emailInput.sendKeys(emailReg);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		String userId = driver.findElement(By.xpath("//td[contains(text(), 'User ID')]/following-sibling::td")).getText();
		String userPass = driver.findElement(By.xpath("//td[contains(text(), 'Password')]/following-sibling::td")).getText();
		System.out.println("User ID: " + userId);
		System.out.println("Password: " + userPass);
		
		String expectedMessage = "This access is valid only for 20 days.";
		String actualMessage = driver.findElement(By.xpath("//td[@colspan='2']/h3")).getText();
		if (actualMessage.equals(expectedMessage)) {
			System.out.println("Message Validation PASSED");
		} else {
			System.out.println("Message Validation FAILED");
		}
		
		driver.close();
		driver.switchTo().window(mainWindow);	
		
		String currentTitle = driver.getTitle();
		if (currentTitle.equals(homeTitle)) {
			System.out.println("Main Window Title Validationa PASSED");
		} else {
			System.out.println("Main Window Title Validationa FAILED");
		}
		
		driver.quit();
	}
	
	public static void testCaseTwo() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://practice.primetech-apps.com/practice/frames");
		driver.manage().window().maximize();
		
		String expectedHeader = "Frames";
		String actualHeader = driver.findElement(By.xpath("//h3[@class='mb-5']")).getText();
		
		if (actualHeader.equals(expectedHeader)) {
			System.out.println("Header Title Validation PASSED");
		} else {
			System.out.println("Header Title Validation FAILED");
		}
		
		WebElement workFrame = driver.findElement(By.xpath("//iframe[@id='iframe1']"));
		driver.switchTo().frame(workFrame);
		
		driver.findElement(By.id("firstName")).sendKeys("Trevor");
		driver.findElement(By.id("lastName")).sendKeys("Lawrence");
		driver.findElement(By.id("address")).sendKeys("904 Bold City");
		driver.findElement(By.id("city")).sendKeys("Jacksonvulle");
		WebElement dropDown = driver.findElement(By.id("state"));
		Select selectOption = new Select(dropDown);
		selectOption.selectByValue("Florida");
		driver.findElement(By.id("zipCode")).sendKeys("32259");
		driver.findElement(By.id("gridCheck")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();
		
		
		WebElement submitMessage = driver.findElement(By.xpath("//div[@class='result-container']/h3"));
		if (submitMessage.isDisplayed()) {
			System.out.println("Message Visability PASSED");
		} else {
			System.out.println("Message Visability FAILED");
		}
		
		driver.switchTo().defaultContent();
		if (actualHeader.equals(expectedHeader)) {
			System.out.println("Second Header Title Validation PASSED");
		} else {
			System.out.println("Second Header Title Validation FAILED");
		}
		
		driver.close();
	}
}
