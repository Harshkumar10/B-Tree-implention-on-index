package oui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DataPanel extends JPanel implements ActionListener {
	private JLabel lblRows;
	private JTextField txtRows;
	private JButton btnCreate;
	private JProgressBar progressBar;

	// data panel is the observer
	// jButton is under observation
	public DataPanel() {
		loadCompenents();
	}

	private void loadCompenents() {
		this.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, Color.darkGray));
		this.setBackground(new Color(0, 100, 0));

		lblRows = new JLabel();
		lblRows.setFont(new Font("Monospaced", 0, 50)); // NOI18N
		lblRows.setForeground(new Color(255, 255, 255));
		lblRows.setText("No of Rows:");

		txtRows = new JTextField("");
		txtRows.setColumns(10);
		txtRows.setFont(new Font("Monospaced", 0, 50)); // NOI18N

		btnCreate = new JButton();
		btnCreate.setFont(new Font("Monospaced", 0, 50)); // NOI18N
		btnCreate.setText("Create Test Data");
		btnCreate.addActionListener(this); // on clicking this the code will be fired

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setFont(new Font("Monospaced", 0, 50));

		this.add(lblRows);
		this.add(txtRows);
		this.add(btnCreate);
		this.add(progressBar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DataPanel obj = this;

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int rows = Integer.parseInt(txtRows.getText());
					// passing the obj so that it can change the progressBar value
					DataManager.CreateData(rows, obj);
					JOptionPane.showMessageDialog(obj, "Data created successfully");
					progressBar.setValue(0);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(obj, "Some execption has occured try again" + ex);
					System.out.println("Exception occured in Datapanel:" + ex);
					progressBar.setValue(0);
				}
			}
		});
		t.start();

	}

	public void updateStatus(int percent) {
		progressBar.setValue(percent);
	}
}
