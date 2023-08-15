package Songproblem_code;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import java.util.*;
import org.testng.annotations.Test;

import songproblem_code.*;

import static org.testng.Assert.*;

import java.util.Arrays;

public class SongsCodeTest extends BaseCode {
    private SongStore store;
    private User user;
    private Song song1, song2, song3, song4;

    @BeforeMethod
    public void setUp() {
        store = new SongStore(3);
        user = new User("Joshwan");
        song1 = new Song("S1");
        song2 = new Song("S2");
        song3 = new Song("S3");
        song4 = new Song("S4");
    }

    @Test
    public void testPlaySongAndFetchRecentlyPlayed() {
        // Playing songs and fetching recently played for a user
        store.playSong(user, song1);
        store.playSong(user, song2);
        store.playSong(user, song3);

        assertEquals(store.getRecentlyPlayed(user), Arrays.asList(song3, song2, song1));
    }

    @Test
    public void testPlayMoreThanCapacity() {
        // Playing more songs than the capacity allows
        store.playSong(user, song1);
        store.playSong(user, song2);
        store.playSong(user, song3);
        store.playSong(user, song4);

        assertEquals(store.getRecentlyPlayed(user), Arrays.asList(song4, song3, song2));
    }

    @Test
    public void testPlayWithoutExceedingCapacity() {
        // Playing songs without exceeding capacity
        store.playSong(user, song1);
        store.playSong(user, song2);

        assertEquals(store.getRecentlyPlayed(user), Arrays.asList(song2, song1));
    }

    @Test
    public void testPlayWithoutUser() {
        // Playing songs for a user and trying to fetch for a different user
        store.playSong(user, song1);
        store.playSong(user, song2);

        User newUser = new User("Joel");
        assertEquals(store.getRecentlyPlayed(newUser), new ArrayList<>());
    }

    @Test
    public void testBoundaryValueCapacity() {
        // Testing capacity boundary value
        User user = new User("joshwanQA");
        Song song1 = new Song("S1");
        Song song2 = new Song("S2");
        Song song3 = new Song("S3");
        Song song4 = new Song("S4");
        
        store.playSong(user, song1);
        store.playSong(user, song2);
        store.playSong(user, song3);
        store.playSong(user, song4);
        assertEquals(store.getRecentlyPlayed(user), List.of(song4, song3, song2));
    }

    @Test
    public void testMultipleUsers() {
        // Playing songs for multiple users
        User Joshwan = new User("JoshwanQA");
        User Joel = new User("JoelQA");
        Song song1 = new Song("S1");
        Song song2 = new Song("S2");
        Song song3 = new Song("S3");
        
        store.playSong(Joshwan, song1);
        store.playSong(Joel, song2);
        store.playSong(Joshwan, song3);
        
        assertEquals(store.getRecentlyPlayed(Joshwan), List.of(song3, song1));
        assertEquals(store.getRecentlyPlayed(Joel), List.of(song2));
    }

    @Test
    public void testPlaySongWithInvalidCapacity() {
        // Testing playing a song with an invalid (negative) capacity
        SongStore store = new SongStore(-1);
        
        User user = new User("Joshwan");
        Song song = new Song("S1");
        
        // Attempting to play a song with negative capacity should not affect the store
        store.playSong(user, song);
        
        Assert.assertTrue(store.getRecentlyPlayed(user).isEmpty());
    }

    @Test
    public void testGetRecentlyPlayedForUnknownUser() {
        // Testing fetching recently played songs for an unknown user
        SongStore store = new SongStore(3);
        
        User unknownUser = new User("Josh");
        
        // Fetching recently played songs for an unknown user should return an empty list
        Assert.assertTrue(store.getRecentlyPlayed(user).isEmpty());
    }
}
