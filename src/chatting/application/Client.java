package chatting.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client extends JFrame implements ActionListener {
        JPanel p1;
        JTextField t1;
        JButton b1;
       static  JTextArea a1;
        static Socket s;
        static DataInputStream din;
        static DataOutputStream dout;
        Client() {
            p1 =  new JPanel();
            p1.setLayout(null);
            p1.setBackground(new Color(7,94,84));
            p1.setBounds(0,0,450,70);
            add(p1);
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

            ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/2.png"));
            Image i5 = i4.getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT);
            ImageIcon i6 =  new ImageIcon(i5);
            JLabel l2 = new JLabel(i6);
            l2.setBounds(40,5,60,60);
            p1.add(l2);

            JLabel l3 = new JLabel("Jashan");
            l3.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            l3.setForeground(Color.WHITE);
            l3.setBounds(110,15,100,20);
            p1.add(l3);

            JLabel l4 = new JLabel("Active Now");
            l4.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
            l4.setForeground(Color.WHITE);
            l4.setBounds(110,35,100,15);
            p1.add(l4);


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


            a1 =  new JTextArea();
            a1.setBounds(5,75,440,570);
//        a1.setBackground(Color.PINK);
            a1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
            a1.setEditable(false);
            a1.setLineWrap(true);
            a1.setWrapStyleWord(true);
//        a1.setAlignmentX(40);
            add(a1);
            t1 = new JTextField();
            t1.setBounds(5,655,310,40);
            t1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
            add(t1);

            b1 = new JButton("Send");
            b1.setBounds(320,655,123,40);
            b1.setBackground(new Color(7,94,84));
            b1.setForeground(Color.WHITE);
            b1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
            b1.addActionListener(this);
            add(b1);
            setLayout(null);
            setSize(450,700);
            setLocation(1100,200);

            setUndecorated(true);
            setVisible(true);


        }

        public static void main(String[] args)
        {
            new Client() .setVisible(true);
            try {
                    s= new Socket("127.0.0.1",6001);
                    din = new DataInputStream(s.getInputStream());
                    dout = new DataOutputStream(s.getOutputStream());
                    String msginput = "";
                    msginput = din.readUTF();
                    a1.setText(a1.getText() + "\n" + msginput);
            }catch(Exception e) {

            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {   String out = t1.getText();
            a1.setText(a1.getText() + "\n\t\t\t"+ out);

                dout.writeUTF(out);
            } catch(Exception a) {

            }
            t1.setText("");
        }
    }


