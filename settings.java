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

    public settings()
    {
        add(rootPanel); //add intellij windows builder form

        setTitle("Hacker UI v8.4"); //set the title of the frame

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop desktop = java.awt.Desktop.getDesktop();
                    URI oURL = new URI("https://github.com/udu3324/Hacker-UI-v8.4");
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
                    //insert code here
                    toggle = 0;
                }   else {
                    trueButton.setText("False");
                    //insert code here
                    toggle = 1;
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
