package rds_cpy;
import java.awt.*;
import javax.swing.*;

public class UI extends JFrame{
	public static void main(String[] args) {
		JFrame frame = new JFrame("RDS");
		frame.setSize(450, 600);
		frame.setLocationRelativeTo(null);
		
		JTextField txtFld = new JTextField();
		txtFld.setBounds(65, 5, 100, 20);
		frame.add(txtFld);
		
		JLabel id = new JLabel("ID");
		id.setBounds(5, 5, 50, 20);
		frame.add(id);
		
		
		
		JLabel courses = new JLabel("Courses");
		courses.setBounds(5, 30, 50, 20);
		frame.add(courses);
		
		String courses1[]= {"CSE115", "CSE215", "CSE173"};
		JComboBox<String> cb = new JComboBox<String>(courses1);
		cb.setBounds(65, 30, 100, 20);
		frame.add(cb);
		
		JButton add = new JButton("ADD");
		add.setFocusable(false);
		add.setBounds(175, 30, 75, 20);
		frame.add(add);
		
		
		
		JTextArea table = new JTextArea();
		table.setBounds(5, 70, 245, 200);
		table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		frame.add(table);
		
		
		JButton save = new JButton("SAVE");
		save.setFocusable(false);
		save.setBounds(90, 275, 75, 20);
		frame.add(save);
		
		
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
	}

}
