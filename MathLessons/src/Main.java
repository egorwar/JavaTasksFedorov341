import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Create different tasks
        Task[] tasks = {
                new Task_Equation(10, "2x+5=0", 2, 1, 1),
                new Task_Equation(13, "3x^2+19x-7=0", 3, 1, 3),
                new Task_Equation(19, "12x^4-5sin(x)^2+7x=0", 6, 1, 2),

                new Task_Minimization(157, "f(x)=x^2-5x+2", 2, 2, 4),
                new Task_Minimization(163, "f(x)=3x^7-2x^5+sin(x)-ln(3x)+23", 4, 2, 7),

                new Task_AreaCalculation(34, "(1, 3), (2, 5), (4, 8), (6, 1)", 4, 5, 1),
                new Task_AreaCalculation(30, "(1, 1), (-1, -1), (1, -1), (-1, 1)", 2, 4, 1),
                new Task_AreaCalculation(45, "(1, 3), (2, 5), (4, 8), (6, 1), (-2, 7), (3, 0), (-4, -4)", 4, 7, 2),
        };

        //2. Create students, enroll them into groups
        StudentFlow flow = new StudentFlow();
        ArrayList<Student> groupA = new ArrayList<>();
        ArrayList<Student> groupB = new ArrayList<>();
        ArrayList<Student> groupC = new ArrayList<>();


        for (int i = 0; i < 12; i++){
            Student student = flow.get(Integer.toString(i),
                    ThreadLocalRandom.current().nextInt(1, 10 + 1),
                    ThreadLocalRandom.current().nextInt(1, 10 + 1),
                    ThreadLocalRandom.current().nextInt(1, 10 + 1));

            switch (student.getClass().getSimpleName()) {
                case "StudentA" -> {
                    groupA.add(student);
                    student.about();
                }
                case "StudentB" -> {
                    groupB.add(student);
                    student.about();
                }
                case "StudentC" -> {
                    groupC.add(student);
                    student.about();
                }
            }
        }

        //3. Create practice rooms:
        PracticeA a = new PracticeA(groupA);
        PracticeB b = new PracticeB(groupB);
        PracticeC c = new PracticeC(groupC);

        c.setNext(b);
        b.setNext(a);

        //4. Start practice:
        System.out.println("\nPractice has started!\n");
        for (Task task : tasks){
            System.out.print("\nSTATUS");
            System.out.print("\nGROUP C: ");
            info(groupC);
            System.out.print("\nGROUP B: ");
            info(groupB);
            System.out.print("\nGROUP A: ");
            info(groupA);
            System.out.println();
            System.out.println("Task №" + task.getNum());
//            System.out.println(task.getTaskData());
            c.handle(task);
        }



    }

    public static void info(ArrayList<Student> group){
        for (Student s : group)
            if (! s.isBusy())
                System.out.print("(" + s.getCalc() + ", " + s.getVis() + ", " + s.getAbstr() + ") ");
    }
}