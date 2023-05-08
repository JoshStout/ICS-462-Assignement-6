import java.util.Collections;
import java.util.LinkedList;

public class SCAN {
	
	String output = null;
	
	public SCAN(Requester requests) {
		Track[] tracks = requests.getRequests();
		
		// linked list to collect the order to be served
		LinkedList<Track> left = new LinkedList<Track>();
		LinkedList<Track> right = new LinkedList<Track>();
		
		int start = tracks[0].getNumber();
			
		// if less than starting position, put in left linked list
		// else the right linked list
		for(int i = 0; i < tracks.length; i++) {
			if(tracks[i].getNumber() <= start) {
				left.add(tracks[i]);
			}else {
				right.add(tracks[i]);
			}
		}
		
		// add the end of the disk to left
		left.add(new Track(0));
		Collections.sort(left, Collections.reverseOrder());
		
		// add end of disk to start of right
		right.addFirst(left.getLast());
		Collections.sort(right);
		
		int total = 0;
		
		// add the differences between each location going left
		for(int i = 0; i < left.size()-1; i++) {
			total += Math.abs(left.get(i).getNumber() - left.get(i+1).getNumber());
		}
		
		// add the differences between each location going right
		for(int i = 0; i < right.size()-1; i++) {
			total += Math.abs(right.get(i).getNumber() - right.get(i+1).getNumber());
		}
		
		output = "For SCAN, the total head movement was " + total + " cylinders.\n";
	}
	
	public String getOutput() {
		return output;
	}

}
