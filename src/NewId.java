import java.util.ArrayList;

public class NewId {

    public static void main(String[] args) {
//        stringTest();

        String test = "...!@BaT#*..y.abcdefghijklm";
//        bat.y.abcdefghi
//        String test = ".ab1@#....AS -_.";
        String a = solution(test);
        System.out.println("a = " + a);

    }

    public static String solution(String new_id) {
        String answer = "";
//        ArrayList<String> listTest = new ArrayList<>(Arrays.asList(lowerCase(new_id).split("")));
//        ArrayList<String> result = minLengthValidate(lengthValidate(emptyValidate(dotReplace(dotDuplicate(validation(listTest))))));
//        answer = String.join("", result);

        answer = new Validate(new_id)
                .lowerCase()
                .removeString()
                .dotDuplicate()
                .dotReplace()
                .emptyValidate()
                .lengthValidate()
                .minLengthValidate()
                .getResult();
        return answer;
    }

    private static class Validate {
        private String new_id;

        public Validate(String new_id) {
            this.new_id = new_id;
        }

        // 1단계 모든 대문자를 소문자로 치환
        private Validate lowerCase() {
            return new Validate(new_id.toLowerCase());
        }

        // 2단계 소문자, 숫자, 빼기(-), 밑줄(_), 마침표를 재외하고 제거
        private Validate removeString() {
            StringBuilder result = new StringBuilder();
            for (String id : new_id.split("")) {
                if (Character.isLowerCase(id.charAt(0))
                        || Character.isDigit(id.charAt(0))
                        || "-".equals(id)
                        || "_".equals(id)
                        || ".".equals(id)
                ) {
                    result.append(id);
                }
            }

            return new Validate(result.toString());
        }

        // 3단계 마침표(.)가 2번이상 연속되면 마침표(.)하나로 치환
        private Validate dotDuplicate() {
            StringBuilder result = new StringBuilder();
            String dot = "";
            for (String id : new_id.split("")) {
                if (!(".".equals(id) && ".".equals(dot))) {
                    result.append(id);
                }

                dot = id;
            }

            return new Validate(result.toString());
        }

        // 4단계 마침표(.)가 처음이나 끝에 위치하면 제거
        private Validate dotReplace() {
            if (new_id.startsWith(".")) {
                new_id = new_id.substring(1);
            }
            if (new_id.endsWith(".")) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }

            return this;
        }

        // 5단계 빈 문자열이라면 a를 대입
        private Validate emptyValidate() {
            StringBuilder result = new StringBuilder();
            if (new_id.isEmpty()) {
                return new Validate("a");
            } else {
                for (String id : new_id.split("")) {
                    if (id.trim().isEmpty()) {
                        result.append("a");
                    } else {
                        result.append(id);
                    }
                }
            }

            return new Validate(result.toString());
        }

        // 6단계 길이가 16이상이면 15까지 제거 제거 후 마지막이 마침표면 제거
        private Validate lengthValidate() {
            if (new_id.length() > 15) {
                this.new_id = new_id.substring(0, 15);
                return dotReplace();
            }
            return this;
        }

        // 7단계 길이가 2자 이하면 마지막 문자를 3이 될때까지 반복
        private Validate minLengthValidate() {
            while (new_id.length() < 3) {
                new_id += new_id.substring(new_id.length()-1);
            }

            return this;
        }

        private String getResult() {
            return this.new_id;
        }
    }

    // 1단계 모든 대문자를 소문자로 치환
    public static String lowerCase(String new_id) {
        return new_id.toLowerCase();
    }

    // 2단계 소문자, 숫자, 빼기(-), 밑줄(_), 마침표를 재외하고 제거
    public static ArrayList<String> validation(ArrayList<String> list_id) {
        ArrayList<String> validation = new ArrayList<>();
        for (String id : list_id) {
            if (!(!Character.isLowerCase(id.charAt(0))
                    && !Character.isDigit(id.charAt(0))
                    && !"-".equals(id)
                    && !"_".equals(id)
                    && !".".equals(id))
            ) {
                validation.add(id);
            }
        }

        return validation;
    }

    // 3단계 마침표(.)가 2번이상 연속되면 마침표(.)하나로 치환
    public static ArrayList<String> dotDuplicate(ArrayList<String> list_id) {
        ArrayList<String> dotDuplicate = new ArrayList<>();
        String dot = "";
        for (String id : list_id) {
            if (!(".".equals(id) && ".".equals(dot))) {
                dotDuplicate.add(id);
            }

            dot = id;
        }

        return dotDuplicate;
    }

    // 4단계 마침표(.)가 처음이나 끝에 위치하면 제거
    public static ArrayList<String> dotReplace(ArrayList<String> list_id) {
        if (".".equals(list_id.get(0))) {
            list_id.remove(0);
        }
        if ((list_id.size()-1) > 0 && ".".equals(list_id.get(list_id.size()-1))) {
            list_id.remove(list_id.size()-1);
        }

        return list_id;
    }

    // 5단계 빈 문자열이라면 a를 대입
    public static ArrayList<String> emptyValidate(ArrayList<String> list_id) {
        ArrayList<String> emptyList = new ArrayList<>();
        for (String id : list_id) {
            if (id.trim().isEmpty()) {
                emptyList.add("a");
            } else {
                emptyList.add(id);
            }
        }

        if (emptyList.size() == 0) {
            emptyList.add("a");
        }

        return emptyList;
    }

    // 6단계 길이가 16이상이면 15까지 제거 제거 후 마지막이 마침표면 제거
    public static ArrayList<String> lengthValidate(ArrayList<String> list_id) {
        if (list_id.size() > 15) {
            ArrayList<String> lengthList = new ArrayList<>(list_id.subList(0, 15));
            dotReplace(lengthList);
            return lengthList;
        }

        return list_id;
    }

    // 7단계 길이가 2자 이하면 마지막 문자를 3이 될때까지 반복
    public static ArrayList<String> minLengthValidate(ArrayList<String> list_id) {
        int size = list_id.size() - 1;
        while (list_id.size() < 3) {
            list_id.add(list_id.get(size));
        }

        return list_id;
    }
}