package ru.stqa.addressbook.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.addressbook.data.GroupData;
import ru.stqa.addressbook.data.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupUpdateTests extends BaseMethods {

    @BeforeTest
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if(app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("name").withFooter("footer").withHeader("header"));
        }
    }

    @Test
    public void UpdateGroupTests() throws InterruptedException {

        Groups before = app.group().all();
        GroupData updatedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(updatedGroup.getId()).withName("updname").withFooter("updfooter").withHeader("updheader");
        app.group().update(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.without(updatedGroup).withAdded(group)));
    }


}
