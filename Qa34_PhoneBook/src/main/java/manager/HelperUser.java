package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{


    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginRegistrationForm() {
        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
        loginTab.click();
    }

    public void submitLogin() {
        wd.findElement(By.xpath("//button[1]")).click();
    }

    public void submitRegistration() {
        wd.findElement(By.xpath("//button[2]")).click();
    }

    public void fillLoginRegistrationForm(String email, String password) {

        // find +click+clear+sendKey
        type(By.xpath("//input[1]"), email);

        // find +click+clear+sendKey
        type(By.xpath("//input[2]"), password);
    }

}
