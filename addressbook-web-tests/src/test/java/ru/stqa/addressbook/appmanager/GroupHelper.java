package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.addressbook.data.GroupData;

public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        enterText(By.name("group_name"), groupData.getName());
        enterText(By.name("group_header"), groupData.getHeader());
        enterText(By.name("group_footer"), groupData.getFooter());
    }

    public void clickCreateGroup() {
        click(By.name("new"));
    }

    public void deleteGroup() { click(By.name("delete")); }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void clickGroupUpdate()  {
        click(By.name("edit"));
    }

    public void SubmitGroupUpdate() { click(By.name("update")); }

    public void createGroup(GroupData group) {
        clickCreateGroup();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }
}
