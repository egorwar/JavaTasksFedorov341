public class Professional {
    private String plan;

    public Professional(){
        plan = new Scheduler(1200)
                .addPlank(600)
                .addSquats(40)
                .addAbs(30)
                .addPushups(30)
                .addWeightlift(1.2f, 20)
                .create()
                .getPlan();
    }

    public String getPlan(){
        return this.plan;
    }
}
