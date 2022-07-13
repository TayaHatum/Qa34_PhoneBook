package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.xpath("//a[text()='ADD']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"),contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"),contact.getLastname());
        type(By.cssSelector("[placeholder='Phone']"),contact.getPhone());
        type(By.cssSelector("[placeholder='email']"),contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"),contact.getAddress());
        type(By.cssSelector("[placeholder='description']"),contact.getDescription());
    }

    public void saveContact() {
        click(By.cssSelector("button b"));
    }
    public void saveContact2() {
        wd.findElement(By.cssSelector("[placeholder='description']")).sendKeys(Keys.TAB);
        wd.findElement(By.cssSelector(".add_form__2rsm2 button")).sendKeys(Keys.ENTER);

    }

    public boolean isContactAddedByName(String name) {
        List<WebElement> names = wd.findElements(By.cssSelector("h2"));

        for(WebElement el:names){
            if(el.getText().equals(name)){
                return true;
            }

        }
        return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List <WebElement> phones = wd.findElements(By.cssSelector("h3"));
        for (WebElement el:phones){
            if(el.getText().equals(phone)){
                return true;
            }
        }
        return false;
    }

    public int removeOneContact() {

        int countBefore  = countOfContacts();
        System.out.println(countBefore);
        if(!isContactListEmpty()){
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
            pause(500);

        }

        int countAfter = countOfContacts();
        System.out.println(countAfter);
        return countBefore-countAfter;
    }

    public int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    private boolean isContactListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }
}