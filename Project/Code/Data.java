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

    void write() {
        try {
            out.print(this);
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
