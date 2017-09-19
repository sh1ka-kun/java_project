package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.addressbook.data.ContactData;
import ru.stqa.addressbook.data.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
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

    public void clickContactUpdate(int index) { wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click(); }


    public void submitContactUpdate() { click(By.name("update")); }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click(); }

    public void deleteContact() { click(By.xpath("//div[@id='content']/form[2]/div[2]/input")); }

    public void confirmContactDeletion() { wd.switchTo().alert().accept(); }

    public void createContact(ContactData contact) {
        clickAddContact();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tbody/tr[@name='entry']"));
        for (WebElement element : elements)
        {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            ContactData contact = new ContactData(id, firstName, lastName, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
