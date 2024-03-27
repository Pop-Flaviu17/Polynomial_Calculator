package ro.tuc.dsrl.example1;
import ro.tuc.dsrl.appLogic.Logic;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * Clasa de UI care contine atat definitia elementelor grafice
 * cat si definitia Listenerilor si tratarea lor intr-o singura metoda
 * 
 * echivalent View + controller (in metoda action performed)
 * 
 *
 */

public class Example1 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pane = new JPanel(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	private JButton button = new JButton("OK");
	private JTextField text = new JTextField(20);
	private JLabel label = new JLabel("result");
	
	private Logic logic = new Logic();

	public Example1(String name) {
		super(name);
		c.gridx = 1;
		c.gridy = 0;
		pane.add(button, c);
		button.addActionListener(this);

		c.gridx = 0;
		c.gridy = 0;
		pane.add(text, c);

		c.gridx = 0;
		c.gridy = 1;
		pane.add(label, c);
		
		this.add(pane);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object source = arg0.getSource();
		if(source == button){
			String s = text.getText();
			label.setText(logic.operation(s));
		}

	}

	public static void main(String args[]) {
		JFrame frame = new Example1("GridBagLayoutDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
