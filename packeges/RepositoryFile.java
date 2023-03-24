package packeges;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private ProfileMap mapper = new ProfileMap();
    private FileCommands fileCommands;

    public RepositoryFile(FileCommands fileCommands) {
        this.fileCommands = fileCommands;
    }

    @Override
    public List<Profile> getAllUsers() {
        List<String> lines = fileCommands.readAllLines();
        List<Profile> profiles = new ArrayList<>();
        for (String line : lines) {
            profiles.add(mapper.map(line));
        }
        return profiles;
    }

    @Override
    public void UpdateUser(Profile profile, Area field, String param){
        if(field == Area.name){
            profile.setFirstName(param);
        }
        else if(field == Area.secondName){
            profile.setLastName(param);
        }
        else if(field == Area.telephone){
            profile.setPhone(param);
        }
        saveUser(profile);
    }

    public void saveUser(Profile profile){
        List<String> lines = new ArrayList<>();
        List<Profile> profiles = getAllUsers();
        for (Profile item: profiles) {
            if(profile.getId().equals(item.getId())){
                lines.add(mapper.map(profile));
            }
            else {
                lines.add(mapper.map(item));

            }
        }
        fileCommands.saveAllLines(lines);

    }

    @Override
    public String CreateUser(Profile profile) {

        List<Profile> profiles = getAllUsers();
        int max = 0;
        for (Profile item : profiles) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        profile.setId(id);
        profiles.add(profile);
        List<String> lines = new ArrayList<>();
        for (Profile item: profiles) {
            lines.add(mapper.map(item));
        }
        fileCommands.saveAllLines(lines);
        return id;
    }
    @Override
    public void delUser(Profile profile) {
        List<String> lines = new ArrayList<>();
        List<Profile> profiles = getAllUsers();
        for (Profile item: profiles) {
            if(!profile.getId().equals(item.getId()))
                lines.add(mapper.map(item));
        }

        fileCommands.saveAllLines(lines);
        System.out.println("Удалено!");
    }
}