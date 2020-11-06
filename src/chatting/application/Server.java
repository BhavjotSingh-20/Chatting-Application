package chatting.application;
//import jdk.internal.jimage.ImageStrings;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.OverlappingFileLockException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Server implements ActionListener {
    private static Object SimpleDateFormat;
//    private static ImageStrings vertical;
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JFrame f1 = new JFrame();
    static  JPanel a1;
    static ServerSocket skt;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    Boolean typing;
   static Box vertical = Box.createVerticalBox();
    Server() {
          p1 =  new JPanel();
          p1.setLayout(null);
          p1.setBackground(new Color(7,94,84));
          p1.setBounds(0,0,450,70);
          f1.add(p1);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
               Image i2 = i1.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
               JLabel l1 = new JLabel(i3);
        l1.setBounds(5,17,30,30);
        p1.add(l1);
        l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/1.png"));
        Image i5 = i4.getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT);
        ImageIcon i6 =  new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
          l2.setBounds(40,5,60,60);
          p1.add(l2);

          JLabel l3 = new JLabel("Bhavjot");
          l3.setFont(new Font("SAN_SERIF",Font.BOLD,15));
          l3.setForeground(Color.WHITE);
          l3.setBounds(110,15,100,20);
          p1.add(l3);

        JLabel l4 = new JLabel("Active Now");
        l4.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        l4.setForeground(Color.WHITE);
        l4.setBounds(110,35,100,15);
        p1.add(l4);
        Timer t = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!typing)
                    l4.setText("Active Now");

            }
        });
        t.setInitialDelay(2000);


        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(35,30, Image.SCALE_DEFAULT);
        ImageIcon i9=  new ImageIcon(i8);
        JLabel ll0 = new JLabel(i9);
        ll0.setBounds(290,20,35,30);
        p1.add(ll0);


        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35,30, Image.SCALE_DEFAULT);
        ImageIcon i12 =  new ImageIcon(i11);
        JLabel ll1 = new JLabel(i12);
        ll1.setBounds(350,20,35,30);
        p1.add(ll1);


        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(13,25, Image.SCALE_DEFAULT);
        ImageIcon i15 =  new ImageIcon(i14);
        JLabel ll2 = new JLabel(i15);
        ll2.setBounds(410,20,13,25);
        p1.add(ll2);


        a1 =  new JPanel();
        a1.setBounds(5,75,440,570);
//        a1.setBackground(Color.PINK);
        a1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
//        a1.setEditable(false);
//        a1.setLineWrap(true);
//        a1.setWrapStyleWord(true);
//        a1.setAlignmentX(40);
        f1.add(a1);
        t1 = new JTextField();
        t1.setBounds(5,655,310,40);
        t1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        f1.add(t1);
        t1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                l4.setText("Typing...");
                t.stop();
                typing = true;

            }

            @Override
            public void keyReleased(KeyEvent e) {
                typing = false;
                if(!t.isRunning())
                    t.start();

            }
        });


        b1 = new JButton("Send");
        b1.setBounds(320,655,123,40);
        b1.setBackground(new Color(7,94,84));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        b1.addActionListener(this);
        f1.add(b1);
        f1.setLayout(null);
        f1.setSize(450,700);
        f1.setLocation(400,200);

        f1.setUndecorated(true);
        f1.setVisible(true);


    }

    public static void main(String[] args)
    {
        new Server();

        try {
            String msginput ="";
            skt=  new ServerSocket(6001);
            while (true) {
                s = skt.accept();
                din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());

                while (true) { msginput = din.readUTF();
                JPanel p2 = formatLabel(msginput);
                JPanel left = new JPanel(new BorderLayout());
                left.add(p2,BorderLayout.LINE_START);
                vertical.add(left);
                f1.validate();
//            a1.setText(a1.getText() + "\n" + msginput);
//            JPanel p3 = formatLabel(msginput);
            }}


        } catch(Exception e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {   String out = t1.getText();
            dout.writeUTF(out);
//        a1.setText(a1.getText() + "\n\t\t\t"+ out);
        JPanel p2 =  formatLabel(out);
        a1.setLayout(new BorderLayout());
        JPanel right = new JPanel(new BorderLayout());
        right.add(p2,BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));
        a1.add(vertical, BorderLayout.PAGE_START);
//        a1.add(p2);

            t1.setText("");
        } catch (IOException ioException) {
//            ioException.printStackTrace();
        }

    }
    public static JPanel formatLabel(String out) {
        JPanel p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
        JLabel l1 = new JLabel("<html><p style=\"width:150px\">"  + out + "</p></html>");
        l1.setFont(new Font("Tahoma",Font.PLAIN,16));
        l1.setBackground(new Color(37,211,102));
        l1.setOpaque(true);
        l1.setBorder(new EmptyBorder(15,15,15,15));

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf= new SimpleDateFormat("HH:mm:ss");
        JLabel l2 = new JLabel();
        l2.setText(sdf.format(cal.getTime()));

        p3.add(l1);
        p3.add(l2);

        return p3;
    }

}
