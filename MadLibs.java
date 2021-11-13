//Morgan Kramer
//MadLibs
//This program views and repeats madlib files, and creates madlibs based
//on files by prompting the user for input marked by carrots <>
import java.util.*;
import java.io.*;

public class MadLibs {
   public static void main(String[] args) throws FileNotFoundException {
      boolean play = true;
      Scanner console = new Scanner(System.in);
      System.out.println("Welcome to the game of MadLibs.");
		System.out.println("I will ask you to provide various words ");
		System.out.println("and phrases to fill a story.");
		System.out.println("The result will be written to an output file.");
      
      //This while loop will call the "menu" method while it is true
      while(play == true){
         play = menu(console);
     
//      while (input.hasNext()) {
//         String token = input.next();
//         if(token
     
     }
   
   }
   
//Asks the user if they want to create, view, or quit. If they quit,
//it returns falls, ending the main while loop.
   public static boolean menu(Scanner console) throws FileNotFoundException {
      System.out.println("(C)reate mad-lib, (V)iew mad-lib, (Q)uit?");
      String answer = console.next();
//the || will allow the user to input a lowercase or uppercase character 
      if(answer.charAt(0) == 'c' || answer.charAt(0) == 'C'){
         create(console);
         return true;
      }
      
      if(answer.charAt(0) == 'q' || answer.charAt(0) == 'Q'){
         return false;
      }
      
      if(answer.charAt(0) == 'v' || answer.charAt(0) == 'V'){
         view(console);
         return true;
      }
      
      else{
         System.out.println("Thats not an answer I like very much so try again!");
         return true;
      }
   }
   
   public static void create(Scanner console) throws FileNotFoundException {
      System.out.println("Input file name: ");
		String nameIn = console.next();
		File f1 = new File(nameIn);
		while(!f1.exists()){
			System.out.println("File not found. Try again: ");
			nameIn = console.next();
			//f1 = new File(nameIn);
		}
		System.out.println("Output file name: ");
		String nameOut = console.next();
		File out = new File(nameOut);
		PrintStream output = new PrintStream(out);
		
		Scanner input = new Scanner(f1);
		
		while(input.hasNextLine()){
			String text = input.next();
			
			//System.out.print(text);
			//processLine(console, f1, nameOut);
			if(text.startsWith("<") && text.endsWith(">")){
				//String x = input.next();
				char a = text.charAt(1);
				String anora = aOrAn(a);
				text = text.replace('<', ' ');
				text = text.replace('>', ' ');
				text = text.replace('-', ' ');
				System.out.println("Please type" + anora + text);
				String in = console.next();
				output.print(" " + in + " ");
			}
			else{
				output.print(" " + text + " ");
         }
      }
   }
   
   
//Asks the user to input a file, checks if it exists, and returns it as a file
      public static File input(Scanner console) {
         System.out.println("Enter a file to view");
         File input = new File(console.next());
         while(!input.canRead()) {
            System.out.print("File not found");
            input = new File(console.nextLine());
            }
         return input;
         }
         
         public static void view(Scanner console) throws FileNotFoundException{
            File input = input(console);
            Scanner view = new Scanner(input);
            System.out.println();
            while (view.hasNextLine()) {
               System.out.println(view.nextLine());
            }
            System.out.println();
         }

   public static String aOrAn(char check){
		String a;
		if(check == 'a' || check == 'A' || check == 'i' || check == 'I' 
			|| check == 'i' || check == 'e' || check == 'E' ||
			check == 'o' || check == 'O' || check == 'u' || check == 'U'){
			a = " an";
		}
		else{
			a = " a";
		}
		return a;
	 }
   public static void processLine(Scanner console, File inName, String outName)
	throws FileNotFoundException{
		Scanner madL = new Scanner(new File(inName.getPath()));
		//int length = madL.next().length();
		PrintStream output = new PrintStream(new File(outName));
		String tx = madL.next();
		System.out.println(tx);
		
		if(madL.nextLine().startsWith("<") && madL.nextLine().endsWith(">")){
			String x = madL.next();
			char a = x.charAt(1);
			String anora = aOrAn(a);
			x.replace('<', ' ');
			x.replace('>', ' ');
			x.replace('-', ' ');
			System.out.println("Please type" + anora + x);
			String in = console.nextLine();
			output.print(" " + in + " ");
			
		}
		else{
			String y = madL.next();
			output.print(" " + y + " ");
		}
		
	}
       
   
   
   
   
   
   }
