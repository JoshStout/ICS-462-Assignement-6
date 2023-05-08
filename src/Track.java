
public class Track implements Comparable<Track> {
	private int number;
	private boolean visited;
	
	public Track(int number) {
		this.number = number;
		this.visited = false;
	}
	
	public int getNumber() {
		return number;
	}
	
	public boolean getVisited() {
		return visited;
	}
	
	public void setVisited(boolean visit) {
		visited = visit;
	}
	
	@Override
	public int compareTo(Track t) {
		Track obj = (Track) t;
		if(this.getNumber() > obj.getNumber()) {
			return 1;
		}else {
			return -1;
		}
	}

}
