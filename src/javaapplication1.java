
import javax.swing.JFrame;


public class javaapplication1 {
    public static void main(String[] args) {
        JFrame app=new JFrame();
        NewJPanel myapp=new NewJPanel();
        app.setSize(917, 700);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(myapp);
        app.setVisible(true);
    }
}
