package bobohuang.com;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkQQ("133323213"));
        System.out.println(checkQQ("0133323213"));
        System.out.println(checkQQ("133fsdf323213"));

        System.out.println("---------------------------");

        System.out.println(checkQQ1("133323213"));
        System.out.println(checkQQ1("0133323213"));
        System.out.println(checkQQ1("133fsdf323213"));

    }

    public static boolean checkQQ(String qq) {
    // 1. 判断qq号码是否为nll
        if (qq == null || qq.startsWith("0") || qq.length() < 6 || qq.length() > 20){
            return false;
        }

    //   2. qq至少不是null，不是以0开头，满足6-20之间的长度
    //     判断qq号码是否都是数字
        for (int i = 0; i < qq.length(); i++) {
            char ch = qq.charAt(i);
            if (ch < '0' || ch > '9'){
                return false;
            }
        }
    //     3. 说明qq号码是合法的
        return true;
    }

    public static boolean checkQQ1(String qq){
        return qq != null && qq.matches("[1-9]\\d{5,19}");
    }

}