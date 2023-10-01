import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Quiz[] arr = new Quiz[5];
		
		for(int i=0; i<4; ++i) {
			int iden = sc.nextInt();
			int mk = sc.nextInt();
			Quiz tmp = new Quiz(iden, mk);
			arr[i] = tmp;
		}
		
		for (int i = 0; i < 4; i++) {
            System.out.println(arr[i].toString());
        }
		
		for(int i=0; i<4; ++i) {
			writeFile(arr[i].toString());
		}
		System.out.println("Contents written successfully.");
		
		double maxMark = -20.0; int maxID=0;
		for(int i=0; i<4; ++i) {
			
		}
		System.out.println("Highest mark obtained by ID: "+maxID);
		
	}
	
	public static void writeFile(String k){
		String ok = k+"\n";
		try {
		  FileWriter fw = new FileWriter("C:\\Users\\LIB 610\\Desktop\\Nafis_2232602642\\File_System\\src\\txt.txt", true);
		   fw.write(ok); 
		   fw.close();  
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	public static void readFile(){
		try {
			FileReader fr = new FileReader("C:\\Users\\LIB 610\\Desktop\\Nafis_2232602642\\File_System\\src\\txt.txt");
 
			
			while((i=fr.read())!=-1){
				System.out.print((char)i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

}
