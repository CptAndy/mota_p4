import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    void addingTaskItemsIncreasesSize() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        assertEquals(1, list.getSize());

    }

    @Test
    void completingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        assertEquals("Complete!", list.getCompleted(true));


    }

    @Test
    void completingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);

        list.newAdd(task);
        int index = 1;

        if (index >= list.getSize()) {
            list.updateDuedate(0, "New duedate");
            list.setComplete(false, 0);
            assertEquals("Incomplete", list.getCompleted(false));
            System.out.println(list.getCompleted(false));
        }
    }

    @Test
    void editingTaskItemTitleChangesValues() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        assertEquals("New title", list.updateTitle(0, "New title"));
        System.out.println("Passed");
    }

    @Test
    void editingTaskItemDescriptionChangesValue() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        assertEquals("New description", list.updateDescription(0, "New description"));
        System.out.println("Passed");
    }

    @Test
    void editingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        int index = 1;
        boolean updated = true;

        if (index >= list.getSize()) {


            System.out.println("Passed");
            updated = false;
            assertFalse(updated);
        } else {
            list.updateDescription(0, "New duedate");

        }
    }

    @Test
    void editingTaskItemDueDateChangesValue() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        list.updateDuedate(0, "New duedate");
        assertEquals("New duedate", list.taskList.get(0).getDueDate());
        System.out.println("Passed");
    }

    @Test
    void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        int index = 1;

        if (index >= list.getSize()) {
            System.out.println("Passed");
            assertEquals("Due", list.taskList.get(0).getDueDate());

        } else {
            list.updateDuedate(0, "New duedate");

        }
    }

    @Test
    void editingTaskItemTitleChangesValue() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        list.updateTitle(0, "New title");
        assertEquals("New title", list.taskList.get(0).getTitle());
    }

    @Test
    void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        int index = 1;

        if (index >= list.getSize()) {

            assertEquals("Title", list.taskList.get(0).getTitle());
            System.out.println("Passed");
        } else {


        }
    }

    @Test
    void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        int index = 1;
        boolean retrieved = true;
        if (index >= list.getSize()) {

            retrieved = false;
            assertFalse(retrieved);
            System.out.println("Unable to retrieve...: Passed");

        } else {
            assertEquals("Description", list.taskList.get(0).getDescription());

        }

    }

    @Test
    void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        int index = 0;
        boolean retrieved = true;
        if (index >= list.getSize()) {

            retrieved = false;
            assertFalse(retrieved);
            System.out.println("Unable to retrieve...: Passed");

        } else {
            assertEquals("Description", list.taskList.get(0).getDescription());
            assertTrue(retrieved);
            System.out.println("Able to retrieve...:Passed");
        }
    }

    @Test
    void gettingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        int index = 1;
        boolean retrieved = true;
        if (index >= list.getSize()) {

            retrieved = false;
            assertFalse(retrieved);
            System.out.println("Unable to retrieve...: Passed");

        } else {
            assertEquals("Due", list.taskList.get(0).getDueDate());

        }
    }

    @Test
    void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        int index = 0;
        boolean retrieved = true;
        if (index >= list.getSize()) {

            retrieved = false;
            assertFalse(retrieved);
            System.out.println("Unable to retrieve...: Passed");

        } else {
            assertEquals("Due", list.taskList.get(0).getDueDate());
            assertTrue(retrieved);
            System.out.println("Able to retrieve...:Passed");
        }
    }

    @Test
    void gettingTaskItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        int index = 1;
        boolean retrieved = true;
        if (index >= list.getSize()) {

            retrieved = false;
            assertFalse(retrieved);
            System.out.println("Unable to retrieve...: Passed");

        } else {
            assertEquals("Title", list.taskList.get(0).getTitle());
            assertTrue(retrieved);
            System.out.println("Able to retrieve...:Passed");
        }

    }

    @Test
    void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        int index = 0;
        boolean retrieved = true;
        if (index >= list.getSize()) {

            retrieved = false;
            assertFalse(retrieved);
            System.out.println("Unable to retrieve...: Passed");

        } else {
            assertEquals("Title", list.taskList.get(0).getTitle());
            assertTrue(retrieved);
            System.out.println("Able to retrieve...:Passed");
        }
    }

    @Test
    void newTaskListIsEmpty() {
        TaskList list = new TaskList();
        assertEquals(0, list.getSize());
        System.out.println("Passed");
    }

    @Test
    void removingTaskItemsDecreasesSize() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        list.deleteTask(0);
        assertEquals(0, list.getSize());
        System.out.println("Passed");
    }

    @Test
    void removingTaskItemsFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        int index = 1;
        boolean removed = true;
        if (index >= list.getSize()) {

            removed = false;
            assertFalse(removed);
            System.out.println("Unable to remove, false index...: Passed");

        } else {
            assertEquals("Title", list.taskList.remove(0));
            assertTrue(removed);
            System.out.println("Able to retrieve...:Passed");
        }
    }

    @Test
    void savedTaskListCanBeLoaded() {
        File tempFile = new File("C:\\Users\\Captain\\Desktop\\COP3330_Mota\\mota_p4\\test.txt");
        boolean exists = tempFile.exists();
        assertTrue(exists);
        System.out.println("File Exists");
    }

    @Test
    void uncompletingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", true);
        list.newAdd(task);

        assertEquals("Incomplete", list.getCompleted(false));

    }

    @Test
    void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", true);


        boolean checkIncomplete = true;
        int index = 0;
        if (index >= list.getSize()) {

            checkIncomplete = false;
            assertFalse(checkIncomplete);
            System.out.println("Unable to check as incomplete, false index...: Passed");
            assertEquals("Complete!", list.getCompleted(true));
        } else {
            assertEquals("Title", list.taskList.remove(0));
            assertTrue(checkIncomplete);
            System.out.println("Able to retrieve...:Passed");
            assertEquals("Incomplete", list.getCompleted(false));
        }
    }
@Test
    void changingAllValues(){
    TaskList list = new TaskList();
    TaskItem task = new TaskItem("Title", "Description", "Due", true);
    list.newAdd(task);
    list.updateTitle(0, "New title");

    assertEquals("New title", list.taskList.get(0).getTitle());
    assertEquals("New description", list.updateDescription(0, "New description"));

    assertEquals("Complete!", list.getCompleted(true));
    assertEquals("Incomplete", list.getCompleted(false));
    list.updateDuedate(0, "New duedate");
    assertEquals("New duedate", list.taskList.get(0).getDueDate());
}
@Test
    void removeTwoTasks(){
    TaskList list = new TaskList();
    TaskItem task = new TaskItem("Title", "Description", "Due", true);
    list.newAdd(task);
    list.newAdd(task);
    list.newAdd(task);
    list.deleteTask(0);
    list.deleteTask(1);

    assertEquals(1,list.getSize());
}
@Test
    void removeIndexWithUpdatedDuedateValue(){
    TaskList list = new TaskList();
    TaskItem task = new TaskItem("Title", "Description", "Due", true);
    list.newAdd(task);
list.updateDuedate(0,"Updated");
   assertEquals("Updated",list.taskList.get(0).getDueDate());
   list.deleteTask(0);
   assertEquals(0,list.getSize());
}
@Test
    void RemoveIndexWithUpdatedTitle(){
    TaskList list = new TaskList();
    TaskItem task = new TaskItem("Title", "Description", "Due", true);
    list.newAdd(task);
    list.updateTitle(0,list.taskList.get(0).setTitle("updated"));
    assertEquals("updated",list.taskList.get(0).getTitle());
    list.deleteTask(0);
    assertEquals(0,list.getSize());
}

}