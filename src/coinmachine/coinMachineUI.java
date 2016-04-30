package coinmachine;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class coinMachineUI implements Observer{

	private JFrame frame;
	private JLabel balanceLabel;
	private CoinMachine cm;
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public coinMachineUI(CoinMachine m) {
		initialize();
		cm = m;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(350, 100, 347, 224);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		balanceLabel = new JLabel("Balance: 0");
		balanceLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		balanceLabel.setBounds(35, 16, 110, 40);
		frame.getContentPane().add(balanceLabel);
		
		JLabel statusLabel = new JLabel("Status: ");
		statusLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		statusLabel.setBounds(135, 16, 110, 40);
		frame.getContentPane().add(statusLabel);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(206, 29, 110, 20);
		progressBar.setMaximum(10);
		frame.getContentPane().add(progressBar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Insert Money", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 61, 339, 139);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton oneBath = new JButton("");
		oneBath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cm.insert(new Coin(1));
			}
		});
		oneBath.setIcon(new ImageIcon(coinMachineUI.class.getResource("/images/1baht.png")));
		panel.add(oneBath);
		
		JButton fiveBath = new JButton("");
		fiveBath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cm.insert(new Coin(5));
				
			}
		});
		fiveBath.setIcon(new ImageIcon(coinMachineUI.class.getResource("/images/5baht.png")));
		panel.add(fiveBath);
		
		JButton tenBath = new JButton("");
		tenBath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cm.insert(new Coin(10));
			}
		});
		tenBath.setIcon(new ImageIcon(coinMachineUI.class.getResource("/images/10baht.png")));
		panel.add(tenBath);
		frame.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		progressBar.setValue(((CoinMachine) arg).getCount());
		balanceLabel.setText("Balance: "+((CoinMachine) arg).getBalance());
	}

}
