package packeges;

public class ProfileMap {
    public String map(Profile profile) {
        return String.format("%s,%s,%s,%s", profile.getId(), profile.getFirstName(), profile.getLastName(), profile.getTelephone());
    }

    public Profile map(String line) {
        String[] lines = line.split(",");
        return new Profile(lines[0], lines[1], lines[2], lines[3]);
    }
}