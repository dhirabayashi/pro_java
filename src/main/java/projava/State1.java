package projava;

public class State1 {
    public static void main(String[] args) {
        var data = "aa0bcd1efg1gg0abc";

        var sb = new StringBuilder();
        boolean upperCase = false;
        for(var ch : data.toCharArray()) {
            switch (ch) {
                case '0' -> upperCase = true;
                case '1' -> upperCase = false;
                default -> {
                    if(upperCase) {
                        sb.append(Character.toUpperCase(ch));
                    } else {
                        sb.append(Character.toLowerCase(ch));
                    }
                }

            }
        }

        System.out.println(sb);
    }
}
