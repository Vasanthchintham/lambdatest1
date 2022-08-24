package onlyOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Lambdatest
{
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chint\\Downloads\\ChromeDriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground");
		Thread.sleep(5000);
		//First Test Case	
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Simple Form Demo")).click();
		System.out.println(driver.getCurrentUrl().contains("simple-form-demo"));
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys("Welcome to LamdaTest");
		driver.findElement(By.xpath("//button[@id='showInput']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='message']")).getText(),"Welcome to LamdaTest");
		Thread.sleep(5000);
		//Second Test Case
		driver.navigate().back();
		driver.findElement(By.linkText("Drag & Drop Sliders")).click();
		WebElement dr=driver.findElement(By.xpath("//output[@id='rangeSuccess']"));
		dr.click();
		Thread.sleep(5000);
		//Third Test Case		
		driver.navigate().back();
		driver.findElement(By.linkText("Input Form Submit")).click();
		driver.findElement(By.xpath("//div[@class='text-right mt-20']/button")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Vasanth");
		driver.findElement(By.xpath("//input[@id='inputEmail4']")).sendKeys("Vasanth@gmail.com");
		driver.findElement(By.xpath("//input[@id='inputPassword4']")).sendKeys("Vasanth@123");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Mindtree");
		driver.findElement(By.xpath("//input[@id='websitename']")).sendKeys("www.vasanth.com");
		Select s=new Select(driver.findElement(By.xpath("//select[@name='country']")));
		s.selectByVisibleText("United States");
		driver.findElement(By.xpath("//input[@id='inputCity']")).sendKeys("Thirupathi");
		driver.findElement(By.xpath("//input[@id='inputAddress1']")).sendKeys("Some Random");
		driver.findElement(By.xpath("//input[@id='inputAddress2']")).sendKeys("Some Random2");
		driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys("Andhra Pradesh");
		driver.findElement(By.xpath("//input[@id='inputZip']")).sendKeys("123456");
		driver.findElement(By.xpath("//div[@class='text-right mt-20']/button")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText(),"Thanks for contacting us, we will get back to you shortly.");		
		driver.quit();
	}
}
