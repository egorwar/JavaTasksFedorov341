public class StudentA extends Student{

    public StudentA(String name, int calc, int vis, int abstr){
        super(name, calc, vis, abstr);
    }

    @Override
    public void about() {
        System.out.println("STUDENT" +
                            "\nname: " + this.name +
                            "\ngroup: A" +
                            "\n\nSKILLS" +
                            "\ncalc: " + this.calc +
                            "\nvis: " + this.vis +
                            "\nabstr: " + this.abstr +
                            "\n---");
    }
}
