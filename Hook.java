package com.app.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.app.base.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook extends Base {
	
	@Before
	public void before() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void teardown() {
		screenShot();
	}
	
	public static void screenShot() {
	    File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File dest = new File(System.getProperty("user.dir")+ "/ScreenShot" + timestamp() + ".png");
	    try {
			FileUtils.copyFile(scr, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	} 
}
