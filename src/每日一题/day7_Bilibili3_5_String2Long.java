package 每日一题;


public class day7_Bilibili3_5_String2Long {
    public Long valueOf(String s) throws NumberFormatException {
        return Long.valueOf(parseLong(s, 10));
    }

    public long parseLong(String s, int radix) throws NumberFormatException {
        // 检查输入字符串是否为 null
        if (s == null) {
            // 如果为 null，则抛出异常
            throw new NumberFormatException("Cannot parse null string");
        }

        // 检查进制数是否在有效范围内
        if (radix < Character.MIN_RADIX) {
            // 如果小于最小进制数2，则抛出异常
            throw new NumberFormatException("radix " + radix +
                    " less than Character.MIN_RADIX");
        }
        if (radix > Character.MAX_RADIX) {
            // 如果大于最大进制数36，则抛出异常
            throw new NumberFormatException("radix " + radix +
                    " greater than Character.MAX_RADIX");
        }

        // 初始化变量，用于表示解析后的结果是否为负数，默认为 false
        boolean negative = false;
        // 初始化变量 i 为 0，表示当前解析到字符串的位置
        int i = 0, len = s.length();
        // 初始化变量 limit 为 long 类型的最小值
        long limit = -Long.MAX_VALUE;

        // 如果字符串长度大于 0，开始解析字符串
        if (len > 0) {
            // 获取字符串的第一个字符
            char firstChar = s.charAt(0);
            // 判断第一个字符是否为正负号
            if (firstChar < '0') { // Possible leading "+" or "-"
                // 如果是负号，则设置 negative 为 true，limit 为 long 类型的最大值
                if (firstChar == '-') {
                    negative = true;
                    limit = Long.MIN_VALUE;
                } else if (firstChar != '+') {
                    // 如果不是正负号，则抛出异常
                    throw new NumberFormatException("非法字符");
                }

                // 如果字符串长度为 1，则表示不能只有一个正负号
                if (len == 1) {
                    throw new NumberFormatException("非法字符");
                }
                // 跳过第一个字符
                i++;
            }

            // 计算 multmin，表示当前进制下 long 类型的最小值除以 radix
            long multmin = limit / radix;
            // 初始化变量 result 为 0，表示解析后的结果
            long result = 0;
            // 循环遍历字符串中的字符
            while (i < len) {
                // 将字符转换为数字
                int digit = Character.digit(s.charAt(i++),radix);
                // 如果字符无法转换为数字，或者结果已经小于 multmin，则抛出异常
                if (digit < 0 || result < multmin) {
                    throw new NumberFormatException();
                }
                // 将结果乘以进制
                result *= radix;
                // 如果结果小于 limit + digit，则抛出异常
                if (result < limit + digit) {
                    throw new NumberFormatException();
                }
                // 将 digit 加到结果上
                result -= digit;
            }
            // 返回最终结果，如果是负数则取反
            return negative ? result : -result;
        } else {
            // 如果字符串长度为 0，则抛出异常
            throw new NumberFormatException();
        }
    }
}
