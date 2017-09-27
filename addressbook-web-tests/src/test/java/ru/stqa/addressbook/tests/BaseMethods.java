package ru.stqa.addressbook.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.addressbook.appmanager.AppManager;
import org.openqa.selenium.remote.BrowserType;

public class BaseMethods {

    protected static final AppManager app = new AppManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }
}
