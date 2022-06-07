package projava;

public class State2 {
    public static void main(String[] args) {
        var data = "ab0c1ba3bc0c9cd1";
        char prev = 0;
        for(var ch : data.toCharArray()) {
            if(Character.isDigit(ch)) {
                int count = Character.digit(ch, 10) + 1;
                for(int i = 0; i < count; i++) {
                    System.out.print(prev);
                }
            } else {
                System.out.print(ch);
                prev = ch;
            }
        }
        System.out.println();
    }
}
