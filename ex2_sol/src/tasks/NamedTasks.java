package tasks;

public class NamedTasks extends Tasks {
    private String[] tasks;

    public NamedTasks(String[] names) {
        super(names.length); //creates array[names.length]
        this.tasks = new String[names.length];
        this.tasks = names;
    }

    public boolean dependsOn(String task1, String task2) {
        int tsk1 = -1, tsk2 = -1;
        if (!task1.equals(task2)) {
            for (int i = 0; i < this.tasks.length; i++) {
                if (this.tasks[i].equals(task1)) tsk1 = i;
                if (this.tasks[i].equals(task2)) tsk2 = i;
            }
        }
        return (tsk1 != -1 && tsk2 != -1) && super.dependsOn(tsk1, tsk2);
    }

    public String[] nameOrder() {
        int[] in = super.order();
        String[] out = new String[this.tasks.length];

        for (int i = 0; i < this.tasks.length; i++)
            out[i] = this.tasks[in[i]];

        return out;
    }
}