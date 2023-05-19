
public class Main {
    public static void main(String[] args) {
        try{
            Exam.getCurrent();

            Exam.setCurrent("12345", "Java");
            Exam.setCurrent("password", "Java");

            Exam.setCurrent("qwerty", "Java");
            Exam exam = Exam.getCurrent();
            System.out.print("Current exam is: " + exam.getCurrentInfo());

            Exam.setCurrent("12345", "C#");
            Exam.setCurrent("12345", "C#");
            Exam.setCurrent("12345", "C#");
            Exam.setCurrent("12345", "C#");
            Exam.setCurrent("12345", "C#");
            Exam.setCurrent("qwerty", "C#");
            exam = Exam.getCurrent();
            System.out.print("Current exam is: " + exam.getCurrentInfo());

        }
        catch (InstantiationException e){
            System.out.println(e.getMessage());
        }
        catch (SecurityException e){
            System.out.println(e.getMessage());
        }


    }
}