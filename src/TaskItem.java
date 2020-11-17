import java.io.*;

public class TaskItem implements Serializable {

    private String dueDate;

    private String title;

    private String description;

    private boolean completionStatus;

    public TaskItem(String title, String description, String dueDate, boolean completionStatus) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completionStatus = completionStatus;

    }

    public String getDueDate() {
        return dueDate;
    }

    public String setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String setTitle(String title) {
        this.title = title;
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String absoluteStatus() {
        if (completionStatus) {
            return "Complete";
        } else
            return "Incomplete";
    }


    public String setDescription(String description) {
        this.description = description;
        return description;
    }

    public boolean isCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }


    @Override
    public String toString() {
        return
title + "," + description + "," + dueDate + "," + absoluteStatus();


    }
}
