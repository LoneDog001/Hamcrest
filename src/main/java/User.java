public class User {
    private String login;
    private String password;
    private String email;
    private int age;

    User (String login, String password, String email, int age){
        this.password = password;
        this.login = login;
        this.email = email;
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
