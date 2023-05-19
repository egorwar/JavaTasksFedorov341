public class Novice {
    private String plan;

    public Novice(){
        plan = new Scheduler(600)
                .addPlank(30)
                .addSquats(10)
                .addAbs(5)
                .create()
                .getPlan();
    }

    public String getPlan(){
        return this.plan;
    }
}
