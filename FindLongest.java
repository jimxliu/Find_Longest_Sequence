import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindLongest {
	
	public static void main(String[] args){
		String maxName = null; // Name of the longest sequence
		String maxSeq = null; // Longest sequence
		String curSeq = ""; // Currently being iterated sequence
		String curName = ""; //  Name of the current sequence
		int max = 0; // Length of Longest sequence
		Scanner sc = null; 

		try{
			sc = new Scanner(new File(args[0]));		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			if(line.charAt(0) == '>'){				
				if(curSeq.length() > max){
					maxName = curName;
					maxSeq = curSeq;
					max = curSeq.length();
				}			
				curName = line; // reset the current sequence name 
				curSeq = "";  // reset the current sequence to ""
		 	} else {
				curSeq += line; // Add more nucleotides to the current sequence. Just in case the sequence is split into multiple lines.
			}
		}
		if(curSeq.length() > max){
			maxName = curName;
			maxSeq = curSeq;
			max = curSeq.length();
		}		
			
		if(args.length == 1){  // standard output to console
			System.out.println(maxName);
			System.out.println("Length: "+max);
			System.out.println(maxSeq);
		} 
		if(args.length == 2){  // output to file
			try{
				PrintWriter output = new PrintWriter(args[1]);
				output.println(maxName + "\n" + maxSeq);
				output.flush();
				output.close();
			} catch(Exception ex){
				ex.printStackTrace();
			}
		}
				
	}		

}
