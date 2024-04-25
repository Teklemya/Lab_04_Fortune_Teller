package FortuneTeller;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {


    int pastValue = -1;
    int index = -2;
    Random rnd = new Random();
    String[] fortunesList = {
            "You will discover a hidden talent within yourself.",
            "A pleasant surprise awaits you at work or school.",
            "Unexpected visitors will bring you good news.",
            "A long-lost friend will reconnect with you soon.",
            "Opportunities for adventure will present themselves this week.",
            "You will receive a gift that brings you joy.",
            "A problem that has been bothering you will soon be resolved.",
            "Someone will express their appreciation for your kindness.",
            "You will make a new friend who shares your interests.",
            "An exciting journey awaits you in the near future.",
            "A small gesture of kindness will have a big impact on someone's life.",
            "You will find inspiration in unexpected places.",
            "A creative project you've been working on will be successful.",
            "You will receive recognition for your hard work and dedication.",
            "A lucky streak is coming your way."};

    public FortuneTellerFrame(){

        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel mainPnl, titlePnl, fortunePnl,cmdPnl;
        ImageIcon fortuneImg = new ImageIcon(System.getProperty("user.dir") + "/src/FortuneTeller/FortuneTellerPic.jpg");

        //JLabel titleLbl = new JLabel("Fortune Teller", fortuneImg,SwingConstants.CENTER);

        JLabel titleLbl = new JLabel();
        titleLbl.setFont(new Font("Impact", Font.BOLD, 48));
        titleLbl.setIcon(fortuneImg);
        titleLbl.setText("Fortune Teller!");
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);

        TextArea textArea = new TextArea(15,70);
        textArea.setEditable(false);
        JScrollPane scroller = new JScrollPane(textArea);

        setTitle("Fortune Teller Program");
        mainPnl = new JPanel();
        titlePnl = new JPanel();
        fortunePnl = new JPanel();
        cmdPnl = new JPanel();

        add(mainPnl);

        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(titlePnl,BorderLayout.NORTH);
        mainPnl.add(fortunePnl,BorderLayout.CENTER);
        mainPnl.add(cmdPnl,BorderLayout.SOUTH);

        Color bgColor = new Color(165, 207, 206);
        Color btnColor = new Color(255, 145, 0);
        titlePnl.setBackground(bgColor);
        //Title Panel Info
        titlePnl.add(titleLbl);

        fortunePnl.add(scroller);
        fortunePnl.setBackground(bgColor);
        textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));


        //CMD Panel Info
        JButton fortuneBtn = new JButton("Read My Fortune!");
        JButton quitBtn = new JButton("Quit");

        quitBtn.addActionListener(e -> {
            System.exit(0);
        });
        fortuneBtn.addActionListener(e -> {
            do {
                index = rnd.nextInt(15);
            } while (index < 0);

            do{
                index = rnd.nextInt(15);
            } while (pastValue == index);

            textArea.append(fortunesList[index] + "\n");
            pastValue = index;
        });

        quitBtn.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        fortuneBtn.setFont(new Font("Times New Roman", Font.PLAIN, 19));

        cmdPnl.setLayout(new GridLayout(1,2));
        cmdPnl.add(fortuneBtn);
        cmdPnl.add(quitBtn);

        quitBtn.setOpaque(true);
        fortuneBtn.setOpaque(true);

        quitBtn.setBackground(btnColor);
        fortuneBtn.setBackground(btnColor);
        cmdPnl.setBackground(bgColor);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,(int)(.75*screenSize.width), (int)(.75*screenSize.height));
        setLocationRelativeTo(null);
    }

}