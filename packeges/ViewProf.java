package packeges;

import java.util.Scanner;

public class ViewProf {

    private final ProfileController profileController;
    private final Validate validate;

    public ViewProf(ProfileController profileController, Validate validate) {
        this.profileController = profileController;
        this.validate = validate;
    }

    public void run(){
        ListCom listCom1 = ListCom.NONE;
        help();
        while (true) {
            try {
                String command = prompt("Введите команду: ");
                listCom1 = ListCom.valueOf(command.toUpperCase());
                if (listCom1 == ListCom.EXIT) return;
                switch (listCom1) {
                    case CREATE:
                        create();
                        break;
                    case VIEW:
                        view();
                        break;
                    case LIST:
                        list();
                        break;
                    case DEL:
                        del();
                        break;
                    case HELP:
                        help();
                }
            }
            catch(Exception ex) {
                System.out.println("Произошла ошибка " + ex.toString());
            }
        }
    }
    private void view() throws Exception {
        String id = prompt("Идентификатор пользователя: ");
        Profile profile_ = profileController.readUser(id);
        System.out.println(profile_);
    }
    private void update() throws Exception {
        String userid = prompt("Идентификатор пользователя: ");
        String field_name = prompt("Какое поле (name, SIRNAME, TELEPHONE): ");
        String param = null;
        if (Area.valueOf(field_name) == Area.telephone) {
            param = catchTelephone(param);
            if(param == null) {
                return;
            }
        }
        else {
            param = prompt("Введите на то что хотите изменить");
        }
        Profile _profile = profileController.readUser(userid);
        profileController.updateUser(_profile, Area.valueOf(field_name.toUpperCase()), param);
    }
    public String catchTelephone(String telephone) throws Exception {
        while(true) {
            try {
                telephone = prompt("Введите номер телефона (Отказ введите 0): ");
                if(telephone.equals("0")) {
                    System.out.println("Вы отказались от ввода для изменения пользователя");
                    return null;
                }
                validate.checkNumber(telephone);
                return telephone;
            } catch(Telephone ex) {
                System.out.println("Произошла ошибка " + ex.toString());
            }
        }
    }
    private void list() throws Exception {
        for (Profile profile : profileController.getUsers()) {
            System.out.println(profile);
        }
    }
    private void create() throws Exception {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = null;
        phone = catchTelephone(phone);
        if(phone == null) {
            return;
        }

        profileController.saveUser(new Profile(firstName, lastName, phone));
    }
    private void del() throws Exception {
        String userid = prompt("Введите ID пользователя, которого надо удалить: ");
        Profile _profile = profileController.readUser(userid);
        profileController.deleteUser(_profile);
    }

    private void help() {
        System.out.println("Список команд:");
        for(ListCom c : ListCom.values()) {
            System.out.println(c);
        }
    }
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}