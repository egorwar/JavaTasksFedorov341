public class StudentB extends Student{

    public StudentB(String name, int calc, int vis, int abstr){
        super(name, calc, vis, abstr);
    }

    @Override
    public void about() {
        System.out.println("STUDENT" +
                "\nname: " + this.name +
                "\ngroup: B" +
                "\n\nSKILLS" +
                "\ncalc: " + this.calc +
                "\nvis: " + this.vis +
                "\nabstr: " + this.abstr +
                "\n---");
    }
}
