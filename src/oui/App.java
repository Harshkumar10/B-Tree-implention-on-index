package oui;

import java.awt.*;
import javax.swing.*;

public class App extends JFrame {
	JTabbedPane tabPane;
	// we are calling from the other file
	HomePanel homePanel;
	DataPanel dataPanel;
	IndexPanel indexPanel;
	QueryPanel queryPanel;

	// constructor
	public App() {
		tabPane = new JTabbedPane();
		tabPane.setFont(new Font("Comic Sans MS", 1, 30));
		tabPane.setBackground(Color.DARK_GRAY);
		tabPane.setForeground(Color.WHITE);

		homePanel = new HomePanel(tabPane);
		dataPanel = new DataPanel(tabPane);
		indexPanel = new IndexPanel(tabPane);
		queryPanel = new QueryPanel(tabPane);

		// supper is JFrame
		// we are adding the tabPane in the JFrame
		super.add(tabPane);

		pack();

		super.setTitle("Query index creation");
		super.setExtendedState(MAXIMIZED_BOTH);
		// this is close the JVM on the click the close button
		// JVM plays the Java program
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// this will make the file visible
		super.setVisible(true);
	}
}
