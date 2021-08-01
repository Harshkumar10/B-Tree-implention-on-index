package oui;

import java.awt.*;
import javax.swing.*;

public class HomePanel extends JPanel {
        public HomePanel(JTabbedPane tabPane) {
                tabPane.addTab("Home", this);// adding this to the tabpane
                loadComponets();
        }

        private JTextArea jTextArea;

        private void loadComponets() {
                this.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, Color.darkGray));
                this.setBackground(new Color(0, 100, 0));

                jTextArea = new JTextArea();
                jTextArea.setFont(new Font("Arial", 0, 20));
                jTextArea.setForeground(new Color(100, 0, 45));
                jTextArea.setColumns(60);
                jTextArea.setRows(5);
                jTextArea.setText(
                                "This project basically creates the random data and on index on it using B Tree data structure. Hence shows better performance of Index Seek over Table scan method.");
                jTextArea.setLineWrap(true);
                jTextArea.setEditable(false);

                this.add(jTextArea);
        }
}
