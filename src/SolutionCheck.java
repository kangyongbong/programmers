import java.util.*;

class SolutionCheck {

    public static void main(String[] args) {
        int[] a = solution(new String[] {"muzi", "frodo", "apeach", "neo"},
                new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2);

        System.out.println("===============================");

        int[] b = solution(new String[] {"con", "ryan"},
                new String[] {"ryan con", "ryan con", "ryan con", "ryan con"},
                3);

        for (int i : a) {
            System.out.println("i = " + i);
        }
        for (int i : b) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        answer = new int[id_list.length];
        HashSet<String> report_set = new HashSet<>(Arrays.asList(report));
        HashMap<String, List<String>> linkedHashMap = new HashMap<>();
        HashMap<String, Integer> targetLinkedHashMap = new HashMap<>();

        for (String id : id_list) {
            int count = 0;
            linkedHashMap.put(id, new ArrayList<>());
            targetLinkedHashMap.put(id, count);

            for (String report_id : report_set) {
                String[] id_split = report_id.split(" ");
                if (id.equals(id_split[0])){
                    linkedHashMap.get(id).add(id_split[1]);
                }
                if (id.equals(id_split[1])){
                    count++;
                    targetLinkedHashMap.put(id, count);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            for (String name : linkedHashMap.get(id_list[i]) ) {
                if (k <= targetLinkedHashMap.get(name)) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

//    public int[] solution(String[] id_list, String[] report, int k) {
//        int[] answer = {};
//        answer = new int[id_list.length];
//        LinkedList<String> list_id = new LinkedList<>(Arrays.asList(id_list));
//        Set<String> report_list = Arrays.stream(report).collect(Collectors.toSet());
//        List<String> target_list = report_list.stream().map(r -> r.split(" ")[1]).collect(Collectors.toList());
//
//        for (int i = 0; i < list_id.size(); i++) {
//            int count = 0;
//            for (String report_id : report_list) {
//                String[] id_split = report_id.split(" ");
//                if (list_id.get(i).equals(id_split[0]) && k <= Collections.frequency(target_list, id_split[1])) {
//                    count++;
//                }
//            }
//
//            answer[i] = count;
//        }
//
//        return answer;
//    }
}