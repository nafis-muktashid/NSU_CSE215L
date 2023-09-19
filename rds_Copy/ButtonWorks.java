import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ButtonWorks implements ActionListener{
	private JComboBox<String> cBox;
	private DefaultTableModel tbl;
	
	public ButtonWorks(JComboBox<String> c, DefaultTableModel t) {
		this.tbl = t;
		this.cBox = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedCourse = cBox.getSelectedItem().toString();
		tbl.addRow(new Object[] {selectedCourse});
	}
}