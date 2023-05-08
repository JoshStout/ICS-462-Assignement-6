import java.util.LinkedList;

public class SSTF {
	
	String output = null;
	
	public SSTF(Requester requests) {
		
		Track[] tracks = requests.getRequests();
		
		// linked list to collect the order to be serviced
		LinkedList<Track> list = new LinkedList<Track>();
		
		// starting from the start location
		Track next = getNext(tracks, tracks[0]);
		list.add(next);
		int total = Math.abs(tracks[0].getNumber() - next.getNumber());
		
		// loop thru the tracks calling the getNext method 
		// and adding the next location to service to the linked list
		for(int i = 0; i < tracks.length-2; i++) {
			next = getNext(tracks, next);
			list.add(next);
		}
		
		// loop thru the linked list and adding the differences
		// between each element's location
		for(int i = 0; i < list.size()-1; i++) {
			total += Math.abs(list.get(i).getNumber() - list.get(i+1).getNumber());
		}
		
		output = "For SSTF, the total head movement was " + total + " cylinders.\n";
	}
	
	// method that returns the next closest location 
	public Track getNext(Track[] requests, Track current) {
		int smallestDiff = 100000;
		int index = 0;
		for(int i = 0; i < requests.length; i++) {
			int diff = Math.abs(requests[i].getNumber() - current.getNumber());
			if((!requests[i].getVisited()) && (diff < smallestDiff)){
				smallestDiff = diff;
				index = i;
			}
		}
		requests[index].setVisited(true);
		return requests[index];
	}
	
	public String getOutput() {
		return output;
	}
	
}
