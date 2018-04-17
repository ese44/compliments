import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComplimentGUI extends JFrame{
    private JPanel mainPanel;
    private JLabel complimentText;
    private JButton getCompliment;

    ComplimentGUI(){
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(400, 150));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        getCompliment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String compliment = ComplimentClient.getCompliment();
                complimentText.setText(compliment);
            }
        });
    }
}
