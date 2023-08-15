package songproblem_code;

public class BaseCode {
    public static void main(String[] args) {
        SongStore store = new SongStore(3);
        
        User user = new User("joshwan");
        Song song1 = new Song("S1");
        Song song2 = new Song("S2");
        Song song3 = new Song("S3");
        Song song4 = new Song("S4");
        
        store.playSong(user, song1);
        store.playSong(user, song2);
        store.playSong(user, song3);
        System.out.println(store.getRecentlyPlayed(user));
        
        store.playSong(user, song4);
        System.out.println(store.getRecentlyPlayed(user)); 

}
    }