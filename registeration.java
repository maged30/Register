package com.browsers.Test.drivers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class registeration {
	ChromeDriver driver ;
	@BeforeTest
	public void opentravelapp () {
		String cpath = System.getProperty("user.dir")+"//Drivers//chromedriver";
		System.setProperty("webdriver.chrome.driver",cpath);
        driver = new ChromeDriver();
        driver.navigate().to("https://www.phptravels.net/register");
        driver.manage().window().maximize();
	}
	@Test
	public void register () {
		WebElement Firstname = driver.findElement(By.name("first_name"));
		WebElement Lastname = driver.findElement(By.name("last_name"));
		WebElement Phone = driver.findElement(By.name("phone"));
		WebElement Email = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[3]/div/div[2]/div[2]/div/form/div[4]/div/input"));
		WebElement Password = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[3]/div/div[2]/div[2]/div/form/div[5]/div/input"));
		WebElement Signup = driver.findElement(By.name("signup"));
		Select Acctype = new Select(driver.findElement(By.xpath("//*[@id=\"select2-account_type-container\"]")));
		System.out.println(Firstname.getText());
		System.out.println(Lastname.getText());
		System.out.println(Phone.getText());
		System.out.println(Email.getText());
		System.out.println(Password.getText());
		System.out.println();
		List typeValues = new ArrayList();
		for (WebElement element: Acctype.getOptions()) {
			typeValues.add(element.getText());	
		}	
		List expectedtypeValues= new ArrayList();
		expectedtypeValues.add("Customer");
		expectedtypeValues.add("Supplier");
		expectedtypeValues.add("Agent");
        for (int i = 0; i < typeValues.size(); i++) {
			Assert.assertTrue((boolean) typeValues.get(i).equals(expectedtypeValues.get(i)));
			System.out.println(typeValues.get(i));
			System.out.println(expectedtypeValues.get(i));
		}
	}
   @AfterTest
   public void quitapp () {
	   driver.quit();
   }
   }

