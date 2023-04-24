import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* List<Integer>availableDivider = findAvailableDividen(12);**/
        // List<Integer>availableDivider = findSimpleNumbers(6);
        List<Integer>availableDivider = findAvailableDividen(11);
//        for (Integer integer : availableDivider) {
//            System.out.println(integer);
        }

        public static List<Integer> findAvailableDividen (int number){

            List<Integer> result = new ArrayList<>();
            int counter = 0;
            for (int i = 1; i <= number; i++) {
                //for (int i = 1; i <= number; i++) {
                counter++;
                if (number % i == 0) {
                    result.add(i);
                }
            }
            System.out.println("Counter: " + counter);
            return result;
    }
    public static List<Integer> findSimpleNumbers(int max){
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i ++){
            boolean simple = true;
            for (int j = 2; j < i; j ++){
                counter++;
                if (i % j == 0){
                    simple = false;
                    // break;
                }
            }
            if (simple){
                result.add(i);
            }
        }
        System.out.println("Counter : " + counter);
        return result;
    }
}