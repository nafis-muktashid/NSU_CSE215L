import java.util.HashMap;

public class Mp {
	HashMap<String , Course> m;
	
	public Mp() {
		m = new HashMap<String, Course>();
		m.put("CSE115", new Course("CSE115", "Introduction to Programming I", "3.0"));
		m.put("CSE215", new Course("CSE215", "Introduction to Programming II", "3.0"));
		m.put("CSE173", new Course("CSE173", "Dis", "3.0"));
	}
	
	public Course getKey(String s) {
		return m.get(s);
	}
}
