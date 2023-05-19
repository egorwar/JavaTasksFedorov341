public class Exercise {
    private int stretch; // разминка,секунд
    private int pushups;   // кол-во отжиманий
    private int squats;    // кол-во приседаний
    private int abs;       // кол-во подъёмов корпуса на пресс
    private int plank;     // время планки

    private float weight;  // вес снаряда в кг
    private int lifts;     // кол-во подъёмов веса

    public String getPlan(){
        String plan = "План тренировки:\n";
                            plan += "\nРазминка: " + stretch + " секунд";

        if (pushups > 0)    plan += "\nОтжиманий: " + pushups;
        if (squats > 0)     plan += "\nПриседаний: " + squats;
        if (abs > 0)        plan += "\nПресс: " + abs;
        if (plank > 0)      plan += "\nПланка: " + plank + " секунд";

        if (weight > 0 && lifts > 0){
            plan += "\n\nСнаряд: " + weight + " кг";
            plan += "\nПоднимать: " + lifts + " раз";
        }

        return plan + '\n';
    }

    public Exercise(Scheduler scheduler){
        this.stretch = scheduler.getStretch();
        this.pushups = scheduler.getPushups();
        this.squats = scheduler.getSquats();
        this.abs = scheduler.getAbs();
        this.plank = scheduler.getPlank();
        this.weight = scheduler.getWeight();
        this.lifts = scheduler.getLifts();
    }
}
