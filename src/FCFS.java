
public class FCFS {
	
	String output = null;
	
	public FCFS(Requester requests) {
		
		Track[] num = requests.getRequests();
		int total = 0;
		
		// loop thru each request as they are ordered and add the differences
		// between each location
		for(int i = 0; i < requests.getRequests().length-1; i++) {
			total += Math.abs(num[i].getNumber() - num[i+1].getNumber());
		}
		
		output = "For FCFS, the total head movement was " + total + " cylinders.\n";
	}
	
	public String getOutput() {
		return output;
	}
}
