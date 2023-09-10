import java.awt.event.ActionEvent;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class BtunOperator extends JButton{
	private JFrame calc;
	BtunOperator() {
		
	}
	BtunOperator(JFrame jtf, String s){
		super(s);
		this.calc = jtf;
		this.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e){
        		click () ;
        	}
		});
	}
	public void click() {
		
		if(this.calc=="") {
			
		}
	}
}
