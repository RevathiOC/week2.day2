package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		driver.findElement(By.xpath(
				"//span[text()='Name and ID']/../../../../../../../following::div[1]/div/div/div/div[1]//input[@name='firstName']"))
				.sendKeys("Hema");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		String LeadId = driver.findElement(By.xpath(
				"//div[text()='Lead ID']/../../../../../../../following::div/div[1]/div[1]/table/tbody/tr/td[1]/div[1]/a"))
				.getText();
		System.out.println("Lead id" + LeadId);
		driver.findElement(By.xpath(
				"//div[text()='Lead ID']/../../../../../../../following::div/div[1]/div[1]/table/tbody/tr/td[1]/div[1]/a"))
				.click();
		String ViewLeadPage = driver.getTitle();
		System.out.println(ViewLeadPage);
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		WebElement Company = driver.findElement(By.id("updateLeadForm_companyName"));
		Company.clear();

		Company.sendKeys("QAZ");
		//Thread.sleep(2000);

		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String updatedCompanyName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println("Updated company name=" + updatedCompanyName);
		if (driver.findElement(By.xpath("//span[contains(text(),'QAZ')]")).isDisplayed()){
			System.out.println("company name changed");
		}
		driver.close();

	}

}
