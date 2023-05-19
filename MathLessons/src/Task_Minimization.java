public class Task_Minimization extends Task{

    public Task_Minimization(int num, String given, int calc, int vis, int abstr){
        super(num, given, calc, vis, abstr);
    }

    @Override
    public void specifyGiven(String given) {
        this.taskData = "Given the function " + given;
    }

    @Override
    public void specifyGoal() {
        this.taskData += "\n\nFind x that minimizes the function value.";
    }

    @Override
    public void specifySolveMethod() {
        this.taskData += "\n\nSolve by applying gradient descent, starting from 0, with parameter = 0.05";
    }

    @Override
    public void specifyComplexity(int calc, int vis, int abstr) {
        this.calc = calc;
        this.vis = vis;
        this.abstr = abstr;
    }
}
