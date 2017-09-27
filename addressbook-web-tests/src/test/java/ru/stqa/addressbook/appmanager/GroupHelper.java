package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.data.GroupData;
import ru.stqa.addressbook.data.Groups;

import java.util.List;

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

    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector(String.format("input[value='%s']", id))).click();
    }

    public void clickGroupUpdate()  {
        click(By.name("edit"));
    }

    public void submitGroupUpdate() { click(By.name("update")); }

    public int count(){
        return wd.findElements(By.name("selected[]")).size();
    }

    private Groups groupCache = null;

    public Groups all() {
        if(groupCache != null){
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements)
        {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }

    public void create(GroupData group) {
        clickCreateGroup();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }

    public void update(GroupData group) {
        selectGroupById(group.getId());
        clickGroupUpdate();
        fillGroupForm(group);
        submitGroupUpdate();
        groupCache = null;
        returnToGroupPage();
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteGroup();
        groupCache = null;
        returnToGroupPage();
    }
}
