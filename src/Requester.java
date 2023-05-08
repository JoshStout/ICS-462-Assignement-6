/*
 * Class to convert the data from the data file
 * to a collection of objects.
 */

public class Requester {
	private int cylinders;
	private int start;
	private Track[] requests;
	
	public Requester(int cylinders, int start, String requestsStr) {
		this.cylinders = cylinders;
		this.start = start;
		this.requests = convertRequests(requestsStr);
	}
	
	// convert the String of requests into an array of Track instances
	private Track[] convertRequests(String requests) {
		String[] strRequests = requests.split(" ");
		Track trackRequests[] = new Track[strRequests.length+1];
		trackRequests[0] = new Track(start);
		trackRequests[0].setVisited(true);
		for(int i = 0; i < strRequests.length; i++) {
			trackRequests[i+1] = new Track(Integer.parseInt(strRequests[i]));
			strRequests[i] = null; // for garbage collection
		}
		return trackRequests;
	}
	
	// getter to access the cylinders
	public int getCylinders() {
		return cylinders;
	}
	
	public Track[] getRequests() {
		return requests;
	}
	
}
