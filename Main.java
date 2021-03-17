import javax.swing.*;
import java.net.URL;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, javax.swing.UnsupportedLookAndFeelException
    {
        //hey you! i see you looking in my code! if you would like to contribute, contact me via discord (_._#3324) or create a pull request on github! if you see any errors, tell me!
        //settings is still a work in progress

        System.out.println("Hello, World!"); //Hello, World!

        //credits, please don't remove :(
        System.out.println("=====================================================");
        for (String s : Arrays.asList("Hacker UI v8.4 by \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "                                   .o   .o     .oooo.     .oooo.     .oooo.         .o   \n" +
                "                                  .8'  .8'   .dP\"\"Y88b  .dP\"\"Y88b  .dP\"\"Y88b      .d88   \n" +
                "                              .888888888888'       ]8P'       ]8P'       ]8P'   .d'888   \n" +
                "                                .8'  .8'         <88b.      <88b.      .d8P'  .d'  888   \n" +
                "                            .888888888888'        `88b.      `88b.   .dP'     88ooo888oo \n" +
                "            .o.               .8'  .8'       o.   .88P  o.   .88P  .oP     .o      888   \n" +
                "ooooooooooo     ooooooooooo  .8'  .8'        `8bd88P'   `8bd88P'   8888888888     o888o  ", "=====================================================")) {
            System.out.println(s);
        }

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                System.out.println("Hacker UI v8.4: is loading..."); //print status of loading

                URL iconURL = getClass().getResource("/images/Hacker UI.png"); //load icon resource
                ImageIcon icon = new ImageIcon(iconURL); //set icon to icon

                HackerGUI hackergui = new HackerGUI(); //make a hacker gui

                hackergui.setIconImage(icon.getImage()); //get icon resource and set as
                hackergui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminate when asked on close
                hackergui.setResizable(false); //no resizing
                hackergui.pack(); //wrap it into a pack and set jframe size depending on jframe component size
                hackergui.setLocationRelativeTo(null); //set location to middle of screen
                hackergui.setVisible(true); //set the frame visible



            }
        });
    }
}
