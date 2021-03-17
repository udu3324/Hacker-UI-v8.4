import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class settings extends JFrame
{
    //hey you! i see you looking in my code! if you would like to contribute, contact me via discord (_._#3324) or create a pull request on github! if you see any errors, tell me!
    //settings is still a work in progress

    private JPanel rootPanel;
    private JLabel title;
    private JLabel description;
    private JLabel delayLabel;
    private JButton saveButton;
    private JComboBox timeBox1;
    private JComboBox delayBox2;
    private JButton trueButton;

    //toggle stuff
    private int toggle = 0; //1 = true, 0 = false

    //saved strings from settings.txt
    //2 is used for confirming the values

    //todo file reader:
    //read setting file
    //save all the lines as strings in settings.java
    //
    //trueButton: when toggled,
    //overwrite settings.txt with setting change + add on saved strings
    //==
    //settings.txt preview:
    //("save-auto: True" + "\n");
    //("timer-number: 10s" + "\n");
    //("timer-delay: 300ms" + "\n");
    String saveauto = "true";
    String saveauto2 = "true";

    String timernumber = "3wf";
    String timernumber2 = "3wf";

    String timerdelay = "3wf";
    String timerdelay2 = "3wf";

    public settings()
    {
        add(rootPanel); //add intellij windows builder form

        setTitle("Hacker UI v8.4"); //set the title of the frame
                //this is where all the action listeners are
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop desktop = java.awt.Desktop.getDesktop();
                    URI oURL = new URI("https://github.com/udu3324/Hacker-UI-v8.4/blob/main/README.md");
                    desktop.browse(oURL);
                }   catch (Exception a) {
                    a.printStackTrace();
                }
            }
        });
        trueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toggle == 1) {
                    trueButton.setText("True");

                    try {
                        File myObj = new File("settings.txt");

                        if (myObj.createNewFile()) {
                            System.out.println("Made a new settings.txt file (bad)");
                        } else {
                            FileWriter myWriter2 = new FileWriter("settings.txt");
                            myWriter2.write("save-auto: True");
                            myWriter2.write(timernumber);
                            myWriter2.write(timerdelay);
                            myWriter2.close();
                            System.out.println("Settings file has been overwritten to save-auto: True (good)");
                        }
                    } catch (IOException a) {
                        System.out.println("An error occurred. (very bad)");
                        a.printStackTrace();
                    }
                    toggle = 0;

                }   else {
                    trueButton.setText("False");

                    try {
                        File myObj = new File("settings.txt");

                        if (myObj.createNewFile()) {
                            System.out.println("Made a new settings.txt file (bad)");
                        } else {
                            FileWriter myWriter2 = new FileWriter("settings.txt");
                            myWriter2.write("save-auto: False");
                            myWriter2.write(timernumber);
                            myWriter2.write(timerdelay);
                            myWriter2.close();
                            System.out.println("Settings file has been overwritten to save-auto: False (good)");
                        }
                    } catch (IOException a) {
                        System.out.println("An error occurred. (very bad)");
                        a.printStackTrace();
                    }

                    toggle = 1;
                }
            }
        });
        timeBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("todo action listener");
            }
        });
        delayBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("todo action listener");
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
