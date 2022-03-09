package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebok {

	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://en-gb.facebook.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	
	driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Revathi");		
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Krishnan");	
	driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("revathikrishnan89@gmail.com");
	driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("revathikrishnan89@gmail.com");
	
	
	driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("AdviKrish");
	WebElement Date= driver.findElement(By.xpath("//select[@title='Day']"));
	Select day=new Select(Date);
	day.selectByIndex(23);
	
	
	WebElement Month= driver.findElement(By.xpath("//select[@title='Month']"));
	Select mnt=new Select(Month);
	mnt.selectByVisibleText("Jun");
	
	WebElement Year = driver.findElement(By.xpath("//select[@title='Year']"));
	Select yy=new Select(Year);
	yy.selectByValue("2011");
	
	driver.findElement(By.xpath("//label[text()='Female']")).click();
	//driver.findElement(By.xpath("//label[text()='Male']"));
	driver.findElement(By.xpath("//label[text()='Custom']"));
	driver.findElement(By.xpath("//button[@name='websubmit']")).click();
Thread.sleep(3000);
	driver.close();
	
	}

}
