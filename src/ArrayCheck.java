import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayCheck {

    public static void main(String[] args) {
        중복제거();
        중복제거ByStream();
    }

    private static void 중복제거ByStream() {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};

        ArrayList<Integer> result = new ArrayList<>();
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        List<Integer> collect = list.stream().filter(l -> l > 2).collect(Collectors.toList());
        System.out.println("collect = " + collect.toString());
    }

    private static void 중복제거() {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};

        ArrayList<Integer> result = new ArrayList<>();

        int temp = -1;
        for (int i : arr) {
            if (temp != i) {
                result.add(i);
                temp = i;
            }
        }

//        int[] answer = {};
        int[] answer = {};

        answer = result.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("result.toArray() = " + Arrays.toString(result.toArray()));
    }
}
