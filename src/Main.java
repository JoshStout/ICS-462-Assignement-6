import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//PrinterWriter & I/O File code copied from ICS-340 InitialCodebase 
		//by Metropolitan State University Professor Michael Stein
		File outputFile;
		PrintWriter output = null;
		
		outputFile = new File( "output.txt" );
		if ( outputFile.exists() ) {
			outputFile.delete();
		}
		
		try {
			output = new PrintWriter(outputFile);			
		}
		catch (Exception x ) { 
			System.err.format("Exception: %s%n", x);
			System.exit(0);
		}
		
		
		// read data file
		try {
			File myFile = new File("Asg6 Data.txt");
			Scanner scanner = new Scanner(myFile);
			
			// get first set of data
			int cylinders = Integer.parseInt(scanner.nextLine());
			int start = Integer.parseInt(scanner.nextLine());
			String requests = scanner.nextLine();		
			
			Requester r = new Requester(cylinders, start, requests);
			
			// output the results of each disk scheduling algorithms 
			FCFS fcfs = new FCFS(r);
			System.out.println(fcfs.getOutput());
			output.print(fcfs.getOutput());
			
			SSTF sstf = new SSTF(r);
			System.out.println(sstf.getOutput());
			output.print(sstf.getOutput());
			
			SCAN scan = new SCAN(r);
			System.out.println(scan.getOutput());
			output.print(scan.getOutput());
			
			CSCAN cscan = new CSCAN(r);
			System.out.println(cscan.getOutput());
			output.print(cscan.getOutput());
			
			LOOK look = new LOOK(r);
			System.out.println(look.getOutput());
			output.print(look.getOutput());
			
			CLOOK clook = new CLOOK(r);
			System.out.println(clook.getOutput());
			output.print(clook.getOutput());
			
			System.out.println("\n");
			output.print("\n\n");
			
			// get next set of data
			cylinders = Integer.parseInt(scanner.nextLine());
			start = Integer.parseInt(scanner.nextLine());
			requests = scanner.nextLine();
			
			r = new Requester(cylinders, start, requests);
			
			// output the results of each disk scheduling algorithms 
			fcfs = new FCFS(r);
			System.out.println(fcfs.getOutput());
			output.print(fcfs.getOutput());
			
			sstf = new SSTF(r);
			System.out.println(sstf.getOutput());
			output.print(sstf.getOutput());
			
			scan = new SCAN(r);
			System.out.println(scan.getOutput());
			output.print(scan.getOutput());
			
			cscan = new CSCAN(r);
			System.out.println(cscan.getOutput());
			output.print(cscan.getOutput());
			
			look = new LOOK(r);
			System.out.println(look.getOutput());
			output.print(look.getOutput());
			
			clook = new CLOOK(r);
			System.out.println(clook.getOutput());
			output.print(clook.getOutput());
			
			output.flush();
			scanner.close();
			
			
		}catch(FileNotFoundException e) {
//			System.out.println("An error occurred.");
//			e.printStackTrace();
		}
		

	}

}
