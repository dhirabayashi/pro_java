package projava;

public class TraverseDeep {
    public static void main(String[] args) {
        int[][] map = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 2, 1},
                {1, 1, 1, 1, 1, 1, 1},
        };
        traverse(map, 1, 1);
        char[] ch = {'.', '*', 'G', 'o'};
        for(int[] row : map) {
            for(int cell : row) {
                System.out.print(ch[cell]);
            }
            System.out.println();
        }
    }

    static boolean traverse(int[][] map, int curX, int curY) {
        switch (map[curX][curY]) {
            case 0: break;  // 通路なので続きの処理
            case 2: return true;  // ゴール
            default: return false;  // 通れない
        }
        map[curX][curY] = 3;  // 通った印
        if(traverse(map, curX + 1, curY) ||
                traverse(map, curX - 1, curY) ||
                traverse(map, curX, curY + 1) ||
                traverse(map, curX, curY - 1)) {
            return true;
        }
        map[curX][curY] = 0;  // ゴールにたどりつかなかったので通った印を戻す
        return false;
    }
}
