import com.sun.scenario.Settings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.nio.CharBuffer;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class HackerGUI extends JFrame
{

    //jframe components
    private JPanel rootPanel;
    private JButton hack;
    private JLabel time;
    private JButton reset;
    private JLabel description;
    private JLabel title;
    private JLabel gif;
    private JTextField textField1;
    private JButton saveScoresButton;
    private JButton settingsButton;
    private JButton placeholder;

    //toggle stuff
    private int toggle = 0; //0 = have not opened, 1 = have opened (for settings UI)

    //timer stuff
    private final Timer timer; //create timer
    private final long duration = 10000; //duration of time
    private long startTime = -1; //start of the time
    private int delay = 300; //delay of when the time starts

    //hacker levels
    private int count = 0;

    public HackerGUI()
    {

        add(rootPanel); //add intellij windows builder form

        setTitle("Hacker UI v8.4"); //set the title of the frame

        //read settings
        try {
            Reader fileReader = new FileReader("settings.txt");
            int data = fileReader.read();
            while(data != -1) {
                doSomethingWithData(data);

                data = fileReader.read();
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //create scores.txt and settings.txt
        try {
            File myObj = new File("scores.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                System.out.println("Absolute path: " + myObj.getAbsolutePath());

                FileWriter myWriter = new FileWriter("scores.txt", true);
                String name = textField1.getText(); //get name string
                myWriter.write("=====================================================" + "\n");
                for (String s : Arrays.asList("Hacker UI v8.4 by \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                        "                                   .o   .o     .oooo.     .oooo.     .oooo.         .o   \n" +
                        "                                  .8'  .8'   .dP\"\"Y88b  .dP\"\"Y88b  .dP\"\"Y88b      .d88   \n" +
                        "                              .888888888888'       ]8P'       ]8P'       ]8P'   .d'888   \n" +
                        "                                .8'  .8'         <88b.      <88b.      .d8P'  .d'  888   \n" +
                        "                            .888888888888'        `88b.      `88b.   .dP'     88ooo888oo \n" +
                        "            .o.               .8'  .8'       o.   .88P  o.   .88P  .oP     .o      888   \n" +
                        "ooooooooooo     ooooooooooo  .8'  .8'        `8bd88P'   `8bd88P'   8888888888     o888o  \n" +
                        "===================================================== \n" + "The scores are below, they are formatted as: \n" +
                        "name + \" has scored \" + count + \" hacker levels in \" + duration + \" milli-seconds with a delay of \" + delay + \" milli-seconds.\" \n" +
                        "===================================================== \n")) {
                    myWriter.write(s);
                }
                myWriter.close();
                System.out.println("Successfully wrote to the score file.");
            } else {
                System.out.println("Scores file already exists.");
            }
        } catch (IOException a) {
            System.out.println("An error occurred.");
            a.printStackTrace();
        }

        try {
            File myObj = new File("settings.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                System.out.println("Absolute path: " + myObj.getAbsolutePath());

                FileWriter myWriter2 = new FileWriter("settings.txt", true);
                myWriter2.write("save-auto: True" + "\n");

                myWriter2.write("timer-number: 10s" + "\n");
                myWriter2.write("timer-delay: 300ms" + "\n");
                myWriter2.close();
                System.out.println("Successfully wrote to the settings file.");

            } else {
                System.out.println("Settings file already exists.");
            }
        } catch (IOException a) {
            System.out.println("An error occurred.");
            a.printStackTrace();
        }

        timer = new Timer(20, new ActionListener() { //timer module
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime < 0) { //if time reaches 0, stop time so it doesn't go to negative int
                    startTime = System.currentTimeMillis(); //use system time
                }
                long now = System.currentTimeMillis(); //use system time
                long clockTime = now - startTime;
                if (clockTime >= duration) { //whenever clock reaches 0, run command under:
                    clockTime = duration;
                    timer.stop(); //stop the timer from going to the negatives

                    hack.setEnabled(false); //disables hack button as timer went to 0
                    reset.setEnabled(true); //enable reset button to play again

                }
                SimpleDateFormat df = new SimpleDateFormat("mm:ss.SSS"); //format of time shown
                time.setText(df.format(duration - clockTime)); //set time component to destination
            }
        });
        timer.setInitialDelay(delay); //set the delay

        hack.addActionListener(new ActionListener() { //play action listener, triggers when button is pressed
            @Override
            public void actionPerformed(ActionEvent e) {
                count++; //count in positives and add
                hack.setText("Hacker Level: " + count); //change int and label

                if (!timer.isRunning()) { //when button pressed, start timer
                    startTime = -1; //int to when start
                    timer.start(); //start
                }
            }
        });
        reset.addActionListener(new ActionListener() { //reset action listener, triggers when button is pressed
            @Override
            public void actionPerformed(ActionEvent e) {
                hack.setEnabled(true); //enable hack button to start a new game
                reset.setEnabled(false); //disable reset button as it has been used

                //old command line save score
                String name = textField1.getText(); //get name string
                System.out.println(name + " has scored " + count + " hacker levels in " + duration +" milli-seconds with a delay of " + delay + " milli-seconds."); //print other info
                System.out.println(""); //print spacer
                //old command line save score



                count = count + -count; //count in positive integers
                hack.setText("Hacker Level: " + -count); //reset level score
                time.setText("00:10.000"); //reset time label
            }
        });
        saveScoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter myWriter = new FileWriter("scores.txt", true);
                    String name = textField1.getText(); //get name string
                    myWriter.write(name + " has scored " + count + " hacker levels in " + duration +" milli-seconds with a delay of " + delay + " milli-seconds." + "\n");
                    myWriter.close();
                    System.out.println("Successfully wrote to the score file.");
                    System.out.println(name + " has scored " + count + " hacker levels in " + duration +" milli-seconds with a delay of " + delay + " milli-seconds."); //print other info
                    System.out.println(""); //print spacer
                } catch (IOException b) {
                    System.out.println("An error occurred.");
                    b.printStackTrace();
                }
            }
        });
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toggle == 0) {

                    System.out.println("Settings UI is loading/loaded."); //print status of loading
                    URL iconURL = getClass().getResource("/images/Hacker UI.png"); //load icon resource
                    ImageIcon icon = new ImageIcon(iconURL); //set icon to icon

                    settings settings = new settings(); //make a hacker gui
                    settings.setIconImage(icon.getImage()); //get icon resource and set as
                    settings.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //dispose when asked on close
                    settings.setResizable(false); //no resizing
                    settings.pack(); //wrap it into a pack and set jframe size depending on jframe component size
                    settings.setLocationRelativeTo(null); //set location to middle of screen
                    settings.setVisible(true); //set the frame not visible
                    toggle = 1;
                }   else {
                    System.out.println("You are not allowed to open settings anymore.\n(the settings window also could of moved behind the Hacker UI window)");
                    JOptionPane.showMessageDialog(rootPanel, "You are not allowed to open settings anymore.\n(the settings window also could of moved behind the Hacker UI window)");
                }
            }
        });

        //please don't delete! as this shows credits and help info
        JOptionPane.showMessageDialog(rootPanel, "Hacker UI v8.4 is created by _._#3324. Thank you for downloading. \nWhat is Hacker UI v8.4? It is a clicker game. \nTo know more, click on the Documentation button in the settings menu.");

        System.out.println("Hacker UI v8.4: has successfully loaded.");

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void setData(HackerGUI data) {
    }

    public void getData(HackerGUI data) {
    }

    public boolean isModified(HackerGUI data) {
        return false;
    }

    }
