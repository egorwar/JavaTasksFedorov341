public abstract class Student {
    protected int calc;
    protected int vis;
    protected int abstr;

    public int getCalc(){
        return calc;
    }

    public int getVis(){
        return vis;
    }

    public int getAbstr(){
        return abstr;
    }

    protected String name;

    protected boolean isBusy;

    protected int task;

    public Student(String name, int calc, int vis, int abstr){
        this.name = name;
        this.calc = calc;
        this.vis = vis;
        this.abstr = abstr;
        this.isBusy = false;
    }

    public abstract void about();

    public boolean isBusy(){
        return this.isBusy;
    }

    public void assign(int task){
        this.isBusy = true;
        this.task = task;
        System.out.println("\n[!!!] Student " + this.name + " takes the task №" + this.task + "\n\n");
    }

    public int getTask(){
        return this.task;
    }


}
