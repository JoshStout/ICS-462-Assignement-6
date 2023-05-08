import java.util.Collections;
import java.util.LinkedList;

public class CSCAN {
	
	String output = null;
	
	public CSCAN(Requester requests) {
		Track[] tracks = requests.getRequests();
		
		// linked list to collect the order to be served
		LinkedList<Track> left = new LinkedList<Track>();
		LinkedList<Track> right = new LinkedList<Track>();
		
		int start = tracks[0].getNumber();
			
		// if less than starting position, put in left linked list
		// else the right linked list
		for(int i = 0; i < tracks.length; i++) {
			if(tracks[i].getNumber() >= start) {
				right.add(tracks[i]);
			}else {
				left.add(tracks[i]);
			}
		}
		
		
		// add the end of the disk to left
		left.add(new Track(0));
		Collections.sort(left);
		
		// add end of disk to start of right
		right.add(new Track(requests.getCylinders()));
		Collections.sort(right);
		
		int total = 0;
		
		// add the differences between each location going right from starting location to end of disk
		for(int i = 0; i < right.size()-1; i++) {
			total += Math.abs(right.get(i).getNumber() - right.get(i+1).getNumber());
		}
		
		total += requests.getCylinders();
		
		// add the differences between each location going left from beginning of disk
		for(int i = 0; i < left.size()-1; i++) {
			total += Math.abs(left.get(i).getNumber() - left.get(i+1).getNumber());
		}
		
		output = "For CSCAN, the total head movement was " + total + " cylinders.\n";
	}
	
	public String getOutput() {
		return output;
	}

}
