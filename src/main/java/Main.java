import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scr = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scr.nextLine();
        System.out.println("Введите пароль");
        String password = scr.nextLine();
        try {
            User user = getUserByLoginAndPassword(login, password);
            validateUser(user);
        } catch (UserNotFoundException u) {
            System.out.println(u);
        } catch (AccessDeniedException a) {
            System.out.println(a);
        }
    }
        public static User[] getUsers() {
            User user1 = new User("Ivan", "qwerty", "ivan@mail.ru", 12);
            User user2 = new User("Jhon", "pass","jhon@gmail.com" , 18);
            User user3 = new User("Petr", "123456", "petr@ya.ru", 19);
            return new User[]{user1, user2, user3};
        }
        public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
            User[] users = getUsers();
            for (User user : users) {
                if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    System.out.println("Пользователь " + login + " найден");
                    return user;
                }
            }throw new UserNotFoundException("User not found");


        }
            public static void validateUser(User user) throws AccessDeniedException{
            if (user.getAge() >= 18){
            System.out.println("Вход разрешен");
        }else throw new AccessDeniedException ("Пользователь слишком юн. Доступ запрещен");
    }
}


