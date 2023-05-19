public class Scheduler {
    private int stretch;   // разминка, секунд
    private int pushups;   // кол-во отжиманий
    private int squats;    // кол-во приседаний
    private int abs;       // кол-во подъёмов корпуса на пресс
    private int plank;     // время планки

    private float weight;  // вес снаряда в кг
    private int lifts;

    public Scheduler(int stretch){
        if (stretch <= 0) throw new IllegalArgumentException("cannot exercise without a stretch");
        this.stretch = stretch;
    }

    public int getStretch(){
        return this.stretch;
    }

    public Scheduler addPushups(int pushups){
        if (pushups <= 0) throw new IllegalArgumentException("cannot add 0 pushups");
        this.pushups = pushups;
        return this;
    }

    public int getPushups(){
        return this.pushups;
    }
    public Scheduler addSquats(int squats){
        if (squats <= 0) throw new IllegalArgumentException("cannot add 0 squats");
        this.squats = squats;
        return this;
    }

    public int getSquats(){
        return this.squats;
    }

    public Scheduler addAbs(int abs){
        if (abs <= 0) throw new IllegalArgumentException("cannot add 0 abs");
        this.abs = abs;
        return this;
    }

    public int getAbs(){
        return this.abs;
    }

    public Scheduler addPlank(int plank){
        if (plank <= 0) throw new IllegalArgumentException("cannot have plank for 0 seconds");
        this.plank = plank;
        return this;
    }

    public int getPlank(){
        return this.plank;
    }

    public Scheduler addWeightlift(float weight, int lifts){
        if (weight <= 0) throw new IllegalArgumentException("cannot lift 0 kg");
        if (lifts <= 0) throw new IllegalArgumentException("cannot lift 0 times");
        this.weight = weight;
        this.lifts = lifts;
        return this;
    }

    public float getWeight() {
        return this.weight;
    }

    public int getLifts(){
        return this.lifts;
    }

    public Exercise create(){
        return new Exercise(this);
    }

}
