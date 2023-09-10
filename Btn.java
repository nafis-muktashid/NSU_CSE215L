import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Btn extends JButton {
	private JTextField txtField;
	Btn(){
		
	}
	Btn(JTextField txt, String title){
		super (title) ;
		this.txtField = txt ;
		this.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e){
        		click () ;
        	}
		});
	}
	public void click() {
		String in = this.txtField.getText();
        in += this.getText() ;
        this.txtField.setText(in); 
	}
}
