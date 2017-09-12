package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.addressbook.data.ContactData;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
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

    public void clickContactUpdate() { click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")); }

    public void SubmitContactUpdate() { click(By.name("update")); }

    public void selectContact() { click(By.name("selected[]")); }

    public void deleteContact() { click(By.xpath("//div[@id='content']/form[2]/div[2]/input")); }

    public void confirmContactDeletion() { wd.switchTo().alert().accept(); }
}
