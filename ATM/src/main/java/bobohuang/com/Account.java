package bobohuang.com;

public class Account {
    private String cardId; // 卡号
    private String userName; // 用户名
    private char gender; // 性别
    private String password; // 密码
    private  double money; // 余额
    private double limit; // 限额

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }


    @Override
    public String toString() {
        return "Account{" +
                "cardId='" + cardId + '\'' +
                ", userNmae='" + userName + '\'' +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", limit=" + limit +
                '}';
    }

    public String getUserNmae() {
        return userName + ( gender  == '男' ? "先生" : "女士");
    }

    public char getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public double getMoney() {
        return money;
    }

    public double getLimit() {
        return limit;
    }

    public void setUserNmae(String userNmae) {
        this.userName = userNmae;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public String getUserName() {
        return userName + (gender == '男' ? "先生" : "女士");
    }
}
