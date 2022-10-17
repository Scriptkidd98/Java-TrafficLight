package signal;

import java.awt.Color;
import static java.awt.Color.green;
import static java.awt.Color.red;
import static java.awt.Color.yellow;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SignalDemo extends JFrame implements Runnable {

    JPanel red, yellow, green;
    JLabel time, show;




    public SignalDemo()
    {
        this.getContentPane().setBackground(Color.BLACK);
        this.setSize(100,260);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        red = new JPanel();
        red.setBackground(Color.red);
        yellow = new JPanel();
        yellow.setBackground(Color.yellow);
        green = new JPanel();
        green.setBackground(Color.green);

        setLayout(null);
        red.setBounds(40,20,40,40);
        add(red);
        yellow.setBounds(40,70,40,40);
        add(yellow);
        green.setBounds(40,120,40,40);
        add(green);
        time = new JLabel("Time remaining");
        time.setForeground(Color.WHITE);
        time.setBounds(20,160,100,40);
        add(time);
        show = new JLabel("");
        show.setBounds(38,178,80,40);
        show.setForeground(Color.CYAN);
        add(show);

    }

    public static void main(String args[])
    {
        SignalDemo signal = new SignalDemo();
        //create task
        Thread task = new Thread(signal);
        task.start();

    }

    @Override
    public void run() {
        try {
            while(true) {

                red.setBackground(Color.red);

                yellow.setBackground(Color.GRAY);

                green.setBackground(Color.GRAY);

                for( int i=3;i>0;i--) {

                    String s = Integer.toString(i);

                    show.setText(s+" - Stop - ");

                    Thread.sleep(1000);
                }
                yellow.setBackground(Color.GRAY);

                green.setBackground(Color.GREEN);

                red.setBackground(Color.GRAY);

                for( int i=5;i>0;i--) {

                    String s = Integer.toString(i);

                    show.setText(s+" - Go - ");

                    Thread.sleep(1000);
                }
                yellow.setBackground(Color.YELLOW);

                green.setBackground(Color.GRAY);

                red.setBackground(Color.GRAY);

                for( int i=2;i>0;i--) {

                    String s = Integer.toString(i);

                    show.setText(s+" - Get Slow - ");

                    Thread.sleep(1000);
                }
            }
        }
        catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}