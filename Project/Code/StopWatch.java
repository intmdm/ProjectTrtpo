package Code;

import java.io.IOException;
import java.util.Date;


public class StopWatch {

    String name;

    Date curentDate;
    Date newTime;
    int hours = 0, min = 0, sec = 0;
    int n = 1;

    Data data = new Data();

    StopWatch(String _name) throws IOException {
        name = _name;
    }
    String Start() {
        curentDate = new Date();
        return curentDate.toString();
    }
    String Stop() {
        newTime = new Date();
        return newTime.toString();
    }
    void save() {
        data.write(name, hours, min, sec);
    }
}

