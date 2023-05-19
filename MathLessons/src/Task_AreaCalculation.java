public class Task_AreaCalculation extends Task{

    public Task_AreaCalculation(int num, String given, int calc, int vis, int abstr){
        super(num, given, calc, vis, abstr);
    }

    @Override
    public void specifyGiven(String given) {
        this.taskData = "Given the figure with vertices " + given;
    }

    @Override
    public void specifyGoal() {
        this.taskData += "\n\nFind the area of the figure.";
    }

    @Override
    public void specifySolveMethod() {
        this.taskData += "\n\nSolve by dividing the figure into the simpler ones, and then dding up their areas";
    }

    @Override
    public void specifyComplexity(int calc, int vis, int abstr) {
        this.calc = calc;
        this.vis = vis;
        this.abstr = abstr;
    }
}
