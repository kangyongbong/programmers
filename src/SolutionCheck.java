import java.util.*;
import java.util.stream.Collectors;

class SolutionCheck {

    public static void main(String[] args) {
        int[] a = solution(new String[] {"muzi", "frodo", "apeach", "neo"},
                new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2);

        for (int i : a) {
            System.out.println("i = " + i);
        }

        System.out.println("===============================");

        int[] b = solution(new String[] {"con", "ryan"},
                new String[] {"ryan con", "ryan con", "ryan con", "ryan con"},
                3);

        for (int i : b) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> report_set = new HashSet<>(Arrays.asList(report));
        HashMap<String, List<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> send = new HashMap<>();

        for (String id : id_list) {
            reportMap.put(id, new ArrayList<>());
            send.put(id, 0);
        }

        // 신고한 id , 신고된 id map
        for (String s : report_set) {
            String[] reportArr = s.split(" ");
            reportMap.get(reportArr[0]).add(reportArr[1]); // 신고한 ID , 신고된 ID
            if (send.containsKey(reportArr[1])) {
                send.put(reportArr[1], send.get(reportArr[1]) + 1);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            List<String> reportList = reportMap.get(id_list[i]);
            for (String ids : reportList) {
                if (send.get(ids) >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

//    public static int[] solution(String[] id_list, String[] report, int k) {
//        int[] answer = new int[id_list.length];
//        System.out.println("id_list = " + String.join(",", id_list));
//        Arrays.stream(report).sorted(Comparator.reverseOrder()).forEach(System.out::println);
//
//        HashSet<String> report_set = new HashSet<>(Arrays.asList(report));
//        HashMap<String, List<String>> linkedHashMap = new HashMap<>();
//        HashMap<String, Integer> targetLinkedHashMap = new HashMap<>();
//
//        for (String id : id_list) {
//            int count = 0;
//            linkedHashMap.put(id, new ArrayList<>());
//            targetLinkedHashMap.put(id, count);
//
//            for (String report_id : report_set) {
//                String[] id_split = report_id.split(" ");
//                if (id.equals(id_split[0])){
//                    linkedHashMap.get(id).add(id_split[1]);
//                }
//                if (id.equals(id_split[1])){
//                    count++;
//                    targetLinkedHashMap.put(id, count);
//                }
//            }
//        }
//
//        for (int i = 0; i < id_list.length; i++) {
//            for (String name : linkedHashMap.get(id_list[i]) ) {
//                if (k <= targetLinkedHashMap.get(name)) {
//                    answer[i]++;
//                }
//            }
//        }
//
//        return answer;
//    }

//    public static int[] solution(String[] id_list, String[] report, int k) {
//        int[] answer = {};
//        answer = new int[id_list.length];
//        System.out.println("id_list = " + String.join(",", id_list));
//        Arrays.stream(report).sorted(Comparator.reverseOrder()).forEach(System.out::println);
//        /*
//         * key 는 유저ID
//         * value 는 신고한 유저ID의 set 을 가진 map
//         * 동일한 유저ID에 대한 신고횟수는 1회로 처리하기 때문에 중복 허용을 하지 않는 set 을 value 로 사용
//         * */
//        Map<String, HashSet<String>> reportedMap = new HashMap<>(); // [신고된ID, [신고한ID]]
//        Map<String, Integer> answerMap = new HashMap<>(); // [신고된Id, 메일 수]
//
//
//        /* 1. Map 초기화 */
//        for (int i = 0; i < id_list.length; i++) {
//            HashSet<String> reportingId = new HashSet<>(); // 신고한ID
//            reportedMap.put(id_list[i], reportingId); // 유저ID, 신고한ID 초기 세팅
//            answerMap.put(id_list[i], 0);  // 메일 수는 모두 0 으로 초기화
//        }
//        System.out.println("[STEP 1] reportedMap : " + reportedMap);
//        System.out.println("[STEP 1] answerMap : " + answerMap);
//
//
//        /*
//         * 2. 신고 기록 세팅 report 는 "신고한ID 신고된ID" 로 구성됨
//         */
//        for (String s : report) {
//            String[] reportStr = s.split(" ");
//            String reportingID = reportStr[0]; // 신고한ID
//            String reportedID = reportStr[1]; // 신고된ID
//            reportedMap.get(reportedID).add(reportingID); // 신고된ID 를 key 값으로 신고한ID 배열을 value 로 새팅
//        }
//        System.out.println("[STEP 2] reportedMap 에 신고 기록 세팅 : " + reportedMap);
//
//
//        /*
//         * 3. 유저가 받은 이용 정지 결과 메일 세팅
//         */
//        for (String reportedUser : reportedMap.keySet()) { // reportedUser 는 신고된ID유저
//            HashSet<String> userForSend = reportedMap.get(reportedUser); // reportedUser(신고된유저)를 신고한 유저
//            if (userForSend.size() >= k) { // 신고된 횟수가 K번 이상일 경우
//                for (String userId : userForSend) {
//                    answerMap.put(userId, answerMap.get(userId) + 1); // answerMap 에 신고된Id 별 메일 수 넣기
//                }
//            }
//        }
//        System.out.println("[STEP 3] answerMap 에 메일 수 세팅 : " + answerMap);
//
//
//        /*
//         * 4. 유저ID 별 받은 메일 수를 answer 에 세팅
//         */
//        for (int i = 0; i < id_list.length; i++) {
//            answer[i] = answerMap.get(id_list[i]);
//            System.out.println("[STEP 4] answer : " + answer[i]);
//        }
//
//        return answer;
//    }

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