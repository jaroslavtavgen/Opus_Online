import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    ChromeDriver driver;
    public String correctNameOfTheCompanyIsDisplayed;
    public String correctAddressIsDisplayed;
    public boolean correctPhone = false; // different method because browser may encapsule the phone inside "a" tag, and may not encapsule
    public boolean navigationLinkIsPresent = false;
    public Main(){
        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://www.google.com/");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Opus Online" + Keys.RETURN);
        correctNameOfTheCompanyIsDisplayed = driver.findElement(By.xpath("//*[@id='rhs_block']/div/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/div/div[1]/span")).getAttribute("innerHTML");
        correctAddressIsDisplayed = driver.findElement(By.xpath("//*[@id='rhs_block']/div/div[1]/div/div[1]/div[2]/div[3]/div/div[2]/div/div/span[2]")).getAttribute("innerHTML");
        WebElement phone = driver.findElement(By.xpath("//*[@id='rhs_block']/div/div[1]/div/div[1]/div[2]/div[3]/div/div[4]/div/div/span[2]/span/span"));
        correctPhone = phone.getAttribute("innerHTML").contains("682 9670");
        List<WebElement> ab_buttons = driver.findElements(By.xpath("//*[contains(@class, 'ab_button')]"));
        ArrayList<String> suitableLabels = new ArrayList<>();
        suitableLabels.add("Website");
        suitableLabels.add("Veeb");
        for(WebElement ab_button: ab_buttons){
            String attribute = ab_button.getAttribute("innerHTML");
            if(attribute != null){
                if(suitableLabels.contains(attribute)){
                    navigationLinkIsPresent = true;
                    break;
                }
            }
        }
        driver.quit();
    }
    public static void main(String[] arguments){
        new Main();
    }
}
