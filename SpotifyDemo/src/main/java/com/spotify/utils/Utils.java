package com.spotify.utils;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.PageFactory;

import com.spotify.utils.Utils;

public class Utils 
{

		WebDriver driver;
		
		public Utils(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
			log.info("Elements initialized");
		}
		Logger	log	= Logger.getLogger(Utils.class);
		
		public WebElement handleElement(WebElement ele)
		{
			log.info(ele + " is initialized");
			return ele;
		}
		
		public void waitForElement(int time) throws InterruptedException
		{
			Thread.sleep(time);
		}
		
		public void screenShot() throws IOException
		{
				int random = (int)Math.random()*1000;
			    File sf=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        FileUtils.copyFile(sf, new File("./image/shot"+random+".png"),true);
		        log.info("Took screen shot");
		}
		
		public void verify(WebElement ele) throws IOException
		{
			if (handleElement(ele).isDisplayed())
			{ 
				log.info("Landed to the page");
			}
			else
				log.error("error");
		}
		public void scrollDown(WebElement ele){
			
			Coordinates co = ((Locatable)ele).getCoordinates();
			
			co.inViewPort();
			
			log.info("Landed to the page");
			
			
		}
		
		public void click(WebElement element)
		{
			element.click();
		}

}
