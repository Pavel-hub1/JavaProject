package packeges;

public class Main {
    public static void main(String[] args) {
        FileCommands fileCommands = new Model("/java projects/FinalProject/src/packeges/Profiles.txt");
        Repository repository = new Decorator(new RepositoryFile(fileCommands), new Logger2());
        Validate validate = new Validate();
        ProfileController controller = new ProfileController(repository, validate);
        ViewProf view = new ViewProf(controller, validate);

        view.run();
    }
}