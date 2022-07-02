import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class sixshopCoTe {


    public static void main(String[] args) {

        int[][] v = new int[][]{{1,4}, {3,4}, {3,10}};;
        int[] solution = solution1(v);
        System.out.println("solution = " + Arrays.toString(solution));

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
//        solution2(a);

        int[] ints = solution3(a);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public static int[] solution1(int[][] v) {
        int[] answer = {};


        HashMap<Integer, Integer> xDistinctCount = new HashMap<>();
        HashMap<Integer, Integer> yDistinctCount = new HashMap<>();
        for (int[] ints : v) {
            if (xDistinctCount.containsKey(ints[0])){
                xDistinctCount.put(ints[0], xDistinctCount.get(ints[0])+1);
            } else {
                xDistinctCount.put(ints[0], 1);
            }
            if (yDistinctCount.containsKey(ints[1])){
                yDistinctCount.put(ints[1], yDistinctCount.get(ints[1])+1);
            } else {
                yDistinctCount.put(ints[1], 1);
            }

        }
        System.out.println("xDistinctCount = " + xDistinctCount.get(1));
        System.out.println("yDistinctCount = " + yDistinctCount.get(10));

        int xResult = 0;
        int yResult = 0;
        for (Integer integer : yDistinctCount.keySet()) {
            if (yDistinctCount.get(integer) == 1) {
                yResult = integer;
            }
        }
        for (Integer integer : xDistinctCount.keySet()) {
            if (xDistinctCount.get(integer) == 1) {
                xResult = integer;
            }
        }

        answer = new int[]{xResult, yResult};
        return answer;
    }

    public static void solution2(int v) {
        for (int i = 1; i <= v; i++) {
            StringBuilder start = new StringBuilder();
            start.append("*".repeat(Math.max(0, i)));
            System.out.println("start = " + start.toString());
        }
    }

    public static int[] solution3(int n) {
        int[] answer = new int[n];
        for(int i=0; i<n; i++){
            answer[i] = i+1;
        }
        return answer;
    }

}