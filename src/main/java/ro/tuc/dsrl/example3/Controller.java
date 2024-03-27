package ro.tuc.dsrl.example3;
import ro.tuc.dsrl.appLogic.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
	
	private View view;
	
	private Logic logic = new Logic();
	
	public Controller(View v){
		this.view = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == view.getButton()){
			String s = view.getText().getText();
			view.getLabel().setText(logic.operation(s));
		}
		
	}

}
