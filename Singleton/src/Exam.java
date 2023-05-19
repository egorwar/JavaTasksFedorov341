public class Exam {
    private static Exam current;
    private static String currentInfo;
    private static int attempts = 5;
    private static String pass = "qwerty";
    private Exam () {};

    public static Exam getCurrent() throws InstantiationException {
        if (current == null) {
            throw new InstantiationException("No current exam has been set yet.");
        }
        return current;
    }

    public static void setCurrent(String pass, String current) {
        if (attempts == 0)
            throw new SecurityException("Too much attempts");

        if (!Exam.pass.equals(pass)){
            System.out.println("Wrong password! " + --attempts + " attempts remain");
            return;
        }

        Exam.current = new Exam();
        Exam.current.setCurrentInfo(current);

        Exam.attempts = 5;
    }

    private void setCurrentInfo(String info){
        this.currentInfo = info;
    }

    public String getCurrentInfo(){
        return Exam.currentInfo;
    }
}