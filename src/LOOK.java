import java.util.Collections;
import java.util.LinkedList;

public class LOOK {
	
	String output = null;
	
	public LOOK(Requester requests) {
		Track[] tracks = requests.getRequests();
		
		// linked list to collect the order to be served
		LinkedList<Track> left = new LinkedList<Track>();
		LinkedList<Track> right = new LinkedList<Track>();
		
		int start = tracks[0].getNumber();
			
		// if greater than starting position, put in right linked list
		// else put in left linked list
		for(int i = 0; i < tracks.length; i++) {
			if(tracks[i].getNumber() > start) {
				right.add(tracks[i]);
			}else {
				left.add(tracks[i]);
			}
		}
		
		// sort right linked list in reverse order
		Collections.sort(right, Collections.reverseOrder());
		
		// sort left linked list in order
		Collections.sort(left);
		
		int total = 0;
		
		// add the differences between each location going right from starting location
		for(int i = 0; i < right.size()-1; i++) {
			total += Math.abs(right.get(i).getNumber() - right.get(i+1).getNumber());
		}
		
		total += right.getLast().getNumber() - left.getFirst().getNumber();
		
		// add the differences between each location going right from last position on right
		for(int i = 0; i < left.size()-1; i++) {
			total += Math.abs(left.get(i).getNumber() - left.get(i+1).getNumber());
		}
		
		output = "For LOOK, the total head movement was " + total + " cylinders.\n";
	}
	
	public String getOutput() {
		return output;
	}

}
