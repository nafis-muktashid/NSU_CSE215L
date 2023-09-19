import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class UI extends JFrame{
	public static void main(String[] args) {
		JFrame frame = new JFrame("RDS");
		frame.setSize(450, 600);
		frame.setLocationRelativeTo(null);
		
		JTextField txtFld = new JTextField();
		txtFld.setBounds(65, 5, 365, 20);
		frame.add(txtFld);
		
		JLabel id = new JLabel("ID");
		id.setBounds(5, 5, 50, 20);
		frame.add(id);
		
		JLabel courses = new JLabel("Courses");
		courses.setBounds(5, 45, 50, 20);
		frame.add(courses);
		
		//Drop-down box
		String courses1[]= {"1. CSE115 Introduction to C... 3.0", "2. CSE173 Discrete Mathematics 3.0", "3. CSE215 Introduction to Java... 3.0"};
		JComboBox<String> cb = new JComboBox<String>(courses1);
		cb.setBounds(65, 45, 280, 20);
		frame.add(cb);
		
		JButton add = new JButton("ADD");
		add.setFocusable(false);
		add.setBounds(355, 45, 75, 20);
		frame.add(add);
		
		//Table for selected Course
		DefaultTableModel slctTable = new DefaultTableModel(new Object[][] {}, new String[] {"SL","Courses", "Name", "Credit"});
		slctTable.addRow(new Object[] {"SL", "Course", "Name", "Credit"});
		JTable table = new JTable(slctTable);
		table.setBounds(5, 100, 425, 400);
		table.getColumnModel().getColumn(0).setPreferredWidth(1);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		frame.add(table);
		
		JButton save = new JButton("SAVE");
		save.setFocusable(false);
		save.setBounds(185, 505, 75, 20);
		frame.add(save);
		
		ButtonWorks btadd = new ButtonWorks(cb, slctTable);
		add.addActionListener(btadd);
		
		
		frame.setLayout(null);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
	}

}
