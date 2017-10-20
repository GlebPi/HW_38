package core;

import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class Safari {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		String url = "http://facebook.com/";
		String email_address = "abc@gmail.cc";
		String password = "*******************";

		if (!System.getProperty("os.name").contains("Mac")) {throw new IllegalArgumentException("Safari is available only on Mac");}
			
		driver = new SafariDriver(); 
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		System.out.println("Browser is: Firefox");
		driver.get(url);
		System.out.println("Title: " + driver.getTitle() + ";\t URL: " + driver.getCurrentUrl() + ";\t Handle: " + driver.getWindowHandle());
		Thread.sleep(1000); // Pause in milleseconds (1000 – 1 sec)
		
		String copyright = driver.findElement(By.xpath("//*[@id=\'pageFooter\']/div[3]/div/span")).getText();
		System.out.println("Copyright: " + copyright);
		 
		driver.findElement(By.id("email")).sendKeys(email_address);
		driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("u_0_2")).click();
        
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span")).click();

        Thread.sleep(1000);
        String friends = driver.findElement(By.xpath("//div[2]/ul/li[3]/a/span[1]")).getText();
        System.out.println("You have " + friends + " friends");
        
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
        WebElement settings = driver.findElement(By.id("userNavigationLabel"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", settings);

        WebElement logout = driver.findElement(By.xpath("//div/div/ul/li[22]/a/span/span")); 
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);

		driver.quit();
      
	}
}