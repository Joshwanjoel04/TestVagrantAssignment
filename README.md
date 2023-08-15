# TestVagrantAssignment
This Java program implements an in-memory store to manage recently played songs for users. Each user has a playlist of songs, and the store ensures that the playlist does not exceed a specified capacity. Older songs are removed when the capacity is reached.

Run the SongsCodeTest class as a TestNG test suite. This will execute the predefined test cases.

Components

1.Song Class
Represents a song with a name.

2.User Class
Represents a user with a username.

3.SongStore Class
Manages recently played songs for users.

-public void playSong(User user, Song song): Adds a song to a user's playlist and manages playlist capacity.

-public List<Song> getRecentlyPlayed(User user): Retrieves the list of recently played songs for a user.
Tests
The SongsCodeTest class contains various tests to ensure the functionality of the SongStore class.

testPlaySongAndFetchRecentlyPlayed: Tests playing songs and fetching recently played songs for a user.
testPlayMoreThanCapacity: Tests playing more songs than the playlist capacity.
testPlayWithoutExceedingCapacity: Tests playing songs within the playlist capacity.
testPlayWithoutUser: Tests fetching recently played songs for an unknown user.
testBoundaryValueCapacity: Tests playing songs up to the capacity limit.
testMultipleUsers: Tests managing playlists for multiple users.
testPlaySongWithInvalidCapacity: Tests playing songs with an invalid (negative) capacity.
testGetRecentlyPlayedForUnknownUser: Tests fetching recently played songs for an unknown user.

songcode_assignment/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── songproblem_code/
│   │       │   ├── Song.java
│   │       │   ├── User.java
│   │       │   └── SongStore.java
│   │       |-- BaseCode.java
│   │
│   └── test/
│       └── java/
│           ├── songproblem_code/
│               └── SongsCodeTest.java
│           
│
├── .gitignore
└── README.md





