package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.addressbook.data.ContactData;

public class ContactHelper extends BaseHelper {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData) {
        enterText(By.name("firstname"), contactData.getFirstName());
        enterText(By.name("lastname"), contactData.getLastName());
        enterText(By.name("address"), contactData.getAddress());
        enterText(By.name("mobile"), contactData.getMobilePhone());
        enterText(By.name("email"), contactData.getEmail());
    }

    public void clickAddContact() {
        click(By.linkText("add new"));
    }
}
