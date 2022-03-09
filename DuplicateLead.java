package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("aaa@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		String LeadId = driver.findElement(By.xpath("//div[text()='Lead ID']/../../../../../../../following::div/div[1]/div[1]/table/tbody/tr/td[1]/div[1]/a")).getText();
		
		System.out.println("Lead id"+LeadId);
		driver.findElement(By.xpath("//div[text()='Lead ID']/../../../../../../../following::div/div[1]/div[1]/table/tbody/tr/td[1]/div[1]/a")).click();
		
		String Fname= driver.findElement(By.id("viewLead_firstName_sp")).getText();
		String Lname= driver.findElement(By.id("viewLead_lastName_sp")).getText();
			String str=Fname.concat(Lname);
			System.out.println("name of the lead="+str);
		
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		String title = driver.getTitle();
	
		
		System.out.println(title);
		
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		Thread.sleep(2000);
String DupeFname= driver.findElement(By.id("viewLead_firstName_sp")).getText();
String DupeLname= driver.findElement(By.id("viewLead_lastName_sp")).getText();
String str2=DupeFname.concat(DupeLname);
	System.out.println(str2);
	if(Fname.equals(DupeFname))
			{
		System.out.println("Duplicate Lead present");
		
			}
	driver.close();
		
		

	}

}
