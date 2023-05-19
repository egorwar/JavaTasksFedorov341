public class StudentC extends Student{

    public StudentC(String name, int calc, int vis, int abstr){
        super(name, calc, vis, abstr);
    }

    @Override
    public void about() {
        System.out.println("STUDENT" +
                "\nname: " + this.name +
                "\ngroup: C" +
                "\n\nSKILLS" +
                "\ncalc: " + this.calc +
                "\nvis: " + this.vis +
                "\nabstr: " + this.abstr +
                "\n---");
    }
}
