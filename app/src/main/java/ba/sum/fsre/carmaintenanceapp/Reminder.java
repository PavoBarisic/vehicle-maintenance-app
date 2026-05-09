package ba.sum.fsre.carmaintenanceapp;

public class Reminder {
    private String id;
    private String reminderName;
    private String reminderDate;
    private String userID;

    public Reminder() {
    }

    public Reminder(String reminderName, String reminderDate) {
        this.reminderName = reminderName;
        this.reminderDate = reminderDate;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getreminderName() { return reminderName; }
    public void setreminderName(String reminderName) { this.reminderName = reminderName; }

    public String getreminderDate() { return reminderDate; }
    public void setreminderDate(String reminderDate) { this.reminderDate = reminderDate; }

    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }
}