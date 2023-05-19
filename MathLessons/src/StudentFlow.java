import java.util.concurrent.ThreadLocalRandom;

public class StudentFlow {
    public Student get(String name, int calc, int vis, int abstr){
        int general = calc + vis + abstr;

        if (10 <= general & general <= 14)
            return new StudentC(name, calc, vis, abstr);

        else if (general <= 19)
            if (ThreadLocalRandom.current().nextInt(0, 1 + 1) == 0)
                return new StudentC(name, calc, vis, abstr);
            else
                return new StudentB(name, calc, vis, abstr);

        else if (general == 20)
            if (ThreadLocalRandom.current().nextInt(0, 2 + 1) == 0)
                return new StudentC(name, calc, vis, abstr);
            else if (ThreadLocalRandom.current().nextInt(0, 2 + 1) == 1)
                return new StudentB(name, calc, vis, abstr);
            else
                return new StudentA(name, calc, vis, abstr);

        else if (general <= 25)
            if (ThreadLocalRandom.current().nextInt(0, 1 + 1) == 0)
                return new StudentB(name, calc, vis, abstr);
            else
                return new StudentA(name, calc, vis, abstr);

        else if (general <= 30)
            return new StudentA(name, calc, vis, abstr);

        else throw new IllegalArgumentException("Each skill should rank from 1 to 10");
    }
}
