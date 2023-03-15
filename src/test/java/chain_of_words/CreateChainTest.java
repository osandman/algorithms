package chain_of_words;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import various.chain_of_words.CreateChain;
import various.chain_of_words.FromJR;

import static org.junit.jupiter.api.Assertions.*;

class CreateChainTest {

    static String testWords1 = "Дербент Якутск Арзамас Рог Киев Кувшиново Капустин-Яр " +
                               "Стокгольм Флоренция Глен-Хоп Тобольск Нью-Йорк Анапа Муром " +
                               "Осташков Прага Кострома Вена Амстердам Мельбурн Волгоград Минск Арсиф";
    static String testWords2 = "test sum num kill sims mate even dad android eye " +
                               "kick elephant drink alpha eels bee mob linea tea apple";
    static String testWords3 = "alpha elephant kick linea android eels kill sum eye spud " +
                               "drink even bee dad num tea test sims apple mob mate";
    CreateChain createChain = new CreateChain();

    @Test
    @DisplayName("Test1 that created chain of words and result words count equals init array length")
    void getLineTest1() {
        String allWords = testWords1 + " " + testWords1;
        int count = allWords.split("\\s+").length;
        String actualChain = createChain.getChain((allWords).split("\\s+")).toString();
        int actualCount = actualChain.split("\\s+").length;
        System.out.printf("%d %-15s: %s\n", count, "исходные слова", allWords);
        System.out.printf("%d %-15s: %s\n", actualCount, "цепочка слов", actualChain);
        assertEquals(count, actualCount);
    }

    @Test
    @DisplayName("Test2 that created chain of words and result words count equals init array length")
    void getLineTest2() {
        String allWords = testWords2;
        int count = allWords.split("\\s+").length;
        String actualChain = createChain.getChain((allWords).split("\\s+")).toString();
        int actualCount = actualChain.split("\\s+").length;
        System.out.printf("%d %-15s: %s\n", count, "исходные слова", allWords);
        System.out.printf("%d %-15s: %s\n", actualCount, "цепочка слов", actualChain);
        assertEquals(count, actualCount);
    }

    @Test
    @DisplayName("Test3 that created chain of words and result words count equals init array length")
    void getLineTest3() {
        String allWords = testWords2 + " " + testWords3 + " " + testWords2 + " " + testWords2;
        int count = allWords.split("\\s+").length;
        String actualChain = createChain.getChain((allWords).split("\\s+")).toString();
        int actualCount = actualChain.split("\\s+").length;
        System.out.printf("%d %-15s: %s\n", count, "исходные слова", allWords);
        System.out.printf("%d %-15s: %s\n", actualCount, "цепочка слов", actualChain);
        assertEquals(count, actualCount);
    }

    @Test
    @DisplayName("Test4 from JR")
    void getLineTest4() {
        String allWords = testWords3;
        int count = allWords.split("\\s+").length;
        String actualChain = FromJR.getLine((allWords).split("\\s+")).toString();
        int actualCount = actualChain.split("\\s+").length;
        System.out.printf("%d %-15s: %s\n", count, "исходные слова", allWords);
        System.out.printf("%d %-15s: %s\n", actualCount, "цепочка слов", actualChain);
        assertEquals(count, actualCount);
    }
}