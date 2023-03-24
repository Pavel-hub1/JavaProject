package packeges;

import java.util.List;

public interface FileCommands {
    List<String> readAllLines();

    void saveAllLines(List<String> lines);
}