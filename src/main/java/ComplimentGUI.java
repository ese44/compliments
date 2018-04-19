import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComplimentGUI extends JFrame{
    private JPanel mainPanel;
    private JLabel complimentText;
    private JButton getCompliment;

    ComplimentGUI(){ // ComplimentGUI object constructor
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(400, 150));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        getCompliment.addActionListener(new ActionListener() { // ActionListener for when the compliment button is clicked
            public void actionPerformed(ActionEvent e) {
                complimentText.setText("Thinking of a compliment...");
                ComplimentClient.getCompliment(ComplimentGUI.this); // get the compliment from the ComplimentClient object
            }
        });
    }

    public void complimentMessage(String compliment) { // method for displaying the compliment
        complimentText.setText(compliment); // display the compliment in the complimnetText JLabel
    }
}
