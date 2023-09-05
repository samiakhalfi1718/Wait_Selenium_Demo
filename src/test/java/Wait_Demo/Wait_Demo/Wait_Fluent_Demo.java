package Wait_Demo.Wait_Demo;

import java.time.Duration;
import java.util.function.Function;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wait_Fluent_Demo {

	public static void main(String[] args) {

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();

		String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(URL);

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");

		// click on Login button with Fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(300))
				.pollingEvery(Duration.ofSeconds(500))
				.ignoring(NoSuchElementException.class);
		
		WebElement btnlogin = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//button[@type=\"submit\"]"));
			}
		});
		
		btnlogin.click();
		
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, URL);

	}

}
