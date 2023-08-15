package songproblem_code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SongStore {
    private int capacity;
    private Map<User, LinkedList<Song>> recentlyPlayed;
    
    public SongStore(int capacity) {
        this.capacity = capacity;
        this.recentlyPlayed = new HashMap<User, LinkedList<Song>>();
    }
 // Method to play a song for a user
    public void playSong(User user, Song song) {
 // Add the song to the user's recently played list
        recentlyPlayed.computeIfAbsent(user, k -> new LinkedList<>()).addFirst(song);
        
 // If the list size exceeds the capacity, remove the least recently played song
        if (recentlyPlayed.get(user).size() > capacity) {
            recentlyPlayed.get(user).removeLast();
        }
    }
 // Method to get the list of recently played songs for a user
    public List<Song> getRecentlyPlayed(User user) {
        return recentlyPlayed.getOrDefault(user, new LinkedList<>());
    }
}