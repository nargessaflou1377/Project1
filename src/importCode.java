
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class importCode {
    public String javaMaker(String text)
    {
        String point="";
        PrintWriter wr=null;
        try {
            for (int i = 1; i < 1025; i*=2) {
                wr = new PrintWriter("main.java");
                wr.println(text.replaceAll("N", Integer.toString(i)));
                wr.close();
                Runtime.getRuntime().exec("javac main.java");
                TimeUnit.SECONDS.sleep(1);
                Process exec=Runtime.getRuntime().exec("java main");
                TimeUnit.SECONDS.sleep(1);
                BufferedReader stdInput=new BufferedReader(new InputStreamReader(exec.getInputStream()));
                Long lengh=stdInput.lines().count();
                point+="("+i+","+lengh+")";
                System.out.println(i);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException | InterruptedException ex) {
        }
        return point;
    }
    public Long lastPoint(String text)                                                                                                                              
    {
        PrintWriter wr=null;
        try {
            wr = new PrintWriter("main.java");
            wr.println(text.replaceAll("N", "10000"));
            wr.close();
            Runtime.getRuntime().exec("javac main.java");
            TimeUnit.SECONDS.sleep(1);
            Process exec=Runtime.getRuntime().exec("java main");
            TimeUnit.SECONDS.sleep(1);
            BufferedReader stdInput=new BufferedReader(new InputStreamReader(exec.getInputStream()));
            return stdInput.lines().count();
           
        } catch (FileNotFoundException ex) {
        } catch (IOException | InterruptedException ex) {
        }
        return null;
    }
}
