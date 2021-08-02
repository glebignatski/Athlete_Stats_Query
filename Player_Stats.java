import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

public class Player_Stats {

	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);
		Desktop d = Desktop.getDesktop();

		String input1 = "";
		String input2 = "";
		String output = "";
		String us = "_";
		String plus = "+";
		int i = 2;
		boolean flag = true;
		String prefsd = "https://en.wikipedia.org/wiki/";
		String tpd = "#Career_statistics";
		
		System.out.println("Check the career statistics of a hockey player by typing in their name.");
		
		while (flag) {
			System.out.println("First name: ");
			input1 = s.nextLine();
			if(input1.equals("done")){
				System.out.println("Bye!");
				break;
			}
			char ch1 = input1.charAt(0);
			if (Character.isLowerCase(ch1)) {
				input1 = input1.substring(0, 1).toUpperCase() + input1.substring(1);
			}
			
			System.out.println("Last name: ");
			input2 = s.nextLine();
			if(input2.equals("done")){
				System.out.println("Bye!");
				break;
			}
			char ch2 = input2.charAt(0);

			if (Character.isLowerCase(ch2)) {
				input2 = input2.substring(0, 1).toUpperCase() + input2.substring(1);
			}

			output = prefsd + input1;
			output = output + (us + input2 + tpd);

			search(d, output, input1, input2);
			System.out.println("----------Player " + i + "----------");
			i++;
		}
		s.close();
	}
	
	public static void search(Desktop d, String output, String input1, String input2){
		try {
			d.browse(new URI(output));
		}

		catch (Exception e) {
			output = "https://www.google.com/search?client=firefox-b-d&q=";
			output = output + input1 + "+" + input2;
			try{
				d.browse(new URI(output));
			}
			catch (Exception e2){
				System.out.println("Something still went wrong! Remember, both the name and last name are needed separately.");
			}
		}
		
	}

}
