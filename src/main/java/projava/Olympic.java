package projava;

public class Olympic {
    public static void main(String[] args) {
        new Olympic().isSummerOlympicYear(2000);
    }

    /**
     * 渡された西暦年が夏季近代オリンピック開催年であるかどうか判定する
     * @param year 西暦年
     * @return 夏季オリンピック開催年であればtrue
     * @throws IllegalArgumentException まだオリンピック開催が確定していない年を渡した場合
     */
    public boolean isSummerOlympicYear(int year) throws IllegalArgumentException {
        // 近代オリンピック開始以前
        if(year < 1896) {
            return false;
        }

        // 戦争やパンデミックで開催中止
        if(year == 1916 || year == 1940 || year == 1944 || year == 2020) {
            return false;
        }

        // 例外的な開催年
        if(year == 2021) {
            return true;
        }

        if(2032 < year) {
            throw new IllegalArgumentException("2032年までをサポートしています。入力：" + year);
        }

        return year % 4 == 0;
    }
}
