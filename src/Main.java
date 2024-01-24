import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class BiggestWord
{
    public int counter;
    public String answer;
}
public class Main {
    public static void main(String[] args) {
        System.out.println("aaee".equals(stringCombination("sssuyyyddddasdfdfigsdfgsdfgaaeesfasdf" , 4)));

    }

    public static String stringCombination(String combi, int k)
    {
        BiggestWord biggestWord = new BiggestWord();
        BiggestWord temporary = new BiggestWord();
        biggestWord.counter = 0;
        biggestWord.answer = "";
        Character [] chat = new Character[]{'a', 'e', 'i', 'o', 'u', 'y'};
        ArrayList<Character> letters = new ArrayList<>(Arrays.asList(chat));
        StringBuilder st = new StringBuilder(combi);
        for (int i = 0; i < st.length()-k ; i++) {
            temporary.answer = "";
            temporary.counter = 0;
            for (int j = 0; j < k; j++) {
                //
                if(letters.contains(st.charAt(j+i)))
                {

                    temporary.answer+=st.charAt(j+i);
                    temporary.counter++;

                }
            }
            if(temporary.counter > biggestWord.counter)
            {
                biggestWord.counter = temporary.counter;
                biggestWord.answer = temporary.answer;
            }
        }
        System.out.println(biggestWord.answer + biggestWord.counter);
        return biggestWord.answer;
    }

}
