package songproblem_code;

public class Song {
    private String songName;
    
    public Song(String songName) {
        this.songName = songName;
    }
    
    public String getSongName() {
        return songName;
    }
    @Override
    public String toString() {
        return songName;
    }
}




