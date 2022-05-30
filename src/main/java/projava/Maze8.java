package projava;

import java.io.IOException;

public class Maze8 {
    public static void main(String[] args) throws IOException {
        record Position(int x, int y) {}
        int[][] map = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1},
                {1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        var current = new Position(1, 1);
        var goal = new Position(10, 5);
        var lowerCase = true;
        for(;;) {
            // 迷路の表示
            for (int y = 0; y < map.length; y++){
                for (int x = 0; x < map[y].length; x++) {
                    if(x < current.x() - 2
                            || x > current.x() + 2
                            || y < current.y() - 2
                            || y > current.y() + 2
                    ) {
                        continue;
                    }

                    if(x == current.x() && y == current.y()) {
                        if(lowerCase) {
                            System.out.print("o");
                        } else {
                            System.out.print("O");
                        }
                    } else if (map[y][x] == 1) {
                        System.out.print("*");
                    } else if(x == goal.x() && y == goal.y()) {
                        System.out.print("G");
                    } else {
                        System.out.print(".");
                    }
                }
                if(y >= current.y() - 2 && y <= current.y() + 2) {
                    System.out.println();
                }
            }
            // ゴール判定
            if (current.equals(goal)) {
                System.out.println("GOAL!!!");
                break;
            }

            // キー入力処理
            int ch = System.in.read();
            // 押された方向の座標を得る
            var next = switch (ch) {
                case 'h' -> new Position(current.x() - 1, current.y());
                case 'u' -> new Position(current.x(), current.y() - 1);
                case 'j' -> new Position(current.x() + 1, current.y());
                case 'n' -> new Position(current.x(), current.y() + 1);
                default -> current;
            };
            // 押された方向が迷路なら進む
            if(map[next.y()][next.x()] == 0) {
                lowerCase = !lowerCase;
                current = next;
            }
            // Enterキーの入力を捨てる
            // 2文字入力するなどするとこちらで入力待ちになってしまう
            // 何も入力せずEnterで復帰できる
            // ここでは直さないが、行単位で取得するようにすれば回避できる
            System.in.read();
        }
    }
}
