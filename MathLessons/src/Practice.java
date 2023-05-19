import java.util.ArrayList;

public abstract class Practice {
    protected ArrayList<Student> students;
    protected Practice next = null;

    public Practice(ArrayList<Student> students){
        this.students = students;
    }

    public void setNext(Practice practice){
        this.next = practice;
    }

    public void handle(Task task) {
        for(Student student : students)
            if (!student.isBusy()){
                System.out.print("(" + student.getCalc() + ", " + student.getVis() + ", " + student.getAbstr() +
                        ") tries to solve ("
                        + task.getCalc() + ", " + task.getVis() + ", " + task.getAbstr() + ") ");

                if (student.getCalc() >= task.getCalc()
                        & student.getVis() >= task.getVis()
                        & student.getAbstr() >= task.getAbstr())
                {
                    System.out.println("SUCCESS");
                    student.assign(task.getNum());
                    return;
                }
                else System.out.println("FAILURE");
            }

        if (!(next == null)) {
            System.out.println("\nNone of the students in " + this.getClass().getSimpleName() +
                    " can solve the task №" + task.getNum() +
                    "\nSwitching to " + next.getClass().getSimpleName());
            next.handle(task);
        }
        else
            System.out.println("\nNone of the students can solve the task\n");



    }
}
