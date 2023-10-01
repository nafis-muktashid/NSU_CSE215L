
public class Quiz {
	private int id;
	private double mark;
	
	Quiz(){
		
	}
	Quiz(int i, double d){
		this.id = i; this.mark = d;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	
	@Override
	public String toString() {
		return "ID: "+this.id+" \tmark:"+this.mark;
	}
}
