package shoppingwebsite.automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactUs {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");

		driver.manage().window().maximize();
	}

	@Test
	public void contactUS() {

		driver.findElement(By.id("contact-link")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement element = driver.findElement(By.id("id_contact"));
		Select sc = new Select(element);
		sc.selectByVisibleText("Customer service");

		driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
		driver.findElement(By.id("id_order")).sendKeys("123445");
		driver.findElement(By.id("fileUpload"))
				.sendKeys("C:\\Users\\user\\eclipse-workspace\\importantPrograms\\src\\importantPrograms");
		driver.findElement(By.id("message")).sendKeys("hlo software world ");
		driver.findElement(By.id("submitMessage")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void afteTest() {
		driver.quit();
	}
}
