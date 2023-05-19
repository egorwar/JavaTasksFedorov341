public abstract class Task {
    protected int num;
    protected int calc;
    protected int vis;
    protected int abstr;
    protected String taskData;

    public int getCalc(){
        return calc;
    }

    public int getVis(){
        return vis;
    }

    public int getAbstr(){
        return abstr;
    }

    public int getNum() {
        return num;
    }

    public String getTaskData(){
        return taskData;
    }

    public Task(int num, String given, int calc, int vis, int abstr){
        this.num = num;
        this.Build(given, calc, vis, abstr);
    }

    // Template method
    public void Build(String given, int calc, int vis, int abstr){
        this.specifyGiven(given);
        this.specifyGoal();
        this.specifySolveMethod();
        this.specifyComplexity(calc, vis, abstr);
    }

    public abstract void specifyGiven(String given);
    public abstract void specifyGoal();
    public abstract void specifySolveMethod();
    public abstract void specifyComplexity(int calc, int vis, int abstr);
}
