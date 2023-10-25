package todolistbymaxheap;

public class Task {

    private String desc;
    private int priority;

    public Task(String d, int priority) {
        this.desc = d;
        this.priority = priority;
    }

    public int getPri() {
        return this.priority;
    }

    @Override
    public String toString() {
        return "Task{" + "desc=" + desc + ", priority=" + priority + '}';
    }
    

}
