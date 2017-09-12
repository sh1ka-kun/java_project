package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends BaseHelper{

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String login, String password) {
        enterText(By.name("user"), login);
        enterText(By.name("pass"), password);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}
