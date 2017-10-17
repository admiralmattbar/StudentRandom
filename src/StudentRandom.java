
import utility.ConsoleHelper;
import window.MainWindow;


public class StudentRandom
{
    private static MainWindow win;

    public static void main(String[] args)
    {
        ConsoleHelper.setTime();
        System.out.println(ConsoleHelper.getTime());
        StudentRandom fr = new StudentRandom();

        win = new MainWindow();


    }



}
