package cz.uhk.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame(int width, int height){
        super("Hlavní okno");
        setSize(width,height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initMenu();
        initGui(); //volat před setVisible(true)
        setVisible(true);
    }

    private void initMenu(){
        JMenuBar bar = new JMenuBar();
        JMenu menu1 = new JMenu("Menu 1");
        bar.add(menu1);

        /*for (int i = 0; i < ; i++) {
            menu1.add(new JMenuItem("položka" + i));
        }*/

        JMenuItem polozka1 = new JMenuItem("Položka 1");
        polozka1.addActionListener(e -> {
            System.out.println("kliknuto na položku 1");
        });
        menu1.add(polozka1);
        JMenuItem polozka2 = new JMenuItem("Položka 2");
        polozka2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("kliknuto na položku 2");
            }
        });
        menu1.add(polozka2);

        bar.add(new JMenu("Menu 2"));

        setJMenuBar(bar);
    }

    private void initGui() {
        JPanel panelMain = new JPanel(new BorderLayout());

        panelMain.add(initNorthPanel(), BorderLayout.NORTH);


        panelMain.add(initCenterPanel(), BorderLayout.CENTER);

        panelMain.add(initCenterPanel());

                add(panelMain);
    }

    private JPanel initNorthPanel(){
        JPanel panelNorth = new JPanel(new FlowLayout());
        panelNorth.add(new JLabel("nápis"));
        JTextField input1 = new JTextField(20);
        panelNorth.add(input1);
        JButton button1 = new JButton("Tlačítko");
        button1.addActionListener(e -> System.out.println(input1.getText()));
        panelNorth.add(button1);
        return panelNorth;
    }

    private JPanel initCenterPanel(){
        JPanel panelCenter = new JPanel();
        Object[][] data = new Object[][]{
                {"0,1", "0,1", "0,2"},
                {"1,0", "1,1", "1,2"},
                {"2,0", "2,1", "2,2"}
        };
        String[] colNames = new String[] {"Col1", "Col2", "Col3"};
        panelCenter.add(new JTable(data, colNames);


        return panelCenter;
    }
}
