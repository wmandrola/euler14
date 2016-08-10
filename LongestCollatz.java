/**
 * Created by RedzoneX on 8/10/16.
 */
public class LongestCollatz {
    public static int findCollatz() {
        int maxTerms = 0;
        int maxNum = 0;
        int[] array = new int[1000000];
        for (int i = 1; i < 1000000; i++) {
            long num = i;
            int terms = 1;
            while (num != 1) {
                if (num % 2 != 0)
                    num = 3 * num + 1;
                else
                    num /= 2;
                terms++;
                if (num < i) {
                    terms += array[(int)num] - 1;
                    break;
                }
            }
            array[i] = terms;
            if (terms > maxTerms) {
                maxTerms = terms;
                maxNum = i;
            }
        }
        return maxNum;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int number = findCollatz();
        long end = System.currentTimeMillis();
        System.out.println(number);
        System.out.println("That took " + (end - start) + " milliseconds.");
    }
}
