public class Task_Equation extends Task{

    public Task_Equation(int num, String given, int calc, int vis, int abstr){
        super(num, given, calc, vis, abstr);
    }

    @Override
    public void specifyGiven(String given) {
        this.taskData = "Given the equation " + given;
    }

    @Override
    public void specifyGoal() {
        this.taskData += "\n\nFind: x";
    }

    @Override
    public void specifySolveMethod() {
        this.taskData += "\n\nSolve by isolating x on the left side of equation and calculating an expression on the left";
    }

    @Override
    public void specifyComplexity(int calc, int vis, int abstr) {
        this.calc = calc;
        this.vis = vis;
        this.abstr = abstr;
    }
}
