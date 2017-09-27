package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.data.GroupData;
import ru.stqa.addressbook.data.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreateTests extends BaseMethods {

    @Test
    public void createGroup() throws InterruptedException {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("name").withFooter("footer").withHeader("header");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test
    public void createBadNameGroup() throws InterruptedException {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("name'").withFooter("footer").withHeader("header");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }
}
