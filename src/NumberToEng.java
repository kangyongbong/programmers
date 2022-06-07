public class NumberToEng {

    public static void main(String[] args) {
        String text = "one4seveneight";
        System.out.println(solution(text));

        String text2 = "one4seveneight";
        System.out.println(solution(text2));
    }

    public static int solution(String s) {
        int answer = 0;

        answer = new NumToEng(s)
                .replace()
                .getInt();

        return answer;
    }

    public int solution2(String s) {

        String[] arrNumStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0 ; i<arrNumStr.length ; i++) {
            s = s.replace(arrNumStr[i], String.valueOf(i));
        }

        return Integer.parseInt(s);

    }

    static class NumToEng {
        private String num;

        public NumToEng(String num) {
            this.num = num;
        }

        public NumToEng replace() {
            for (Eng value : Eng.values()) {
                num = num.replaceAll(value.toString(), value.getMessage());
            }
            return this;
        }

        public int getInt() {
            return Integer.parseInt(num);
        }
    }

    static enum Eng {
        zero("0"),
        one("1"),
        two("2"),
        three("3"),
        four("4"),
        five("5"),
        six("6"),
        seven("7"),
        eight("8"),
        nine("9");

        Eng(String message) {
            this.message = message;
        }

        private final String message;

        public String getMessage() {
            return message;
        }
    }

}
