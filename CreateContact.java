package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.findElement(By.id("username")).sendKeys("demoSalesManager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.linkText("Create Contact")).click();
	driver.findElement(By.id("firstNameField")).sendKeys("Krishnapriya");
	driver.findElement(By.id("lastNameField")).sendKeys("M");
	driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Krishna");
	driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Priya");
	driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT");
	driver.findElement(By.name("description")).sendKeys("HardWorker");
	driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("ascfvd@gmai.com");
	WebElement StateOrProvince= driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
	Select State=new Select(StateOrProvince);
	State.selectByVisibleText("New York");
	driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
	driver.findElement(By.linkText("Edit")).click();
	driver.findElement(By.name("description")).clear();
	driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("From TCS");
	driver.findElement(By.xpath("//input[@value='Update']")).click();
	String title = driver.getTitle();
	System.out.println(title);
	Thread.sleep(3000);
	driver.close();
	
	
	}

}
