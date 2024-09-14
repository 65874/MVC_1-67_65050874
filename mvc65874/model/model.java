package mvc65874.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class model {
    private String csvFile = "songs.csv"; // CSV file for storing song data
    private List<String[]> songs = new ArrayList<>(); // To store the songs data

    // Constructor - Load existing songs from CSV or create if not exists
    public model() {
        File file = new File(csvFile);
        if (!file.exists()) {
            createCSVFile(); // Create the CSV file if it doesn't exist
            initializeDefaultData(); // Add default data if the file was newly created
        } else {
            loadFromCSV(); // Load data if the file exists
        }
    }

    // Method to create the CSV file with headers
    private void createCSVFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            // Write the header row (SongName, Duration, Singers, Score)
            String header = "SongName,Duration,Singers,Score";
            bw.write(header);
            bw.newLine();
            System.out.println("CSV file created with headers.");
        } catch (IOException e) {
            System.out.println("Error creating CSV file: " + e.getMessage());
        }
    }

    // Initialize the CSV file with default data
    private void initializeDefaultData() {
        addSong("Song1", 180, new String[] { "John" }, 80);
        addSong("Song2", 150, new String[] { "Jane", "Thomas" }, 60);
        addSong("Song3", 200, new String[] { "Chris", "Lisa", "Tom" }, 75);
    }

    // Method to add song data
    public void addSong(String songName, int duration, String[] singers, int score) {
        String[] songData = { songName, String.valueOf(duration), String.join(", ", singers), String.valueOf(score) };
        songs.add(songData);
        saveToCSV();
    }

    // Method to calculate score based on the number of singers
    public int calculateScore(String[] singers, int duration) {
        int score = 0;

        if (singers.length == 1) {
            // Calculate score for one singer
            int totalPreviousDuration = getTotalPreviousDuration();
            score = totalPreviousDuration % 100;
        } else if (singers.length == 2) {
            // Calculate score for two singers
            int totalChars = singers[0].length() + singers[1].length();
            score = (duration * totalChars) % 100;
        } else if (singers.length == 3) {
            // Calculate score for three singers
            int previousSingerChars = getPreviousSingersCharCount();
            int currentSingerChars = singers[0].length() + singers[1].length() + singers[2].length();
            score = (previousSingerChars * currentSingerChars) % 100;
        }

        return score;
    }

    // Get the total duration of all previous songs
    private int getTotalPreviousDuration() {
        int totalDuration = 0;
        for (String[] song : songs) {
            try {
                totalDuration += Integer.parseInt(song[1]);
            } catch (NumberFormatException e) {
                System.out.println("Error parsing duration: " + e.getMessage());
            }
        }
        return totalDuration;
    }

    // Get the total number of characters in previous singers' names
    private int getPreviousSingersCharCount() {
        int totalChars = 0;
        for (String[] song : songs) {
            String[] singers = song[2].split(", ");
            for (String singer : singers) {
                System.out.println(singer);
                totalChars += singer.length();
            }
        }
        return totalChars;
    }

    // Method to load songs from the CSV file
    private void loadFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean isFirstLine = true; // Flag to skip header line
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header
                    continue;
                }
                String[] songData = line.split(",");
                if (songData.length == 4) { // Make sure we only add valid rows
                    songs.add(songData);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data from CSV: " + e.getMessage());
        }
    }

    // Method to save songs to the CSV file
    private void saveToCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            // Write the header first
            String header = "SongName,Duration,Singers,Score";
            bw.write(header);
            bw.newLine();

            // Write all songs data
            for (String[] song : songs) {
                bw.write(String.join(",", song));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data to CSV: " + e.getMessage());
        }
    }
}
