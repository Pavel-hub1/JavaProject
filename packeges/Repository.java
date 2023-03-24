package packeges;

import java.util.List;

public interface Repository {
    List<Profile> getAllUsers();
    String CreateUser(Profile profile);
    void UpdateUser(Profile profile, Area field, String param);
    void delUser(Profile profile);
}