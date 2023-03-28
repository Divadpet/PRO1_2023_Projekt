package cz.uhk.gui;

import javax.swing.*;
import java.awt.*;

public class NewItemDialog extends JDialog {
    private MainFrame parent;

    public NewItemDialog(JFrame parent){
        super(parent, "Zadejte novou položku", true);
        this.parent = parent;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initGui();
        pack(); //nastaví velikost podle obsahu
        setVisible(true);
    }
    private void initGui(){

        JPanel mainPanel = new JPanel(new GridLayout(4,2));
        mainPanel.add(new JLabel("Název"));
        mainPanel.add(new JTextField(15));

        mainPanel.add(new JLabel("Cena"));
        mainPanel.add(new JTextField(15));

        mainPanel.add(new JLabel("Počet"));
        mainPanel.add(new JTextField(15));

        mainPanel.add(new JPanel());//prázdné pro posunutí tlačítka doprava

        JButton btnOK = new JButton("OK");
        mainPanel.add(btnOK);

        btnOK.addActionListener(
                e -> {
                    System.out.println("validacee nové položky OK");
                    parent.addNewItem();
                    dispose();
                }
        );
        add(mainPanel);
    }
}
