package coinmachine;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class coinObserverUI implements Observer{

	private JFrame frame;
	private JTextField textField;
	private JLabel status;
	/**
	 * Create the application.
	 */
	public coinObserverUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 236, 102);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel coinLabel = new JLabel("#Coin:");
		coinLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		frame.getContentPane().add(coinLabel);
		
		textField = new JTextField();
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		status = new JLabel("Accepting");
		status.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		frame.getContentPane().add(status);
		
		frame.setVisible(true);
	}
	
	@Override
	public void update(Observable subject, Object info) {
		textField.setText(((CoinMachine)info).getCount()+"");
		if(((CoinMachine)info).getCount()>=((CoinMachine)info).getCapacity()){
			status.setText("full");
		}
		
	}


}
