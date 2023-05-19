public class Experienced {
    private String plan;

    public Experienced(){
        plan = new Scheduler(600)
                .addPlank(120)
                .addSquats(20)
                .addAbs(15)
                .addPushups(15)
                .addWeightlift(0.6f, 15)
                .create()
                .getPlan();
    }

    public String getPlan(){
        return this.plan;
    }
}
