package packeges;

import java.util.List;

public class ProfileController {
    private final Repository repository;
    private final Validate validate;

    public ProfileController(Repository repository, Validate validate) {
        this.repository = repository;
        this.validate = validate;
    }

    public void saveUser(Profile profile) throws Exception {
        validate.checkNumber(profile.getTelephone());
        repository.CreateUser(profile);
    }
    public void updateUser(Profile profile, Area field, String param) throws Exception {
        if(field == Area.telephone) {
            validate.checkNumber(param);
        }
        repository.UpdateUser(profile, field, param);
    }

    public Profile readUser(String userId) throws Exception {
        List<Profile> profiles = repository.getAllUsers();
        for (Profile profile : profiles) {
            if (profile.getId().equals(userId)) {
                return profile;
            }
        }

        throw new Exception("Profile not found");
    }
    public List <Profile> getUsers() throws Exception {
        return repository.getAllUsers();
    }
    public void deleteUser(Profile profile) throws Exception {
        repository.delUser(profile);}
}