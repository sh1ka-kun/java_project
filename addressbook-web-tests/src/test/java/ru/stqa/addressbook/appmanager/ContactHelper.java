package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.data.ContactData;
import ru.stqa.addressbook.data.Contacts;

import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData) {
        enterText(By.name("firstname"), contactData.getFirstName());
        enterText(By.name("lastname"), contactData.getLastName());
        enterText(By.name("address"), contactData.getAddress());
        enterText(By.name("home"), contactData.getHomePhone());
        enterText(By.name("mobile"), contactData.getMobilePhone());
        enterText(By.name("work"), contactData.getWorkPhone());
        enterText(By.name("email"), contactData.getEmail());
        attachFile(By.name("photo"), contactData.getPhoto());
    }

    public void clickAddContact() {
        click(By.linkText("add new"));
    }

    public void clickContactUpdateById(int id) {
        wd.findElement(By.xpath(String.format("//a[@href='edit.php?id=%s']", id))).click();
    }


    public void submitContactUpdate() { click(By.name("update")); }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click(); }

    public void deleteContact() { click(By.xpath("//div[@id='content']/form[2]/div[2]/input")); }

    public void confirmContactDeletion() { wd.switchTo().alert().accept(); }

    public void create(ContactData contact) {
        clickAddContact();
        fillContactForm(contact);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }

    public int count(){
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if(contactCache != null){
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//tbody/tr[@name='entry']"));
        for (WebElement element : elements)
        {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String address = cells.get(3).getText();
            String email = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            contactCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).
                    withAddress(address).withEmail(email).withAllPhones(allPhones));
        }
        return new Contacts(contactCache);
    }

    public void update(ContactData contact) {
        clickContactUpdateById(contact.getId());
        fillContactForm(contact);
        submitContactUpdate();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
        confirmContactDeletion();
        contactCache = null;
        returnToHomePage();
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public ContactData infoFromEditForm(ContactData contact) {
        clickContactUpdateById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName)
                .withAddress(address).withEmail(email)
                .withMobilePhone(mobile).withHomePhone(home).withWorkPhone(work);
    }
}
