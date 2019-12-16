package Code;

import java.io.*;

public class Data {

    private static final String fileName = "/Users/daniilmaksimcik/Documents/Материалы/5 семестр/ТРиТПО/ProjectTrtpo/Project/Text.txt";

    private File file = new File(fileName);
    private PrintWriter out = new PrintWriter(file.getAbsoluteFile());
    private FileReader in  = new FileReader( file.getAbsoluteFile());

    protected int id;
    protected String name;
    protected int day;
    protected int month;
    protected int year;

    Data() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    void write(String name, int hours, int min, int sec) {
        try {
            out.print(name);
            out.print(" ");
            out.print(hours);
            out.print(" ");
            out.print(min);
            out.print(" ");
            out.print(sec);
            out.close();
        } finally {
            out.close();
        }
}
    void read(){
        try {
            //this = in.read();
        } finally {
            out.close();
        }
    }
    void close() throws IOException {

    }
}
