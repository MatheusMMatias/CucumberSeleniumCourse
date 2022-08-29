package utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {

    //Variables
    public WebDriver driver;

    //Constructor
    public GenericUtils(WebDriver driver){
        this.driver = driver;
    }

    //Methods
    public void switchToChildWindow(){
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> i = windows.iterator();
        String parentWindow = i.next();
        String childWindow = i.next();
        driver.switchTo().window(childWindow);
    }
}