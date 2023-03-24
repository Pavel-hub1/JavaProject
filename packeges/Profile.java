package packeges;

public class Profile {
    private String id = "";
    private String firstName;
    private String lastName;
    private String telephone;

    public Profile(String firstName, String lastName, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public Profile(String id, String firstName, String lastName, String telephone) {
        this(firstName, lastName, telephone);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setPhone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return String.format("Идентафикатор: %s\nИмя: %s,Фамилия: %s,Телефон: %s", id, firstName, lastName, telephone);
    }
}