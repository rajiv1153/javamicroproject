import java.util.Date;

public class ToDoData {
    private int id;
    private String description;
    private boolean done=false;


    public boolean isDone() {
        return done;
    }

    private Date duedate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getdone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getDuedate() {
       // String date1= duedate.toString();
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }



    public ToDoData(){

    }

    public ToDoData(String description,boolean isdone, Date date){
        this.description=description;
        this.done=isdone;
        this.duedate=date;
    }
}
