import java.util.Arrays;
import java.util.Random;

public class numCheck {
    public static void main(String[] args) {
        짝수홀수();

        숫자증가();
    }

    private static void 숫자증가() {
        int x = 3;
        int n = 5;
        long[] answer2 = {};
        answer2 = new long[n];
        answer2[0] = x;

        for (int i = 1; i < n; i++) {
            answer2[i] = answer2[i-1] + x;
        }

        System.out.println("answer2 = " + Arrays.toString(answer2));
    }

    private static void 짝수홀수() {
        Random random = new Random();
        int num = random.nextInt();
        String answer = "";

        if (num % 2 == 0) {
            answer = "Even";
        } else {
            answer = "Odd";
        }

        System.out.println("num / answer = " + num + " / " + answer);
    }
}
