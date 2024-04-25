
package guiExampleCode;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class IntermediateFrame extends JFrame{

    public IntermediateFrame() {

        JPanel mainPnl, topPnl, centerPnl,bottomPnl;
        JLabel titleLbl = new JLabel("My Swing Sampler");
        TextArea textArea = new TextArea(15,30);
        JScrollPane scroller = new JScrollPane(textArea);

        setTitle("Test JFrame");
        mainPnl = new JPanel();
        topPnl = new JPanel();
        centerPnl = new JPanel();
        bottomPnl = new JPanel();

        JButton quitBtn = new JButton("Quit");
        JButton colorChangeBtn = new JButton("Change Color");
        JButton itemAddBtn = new JButton("Add Item");


        quitBtn.addActionListener(e ->{
            System.exit(0);
        });
        //Change color button actions --> lambda expression
        colorChangeBtn.addActionListener(e -> {
                    int r,g,b = 0;
                    Random rnd = new Random();
                    r = rnd.nextInt(256);
                    g = rnd.nextInt(256);
                    b = rnd.nextInt(256);
                    centerPnl.setBackground(new Color(r,g,b));
                }
        );

        itemAddBtn.addActionListener(e ->{
            String newItem;

            newItem =JOptionPane.showInputDialog(mainPnl, "Item:","Enter a New Item",JOptionPane.QUESTION_MESSAGE);

            if(newItem.length()>0)
            {
                textArea.append(newItem + "\n");
            }
        });


        add(mainPnl);

        mainPnl.setLayout(new BorderLayout());

        mainPnl.add(topPnl,BorderLayout.NORTH);
        topPnl.add(titleLbl);

        mainPnl.add(centerPnl,BorderLayout.CENTER);
        centerPnl.add(scroller);

        mainPnl.add(bottomPnl, BorderLayout.SOUTH);


        //Order matters with GridLayout
        bottomPnl.setLayout(new GridLayout(1,4));
        bottomPnl.add(colorChangeBtn);
        bottomPnl.add(itemAddBtn);
        bottomPnl.add(quitBtn);

        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
