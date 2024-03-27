package ro.tuc.dsrl.example4;
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
 * Interfata construita in stil MVC, unde se face cate un controller pentru fiecare
 * element grafic
 *
 */

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pane = new JPanel(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	private JButton button = new JButton("OK");
	private JTextField text = new JTextField(20);
	private JLabel label = new JLabel("result");
	
	ControllerButton controller = new ControllerButton(this);

	public View(String name) {
		super(name);
		c.gridx = 1;
		c.gridy = 0;
		pane.add(button, c);
		button.addActionListener(controller);

		c.gridx = 0;
		c.gridy = 0;
		pane.add(text, c);

		c.gridx = 0;
		c.gridy = 1;
		pane.add(label, c);
		
		this.add(pane);

	}

	public JButton getButton(){
		return button;
	}
	public JTextField getText(){
		return text;
	}
	
	public JLabel getLabel(){
		return label;
	}

	public static void main(String args[]) {
		JFrame frame = new View("GridBagLayoutDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
