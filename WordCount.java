import java.io.*;
import java.util.*;

class WordCount {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("textfile.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                
                line = line.toLowerCase().replaceAll("[^a-z ]", "");
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) { 
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            
            ArrayList<String> wordsList = new ArrayList<>(wordCount.keySet());
            
            Collections.sort(wordsList, (w1, w2) -> wordCount.get(w2) - wordCount.get(w1));

        
            System.out.println("Top 5 Most Frequent Words:");
            for (int i = 0; i < Math.min(5, wordsList.size()); i++) {
                System.out.println(wordsList.get(i) + ": " + wordCount.get(wordsList.get(i)));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
