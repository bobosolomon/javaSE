package bobohuang.com;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
//     创建一个存储账户对象的集合；后面没开一个账户，就在集合中添加一个账户对象
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    Account loginAcc;

    public ATM() {
    }

    //     /*
//       启动ATM系统，展示欢迎界面
//     */
    public void start(){
        System.out.println("===欢迎您进入到了ATM系统===");
        System.out.println("1、用户登陆");
        System.out.println("2、用户开户");
        System.out.println("请选择: ");
        int command = sc.nextInt();
        switch (command){
            case 1:
                //用户登陆
                System.out.println("进入登陆功能");
                break;
            case 2:
                //用户开户
                System.out.println("进入用户开户功能");
                break;
            default:
                System.out.println("没有该操作");
        }
    }

    /*
    * 完成用户开户操作
    */
    private void createAccount(){
        System.out.println("系统开户操作");
        // 1. 创建一个用户对象，用于封装用户的开户信息
        Account acc = new Account();

        // 2. 需要用户输入自己的开户信息，赋值给用户对象
        System.out.println("请您输入您的账户名称");
        String name = sc.next();
        acc.setUserNmae(name);

        while (true) {
            System.out.println("请您输入您的性别");
            char gender = sc.next().charAt(0);
            if (gender == '男' || gender == '女') {
                acc.setGender(gender);
                break;
            }
            else {
                System.out.println("您输入的性别有误，只能是男或者女");
            }
        }

        while (true) {
            System.out.println("请您输入您的账户密码: ");
            String passWord = sc.next();
            System.out.println("请您输入您的确认密码");
            String okPassWord = sc.next();
            // 判断两次密码是否一样
            if (okPassWord.equals(passWord)){
                acc.setPassword(passWord);
                break;
            }else {
                System.out.println("您输入的2次密码不一致，请您确认");
            }
        }
        System.out.println("请您输入您的取现额度");
        double limit = sc.nextDouble();
        acc.setLimit(limit);

        accounts.add(acc);
        System.out.println("恭喜您，" +  acc.getUserName() + "开户成功，您的卡号是：" + acc.getCardId());

    }

    private Account getAcountByCardId(String cardId){
        // 遍历全局的账户对象
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (account.getCardId().equals(cardId)) {
                return account;
            }
        }
        return null;
    }

    private String createCardId(){
        while (true) {
            String cardId = "";
            Random random = new Random();
            for (int i = 0; i < 8; i++) {
                int data = random.nextInt(10);
                cardId += data;
            }

            Account acc = getAcountByCardId(cardId);
            if (acc == null){
                return cardId;
            }
        }
    }


    /*完成用户的登陆操作*/
    private void login(){
        System.out.println("===系统登陆===");
        if (accounts.size() == 0){
            System.out.println("当前系统中无任何账户，请先开户再来登陆");
            return ;
        }

        System.out.println("请您输入您的登陆卡号");
        String cardId = sc.next();
        Account acc = getAcountByCardId(cardId);
        if (acc==null){
            System.out.println("您输入的登陆卡号不存在，请确认");
        }
        else{
            System.out.println("请您输入登陆密码： ");
            String passWord = sc.next();
            if (acc.getPassword().equals(passWord)){
                loginAcc = acc;
                System.out.println("恭喜您，" + acc.getUserName() + "成功登陆了系统， 您的卡号是: " + acc.getCardId());
                // TODO 把展示界面的功能，写成一个方法，写好了在回来调用
                return ; // 跳出并结束当前登陆方法
            } else {
                System.out.println("您输入的密码不正确，请确认");
            }

        }
    }


    /*显示登陆后的操作界面*/
    private void showUserCommand(){
        while (true) {
            System.out.println(loginAcc.getUserName() + "您可以选择如下功能进行账户的处理====");
            System.out.println("1、查询账户");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、密码修改");
            System.out.println("6、退出");
            System.out.println("7、注销当前账户");
            System.out.println("请选择：");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    // TODO 查询当前账户
                    break;
                case 2:
                    // TODO 存款
                    break;
                case 3:
                    // TODO 取款
                    break;
                case 4:
                    // TODO 转账
                    break;
                case 5:
                    // TODO 密码修改
                    return ; // 跳出并结束当前方法
                case 6:
                    // TODO 退出
                    System.out.println(loginAcc.getUserName() + "您退出系统成功！");
                    return ; // 跳出结束当前方法
                case 7:
                    // 注销当前账户
                    if (deleteAccount()){
                        // 销户成功，回到欢迎界面
                        return ;
                    }
                    break;;
                default:
                    System.out.println("您当前选择的操作不存在，请确认");
            }
        }
    }
}
