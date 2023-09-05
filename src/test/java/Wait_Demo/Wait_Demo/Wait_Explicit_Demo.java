package Wait_Demo.Wait_Demo;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wait_Explicit_Demo {

	public static void main(String[] args) {

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();

		String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(URL);

		// creating a WebDriverWait object and assigning the driver instance and a max
		// wait time
		long time = 2000;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

		// setting an expected condition to check visibility of the element and parsing
		// the locator
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, URL);
	}

}
