package cz.uhk.gui;

import cz.uhk.models.ShoppingItem;
import cz.uhk.models.ShoppingList;
import cz.uhk.models.TableModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private ShoppingList shoppingList;

    private TableModel tableModel;

    public MainFrame(int width, int height){
        super("Hlavní okno");
        setSize(width,height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        shoppingList = new ShoppingList();
        seedShoppingList();

        initMenu();
        initGui(); //volat před setVisible(true)
        setVisible(true);
    }

    private void initMenu(){
        JMenuBar bar = new JMenuBar();
        JMenu menu1 = new JMenu("seznam");
        bar.add(menu1);

        JMenuItem menuNewItem = new JMenuItem("Položka 1");
        menuNewItem.addActionListener(e -> {
            System.out.println("clicked new item");
            NewItemDialog dialog = new NewItemDialog(this);
        });
        menu1.add(menuNewItem);

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
        button1.addActionListener(e -> JOptionPane.showMessageDialog(null, "zpráva", "info", JOptionPane.INFORMATION_MESSAGE));
        panelNorth.add(button1);
        return panelNorth;
    }

    private JPanel initCenterPanel(){
        JPanel panelCenter = new JPanel();
        /*Object[][] data = new Object[][]{
                {"0,1", "0,1", "0,2"},
                {"1,0", "1,1", "1,2"},
                {"2,0", "2,1", "2,2"}
        };
        String[] colNames = new String[] {"Col1", "Col2", "Col3"};

        JTable table = new JTable(data, colNames);*/

        tableModel = new TableModel(shoppingList);

        JTable table = new JTable();
        table.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        panelCenter.add(scrollPane);

        return panelCenter;
    }

    public void addNewItem(){
        System.out.println("Nová položka");
    }


    private void seedShoppingList(){
        shoppingList.getItems().add(new ShoppingItem("Máslo", 53, 2));
        shoppingList.getItems().add(new ShoppingItem("Chléb", 30, 1));
        shoppingList.getItems().add(new ShoppingItem("Pomazánka", 25, 3));
        shoppingList.getItems().add(new ShoppingItem("Šunka", 31, 1));
        shoppingList.getItems().add(new ShoppingItem("Sýr", 29, 1));

    }
}
