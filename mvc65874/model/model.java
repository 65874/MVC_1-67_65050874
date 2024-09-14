package mvc65874.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class model {
    private String csvFile = "cow.csv";
    private List<String[]> cowList = new ArrayList<>();

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
            String header = "Code,Color,year,month,milking time";
            bw.write(header);
            bw.newLine();
            System.out.println("CSV file created with headers.");
        } catch (IOException e) {
            System.out.println("Error creating CSV file: " + e.getMessage());
        }
    }

    // Initialize the CSV file with default data
    private void initializeDefaultData() {
        String[] color = { "Brown", "White" };
        Random rand = new Random();

        for (int i = 1; i < 11; i++) {
            int code = rand.nextInt(10000000, 99999999);
            int year = rand.nextInt(11); // Random year between 0 and 10
            int month = rand.nextInt(12); // Random month between 0 and 11
            addCow(code, color[i % 2], year, month, 0);
        }
    }

    // Method to add cow data
    public void addCow(int code, String color, int year, int month, int milkingTime) {
        String[] cowData = { String.valueOf(code), color, String.valueOf(year), String.valueOf(month),
                String.valueOf(milkingTime) };
        cowList.add(cowData);
        System.out.println(cowList);
        saveToCSV();
    }

    // Method to get the year for a specific cow by code
    public int getYear(int code) {
        for (String[] cow : cowList) {
            if (Integer.parseInt(cow[0]) == code) {
                return Integer.parseInt(cow[2]);
            }
        }
        return -1;
    }

    // Method to get data for a specific cow by code
    public String[] getCowByCode(int code) {
        for (String[] cow : cowList) {
            if (Integer.parseInt(cow[0]) == code) {
                return cow;
            }
        }
        return null;
    }

    // Method to get the month for a specific cow by code
    public int getMonth(int code) {
        for (String[] cow : cowList) {
            if (Integer.parseInt(cow[0]) == code) {
                return Integer.parseInt(cow[3]); // Return the month
            }
        }
        return -1; // Return -1 if cow not found
    }

    public boolean updateMilking(int code) {
        for (String[] cow : cowList) {
            if (Integer.parseInt(cow[0]) == code) {
                int time = Integer.parseInt(cow[4]) + 1;
                cow[4] = String.valueOf(time);
                saveToCSV(); // Save the updated data
                return true;
            }
        }
        return false; // Return false if the cow with the given code was not found
    }

    public boolean resetCow(int code) {
        for (String[] cow : cowList) {
            if (Integer.parseInt(cow[0]) == code) {
                cow[4] = String.valueOf(0);
                saveToCSV(); // Save the updated data
                return true;
            }
        }
        return false; // Return false if the cow with the given code was not found
    }

    // Method to load cows from the CSV file
    private void loadFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean isFirstLine = true; // Flag to skip header line
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header
                    continue;
                }
                String[] cowData = line.split(",");
                if (cowData.length == 5) { // Make sure we only add valid rows
                    cowList.add(cowData);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data from CSV: " + e.getMessage());
        }
    }

    // Method to save cow to the CSV file
    private void saveToCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            // Write the header first
            String header = "Code,Color,year,month,milking time";
            bw.write(header);
            bw.newLine();

            // Write all cows data
            for (String[] cow : cowList) {
                bw.write(String.join(",", cow));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data to CSV: " + e.getMessage());
        }
    }
}
