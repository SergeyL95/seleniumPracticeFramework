package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTables {
	public static void main(String[] args) {
			String projectDir = System.getProperty("user.dir");
			String driverPath = projectDir + "/drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			
			WebTables wtProj = new WebTables();
			wtProj.testCaseOne();
			
	}
	
	public static void testCaseOne() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		String tableTitle = "Web Tables";
		String actualTableTitle;
		String regID = "23";
		String actualID;
		String firstName = "Michael";
		String actualFirstName;
		String lastName = "Jordan";
		String actualLastName;
		String regSalary = "100000";
		String actualSalary;
		
		driver.get("http://practice.primetech-apps.com/practice/web-tables");
		driver.manage().window().maximize();
		
		actualTableTitle = driver.findElement(By.xpath("//h3[@class='mb-5']")).getText();
		
		driver.findElement(By.cssSelector("#Id")).sendKeys(regID);
		driver.findElement(By.xpath("//input[@id='First Name']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='Last Name']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='Salary']")).sendKeys(regSalary);
		driver.findElement(By.cssSelector(".btn-primary")).click();
		
		
		actualID = driver.findElement(By.xpath("//td[text()='23']")).getText();
		actualFirstName = driver.findElement(By.xpath("//td[text()='Michael']")).getText();
		actualLastName = driver.findElement(By.xpath("//td[contains(text(),'Jordan')]")).getText();
		actualSalary = driver.findElement(By.xpath("//td[contains(text(),'100000')]")).getText();
		
		
		if (regID.equals(actualID)) {
			System.out.println("ID Verfication PASSED");
		} else {
			System.out.println("ID Verfication FAILED");
			System.out.println("Expected ID: " + regID);
			System.out.println("Actual ID: " + actualID);
		}
		
		if (firstName.equals(actualFirstName)) {
			System.out.println("First Name Verfication PASSED");
		} else {
			System.out.println("First Name Verfication FAILED");
			System.out.println("Expected First Name: " + firstName);
			System.out.println("Actual First Name: " + actualFirstName);
		}
		
		if (lastName.equals(actualLastName)) {
			System.out.println("Last Name Verfication PASSED");
		} else {
			System.out.println("Last Name Verfication FAILED");
			System.out.println("Expected Last Name: " + lastName);
			System.out.println("Actual Last Name: " + actualLastName);
		}
		
		if (regSalary.equals(actualSalary)) {
			System.out.println("Salary Verfication PASSED");
		} else {
			System.out.println("Salary Verfication FAILED");
			System.out.println("Expected Salary: " + regSalary);
			System.out.println("Actual Salary: " + actualSalary);	
		}
		
		
		
	}
}
