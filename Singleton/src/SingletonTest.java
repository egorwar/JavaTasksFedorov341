import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SingletonTest {

    @Test
    @DisplayName("Try to get exam before it being set")
    void getBeforeInit(){
        assertThrows(InstantiationException.class, () -> Exam.getCurrent());
    }


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @Test
    @DisplayName("Try incorrect password")
    void incorrectPass() {
        System.setOut(new PrintStream(outContent));
        Exam.setCurrent("12345", "Java");
        assertEquals(outContent.toString(), "Wrong password! 4 attempts remain\n");
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Change exam with correct password")
    void changeExam() throws InstantiationException {
        Exam.setCurrent("qwerty", "Java");
        assertEquals(Exam.getCurrent().getCurrentInfo(), "Java");
    }

    @Ignore
    void doReach(){
        Exam.setCurrent("12345", "C#");
        Exam.setCurrent("1234", "C++");
        Exam.setCurrent("123", "Assembler");
        Exam.setCurrent("12", "Kotlin");
        Exam.setCurrent("1", "C");
        Exam.setCurrent("qwerty", "C#");
    }

    @Test
    @DisplayName("Reach too much attempts")
    void tma(){
        assertThrows(SecurityException.class, () -> doReach());
    }
}
