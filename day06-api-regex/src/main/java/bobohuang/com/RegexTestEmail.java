package bobohuang.com;

import java.util.Scanner;

public class RegexTestEmail {
    public static void main(String[] args) {
        // checkEmail();
        checkPhone();

    }

    public static void checkEmail(){
        while (true) {
            System.out.println("请您输入你的邮箱");
            Scanner scanner = new Scanner(System.in);
            String email = scanner.nextLine();
            if(email.matches("\\w{2,}@\\w{2,20}\\.(\\w{2,10}){1,2}")){
                System.out.println("您输入的邮箱格式正确");
                break;
            } else {
                System.out.println("您输入的邮箱格式不确定");
            }
        }

    }

    public static void checkPhone(){
        while (true) {
            System.out.println("请您输入您的电话号码");
            Scanner scanner = new Scanner(System.in);
            String phone = scanner.nextLine();
            if (phone.matches("(1[3-9]\\d{9})|(0\\d{2,7}-?[1,9]\\d{4,19})")){
                System.out.println("您输入的号码格式正确~~~");
                break;
            }else {
                System.out.println("您输入的号码格式不正确");
            }
        }
    }
}
