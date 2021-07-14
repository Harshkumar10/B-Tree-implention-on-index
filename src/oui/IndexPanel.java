package oui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class IndexPanel extends JPanel implements ActionListener {
	private JLabel lblRows;
	private JComboBox comboIndices;
	private JButton btnCreate;
	private JProgressBar progressBar;

	public IndexPanel(JTabbedPane tabPane) {
		tabPane.addTab("Indices", this);
		initComponents();
	}

	private void initComponents() {
		this.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, Color.darkGray));
		this.setBackground(new Color(0, 100, 0));

		lblRows = new JLabel();
		lblRows.setFont(new Font("Monospaced", 0, 50));
		lblRows.setForeground(new Color(255, 255, 255));
		lblRows.setText("Column:");

		comboIndices = new JComboBox(new String[] { "Select One", "Name", "UserName", "Password" });
		comboIndices.setFont(new Font("Monospaced", 0, 35));

		btnCreate = new JButton();
		btnCreate.setFont(new Font("Monospaced", 0, 22));
		btnCreate.setText("Create Index");
		btnCreate.addActionListener(this);// observer design pattern

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setFont(new Font("Monospaced", 0, 50));

		// this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(lblRows);
		this.add(comboIndices);
		this.add(btnCreate);
		this.add(progressBar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IndexPanel obj = this;
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					if (comboIndices.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(obj, "Please select a column within drop down");
						return;
					}
					DataManager.CreateIndex(comboIndices.getSelectedItem().toString(), obj);
					JOptionPane.showMessageDialog(obj, "Index created successfully");
					progressBar.setValue(0);
				} catch (Exception ex) {
				}
			}
		});
		t.start();
	}

	public void updateStatus(int percent) {
		progressBar.setValue(percent);
	}
}
