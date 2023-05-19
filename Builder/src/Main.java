public class Main {
    public static void main(String[] args) {
        try{
            Exercise plan = new Scheduler(60)
                    .addAbs(13)
                    .addPushups(15)
                    .addWeightlift(0.6f, 20)
                    .create();
            System.out.println(plan.getPlan());
        }
        catch (IllegalArgumentException e){
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("Для новичка:\n" + new Novice().getPlan());
        System.out.println("Для опытного:\n" + new Experienced().getPlan());
        System.out.println("Для профессионала:\n" + new Professional().getPlan());

    }
}