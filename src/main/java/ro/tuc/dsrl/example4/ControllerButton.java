package ro.tuc.dsrl.example4;

import ro.tuc.dsrl.appLogic.Logic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerButton implements ActionListener{
	
	private View view;
	
	private Logic logic = new Logic();
	
	public ControllerButton(View v){
		this.view = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String s = view.getText().getText();
		view.getLabel().setText(logic.operation(s));
		
		
	}

}
