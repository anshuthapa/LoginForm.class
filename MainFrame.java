import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame{
    public void initialize(User user){
        JPanel infoPanel = new Jpanel();
        infoPanel.setLayout(new GridLayout(0,2,5,5));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(30,50,30,50));
        infoPanel.add(new Jpanel("Name"));
        infoPanel.add(new Jpanel(user.name));
        infoPanel.add(new Jpanel("Email"));
        infoPanel.add(new Jpanel("user.email"));
        infoPanel.add(new Jpanel("Phone"));
        infoPanel.add(new Jpanel("user.phone"));

        Components[] labels = infopanel.gerComponents();
        for(int i=0;i<labels.length;i++)
        {
            labels[i].setFont(new font("Segoe print", Font.BOLD,12));
        }

        add(infoPanel,BorderLayout.NORTH);

        setTitle("Dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100,650);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}