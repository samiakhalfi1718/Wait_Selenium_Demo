package Wait_Demo.Wait_Demo;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Wait_Implicit_Demo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		
		// setting an implicit wait of 10 seconds
		long time = 2000;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
		String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(URL);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, URL);
		
	}

}
