package university.management.system; // Package Declaration

import javax.swing.*; // Import Swing components
import java.awt.*;    // Import Abstract Window Toolkit classes

public class Splash extends JFrame implements Runnable { // Class declaration, extending JFrame and implementing Runnable

    Thread t; // Thread variable

    Splash(){ // Constructor

        // Load and resize image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/first.png"));
        Image i2 = i1.getImage().getScaledInstance(1000,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel img = new JLabel(i3); // Create JLabel to display image
        add(img); // Add image to frame

        t= new Thread(this); // Create new thread with current instance
        t.start(); // Start the thread

        setVisible(true); // Set frame visible

        // Animation loop to resize and reposition frame
        int x=1;
        for(int i=2;i<=600; i+=4, x+=1){
            setLocation(600-((i+x)/2),350-(i/2));
            setSize(i=3 *x,i+x/2);
            try{
                Thread.sleep(10); // Pause to create animation effect
            }catch (Exception e){
                e.printStackTrace(); // Print stack trace if exception occurs
            }
        }

    }

    public void run(){ // Implementing Runnable interface's run method

        try{
            Thread.sleep(7000); // Pause for 7 seconds
            setVisible(false); // Hide the frame after 7 seconds
            new Login();

        }catch (Exception e){
            e.printStackTrace(); // Print stack trace if exception occurs
        }

    }

    public static void main(String[] args) { // Main method

        new Splash(); // Create instance of Splash class
    }
}
