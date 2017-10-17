package window;

import utility.ConsoleHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private TextField sn;  //A text field for creating name objects on screen
    private int i = 0; //Keep track of the number of names

    //variables to store and modify placement of name objects depending on how many exist
    private int text_y = 30;
    private int text_x = 10;

    private String[] students; //array that holds the students names

    static Dimension screenSize;

    private String filename = "";



    public MainWindow()
    {
        super("Random Student Name Picker");
        screenSize = new Dimension(1024, 768);
        students = new String[24];
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(screenSize);
        this.setBackground(Color.black);
        this.addName();
        this.setResizable(true);



        //Menu Bar Stuff

        JMenuBar men = new JMenuBar();

        //Declare variables in private scope for projection
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem;
        JMenuItem loadItem;
        JMenuItem newItem;

        //Main Menu Items

        men.add(fileMenu);

        //Sub menu items
        saveItem = new JMenuItem("Save");
        loadItem = new JMenuItem("Load");
        newItem = new JMenuItem("New");

        //Add to the "File" menu item
        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);

        //Anonymous Inner classes for actionListeners


        //Action event for saving
        saveItem.addActionListener(new ActionListener(){ //adding the listener
            @Override
            public void actionPerformed(ActionEvent e){ //creating the specific action for save
                ConsoleHelper.printConsole("Saving File.");
                final JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(saveItem);

            }
        });

        //Action event for loading
        loadItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
               ConsoleHelper.printConsole("Loading File.");
           }
        });

        //Action event for new
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ConsoleHelper.printConsole("Making New File.");
            }
        });

        this.setJMenuBar(men);
        this.validate();
        this.repaint();

    }

    private void addName()
    {
        Font f = new Font("Serif", Font.PLAIN, 24);

        JTextField input, instruction;

        input = new JTextField("");
        instruction = new JTextField("Enter Name and Press Enter");

        input.setFont(f);
        input.setBounds(getWidth()/3, (int)(this.getHeight()/1.3), 300, 33);

        instruction.setFont(f);
        instruction.setBounds(input.getX() + input.getWidth() + 15, (int)(this.getHeight()/1.3), 290, 33);
        instruction.setEditable(false);

        add(input);
        add(instruction);

        //Action Event for input
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ConsoleHelper.printConsole("Adding a Name.");

                //take user entered text and store as a string called name
                String name = input.getText();

                if(!name.isEmpty() && i < 24) { //Make sure input has something and class is not full
                    students[i] = name;
                    input.setText(""); //reset the textbox
                    i++;  //Increase the count of names

                    //Add the textbox for student name
                    sn = new TextField(name);
                    sn.setBounds(text_x, text_y, 300, 33);
                    sn.setFont(f);
                    sn.setEditable(false);
                    add(sn);

                    text_y += 50; //give space for new name to go underneath old name by changing y value to put name below

                    if(i%8 == 0)  //sort names into colums of 8 rows.
                    {
                        text_x += 315;
                        text_y = 30;
                    }

                }


            }
        });

    }



}
