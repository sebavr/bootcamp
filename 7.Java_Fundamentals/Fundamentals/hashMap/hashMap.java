package hashMap;
import java.util.HashMap;
public class hashMap {
	
	// Import the HashMap class
	
	  public static void main(String[] args) {
	    // Create a HashMap object called capitalCities
	    HashMap<String, String> trackList = new HashMap<String, String>();

	    
	    trackList.put("Ricochet-Faith no More", "All of that thick time without you");
	    trackList.put("Ashes to Ashes-Faith no More","Do you remember a guy that's been");
	    trackList.put("Sultan of Swing-Dire Straits","You get a shiver in the dark");
	    trackList.put("Do the Evolution-Pearl Jam","It's evolution baby");
	    
	    
	    for (String i : trackList.keySet()) {
	        System.out.println("Track: " + i + "--- Lyrics: " + trackList.get(i));
	      }
	  }
	

}
