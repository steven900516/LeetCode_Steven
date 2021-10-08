package leetcode;

/**
 * @author Steven0516
 * @create 2021-10-02
 */
public class IsNumber {

    //偷懒
    public boolean isNumber(String s) {
        char[] charArray = s.toCharArray();
        // 字符串长度
        int n = charArray.length;

        // 当前下标
        int index = 0;

        // 标记
        boolean hasNum = false, hasE = false;
        boolean hasSign = false, hasDot = false;

        // 将下标移动到非空格字符上
        while (index < n && charArray[index] == ' ') {
            index++;
        }

        // 当前下标尚未到达字符串末尾
        while (index < n) {
            // 当前字符
            char c = charArray[index];

            if (c >= '0' && c <= '9') {
                // 当前字符是数字 0~9
                hasNum = true;
            } else if (c == 'e' || c == 'E') {
                // 当前字符是 e / E
                if (hasE || !hasNum) {
                    // e / E 已经出现过，或者数字没有出现过，则该字符串必定无法表示数值，返回 false
                    return false;
                }
                hasE = true;
                hasNum = false;
                hasSign = false;
                hasDot = false;
            } else if (c == '+' || c == '-') {
                // 当前字符是正负号
                if (hasSign || hasNum || hasDot) {
                    // 如果已经出现过符号、数字、小数点，则该字符串必定无法表示数值，返回 false
                    return false;
                }
                hasSign = true;
            } else if (c == '.') {
                // 如果是小数点
                if (hasDot || hasE) {
                    // 如果已经出现过小数点、e / E ，则该字符串必定无法表示数值，返回 false
                    return false;
                }
                hasDot = true;
            } else if (c == ' ') {
                // 如果是空格，跳出循环
                break;
            } else {
                // 非法字符
                return false;
            }

            // 继续判断下一个字符
            index++;
        }

        // 如果当前下标尚未到达字符串末尾，则剩下的字符应当全部为空格，否则该字符串必定无法表示数值，返回 false
        for (; index < n; index++) {
            if (charArray[index] != ' ') {
                return false;
            }
        }

        return hasNum;
    }
}
