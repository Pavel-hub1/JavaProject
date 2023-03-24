package packeges;

import java.util.List;

public class Decorator implements Repository{
    private Repository repo;
    private Logger2 logger;


    @Override
    public List<Profile> getAllUsers() {
        List<Profile> res = repo.getAllUsers();
        return res;
    }
    @Override
    public void delUser(Profile profile) {
        repo.delUser(profile);
        logger.logg("Дата удаление: ");
    }
    @Override
    public String CreateUser(Profile profile) {
        String res = repo.CreateUser(profile);
        logger.logg("Дата создания: ");
        return res;
    }

    @Override
    public void UpdateUser(Profile profile, Area area, String param) {
        repo.UpdateUser(profile, area, param);
    }



    public Decorator(Repository repo, Logger2 logger) {
        this.repo = repo;
        this.logger = logger;
    }



}