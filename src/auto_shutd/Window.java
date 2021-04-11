package auto_shutd;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame{
	private JTextField tfTime;
	public Window() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(520,300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AUTO SHUT-DOWN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(154, 11, 202, 79);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Set the time");
		lblNewLabel_1.setBounds(126, 104, 73, 14);
		getContentPane().add(lblNewLabel_1);
		
		tfTime = new JTextField();
		tfTime.setBounds(209, 101, 86, 20);
		getContentPane().add(tfTime);
		tfTime.setColumns(10);
		
		JComboBox cbTimeUnit = new JComboBox();
		cbTimeUnit.setModel(new DefaultComboBoxModel(new String[] {"Seconds", "Minutes", "Hours"}));
		cbTimeUnit.setSelectedIndex(1);
		cbTimeUnit.setBounds(305, 101, 95, 22);
		getContentPane().add(cbTimeUnit);
		
		JButton btn = new JButton("Start");
		btn.setBounds(206, 170, 89, 23);
		getContentPane().add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int time = Integer.parseInt(tfTime.getText());
				int unit = cbTimeUnit.getSelectedIndex();
				switch(unit) {
				case 0:
					//already in seconds
					break;
				case 1:
					time=time*60;
					break;
				case 2:
					time=(time*60)*60;
					break;
				}
				try {
					Main.executing(time);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
