import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoadCheck {
    public static void main(String[] args) {
//        String dirs = "LULLLLLLU";
        String dirs = "ULURRDLLU";
        int result = skillCheck(dirs);

        System.out.println("result = " + result);
    }
    public static int skillCheck(String dirs) {
        int answer = 0;
        String[] split = dirs.split("");
        ArrayList<String> road = new ArrayList<>();
        road.add("0,0 ~ 0,0"); // 초기화

        for (int i = 0; i < split.length; i++) {
            getMoveCheck(split[i], road);
        }

        road.remove(0);
        System.out.println("road = " + road);
        System.out.println("road = " + road.size());
        List<String> collect = road.stream().distinct().collect(Collectors.toList());

        answer = collect.size(); // 초기화한 데이터 제거;
        return answer;
    }

    private static void getMoveCheck(String s, ArrayList<String> road) {
        String[] split = road.get(road.size()-1).split(" ~ ");
        String[] flat = split[1].split(",");

        switch (s) {
            case "U":
                if ((Integer.parseInt(flat[0]) + 1) <= 5) {
                    road.add(split[1] + " ~ " + (Integer.parseInt(flat[0]) + 1) + "," + flat[1]);
                }
                break;
            case "D":
                if ((Integer.parseInt(flat[0]) - 1) >= -5) {
                    road.add(split[1] + " ~ " + (Integer.parseInt(flat[0]) - 1) + "," + flat[1]);
                }
                break;
            case "R":
                if ((Integer.parseInt(flat[1]) - 1) <= 5) {
                    road.add(split[1] + " ~ " + flat[0] + "," + (Integer.parseInt(flat[1]) + 1));
                }
                break;
            case "L":
                if ((Integer.parseInt(flat[1]) - 1) >= -5) {
                    road.add(split[1] + " ~ " + flat[0] + "," + (Integer.parseInt(flat[1]) - 1));
                }
                break;
        }
    }
}