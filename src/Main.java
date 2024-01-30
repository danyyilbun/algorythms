import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class BiggestWord
{
    public int counter;
    public StringBuilder answer;
}
public class Main {
    public static void main(String[] args) {
        List<List<Long>> longs = Arrays.asList(Arrays.asList(22222222L,11111111L),Arrays.asList(2L,1L),Arrays.asList(44444444L,22222222L)
                ,Arrays.asList(33333333L,33333333L));
        System.out.println("aaee".equals(stringCombination("sssuyyyddddasdfdfigsdfgsdfgaaeesfasdf" , 4)));
        System.out.println(comparedLongs(longs));
    }

    public static String stringCombination(String combi, int k)
    {
        BiggestWord biggestWord = new BiggestWord();
        BiggestWord temporary = new BiggestWord();
        biggestWord.counter = 0;
        biggestWord.answer = new StringBuilder();
        Character [] chat = new Character[]{'a', 'e', 'i', 'o', 'u', 'y'};
        ArrayList<Character> letters = new ArrayList<>(Arrays.asList(chat));
        StringBuilder st = new StringBuilder(combi);
        for (int i = 0; i < st.length()-k ; i++) {
            temporary.answer = new StringBuilder();;
            temporary.counter = 0;
            for (int j = 0; j < k; j++) {
                //
                if(letters.contains(st.charAt(j+i)))
                {

                    temporary.answer.append(st.charAt(j + i));
                    temporary.counter++;

                }
            }
            if(temporary.counter > biggestWord.counter)
            {
                biggestWord.counter = temporary.counter;
                biggestWord.answer = temporary.answer;
            }
        }
        return biggestWord.answer.toString();
    }
    public static int comparedLongs(List<List<Long>> listLongs)
    {
        HashSet<Double> hset = new HashSet<Double>();
        for(List<Long> proportionList : listLongs)
        {
            hset.add(division(proportionList.get(0),proportionList.get(1)));
        }
        return hset.size();
    }
    public static double division(Long denominator, Long numerator)
    {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        int sign = (numerator < 0) ^ (denominator < 0) ? -1 : 1;
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);

        StringBuilder result = new StringBuilder();

        long quotient = num / denom;
        result.append(quotient);

        long remainder = num % denom;
        if (remainder > 0) {
            result.append('.');
            int decimalPlaces = 0;
            StringBuilder decimalPart = new StringBuilder();

            while (remainder > 0 && decimalPlaces < 16) {
                remainder *= 10;
                long digit = remainder / denom;
                decimalPart.append(digit);
                remainder %= denom;
                decimalPlaces++;
            }



            result.append(decimalPart);
            if (remainder > 0) {
                result.insert(result.indexOf(".") + 1, '(');
                result.append(')');
            }
        }

        // Apply the sign
        if (sign == -1) {
            result.insert(0, '-');
        }

        return Double.parseDouble(result.toString());
    }

}
