import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//process input
		Distribution d = new Distribution();
		
		String line;
		
		Scanner s = new Scanner(System.in);
		
		while((line = s.nextLine()) != null){
			Scanner linescanner = new Scanner(line);
			try{
				d.add(linescanner.next(), linescanner.nextInt());
			}catch(NoSuchElementException e){
				break;
			}
			linescanner.close();
		}
		
		s.close();
		
		d.solve();
	}

}
