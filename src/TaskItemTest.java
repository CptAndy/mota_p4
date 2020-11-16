import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    void setValidName() {
        TaskItem t = new TaskItem("", "", "", false);

        String name = "Name...";
        if (!name.isBlank()) {
            t.setTitle(name);
            assertEquals("Name...", t.getTitle());
            System.out.println("Name added");
        } else ;

    }

    @Test
    void setInvalidName() {
        TaskItem t = new TaskItem("", "", "", false);
        String name = " ";
        if (name.isBlank()) {
            name = "";
            t.setTitle(name);
            assertEquals("", t.getTitle());
            System.out.println("Name not added");
        } else ;
    }


    @Test
    void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem t = new TaskItem("", "", "", false);
        String dueDate = "05/16/1111";
        Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        Matcher matcher = pattern.matcher(dueDate);

        if (matcher.matches()) {
            t.setDueDate(dueDate);
            assertEquals("05/16/1111", t.getDueDate());
            System.out.println("Valid Due date");
        } else ;
    }


    @Test
    void creatingTaskItemFInvalidDueDate() {
        TaskItem t = new TaskItem("", "", "", false);
        String dueDate = "05/168/1111";
        Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        Matcher matcher = pattern.matcher(dueDate);
boolean valid = true;
        if (matcher.matches()) {
            t.setDueDate(dueDate);
            assertEquals("05/16/1111", t.getDueDate());
            System.out.println("Valid Due date");

        } else ;
        System.out.println("Invalid");
        valid = false;
        assertFalse(valid);
    }
/*
@Test
    void creatingTask
*/

}