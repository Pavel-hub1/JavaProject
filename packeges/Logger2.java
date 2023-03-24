package packeges;

import java.time.LocalDateTime;

public class Logger2 implements Logger1 {

    @Override
    public void logg(String msg) {
        System.out.println(LocalDateTime.now() + msg);
    }

}
