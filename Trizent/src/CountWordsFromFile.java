import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CountWordsFromFile {
	public static void main(String[] args) {
		String inputFile = args[0];
		String outputFile = "wordCount.txt";

		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));

			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			Map<String, Integer> wordCounts = new HashMap<>();

			String line;
			while ((line = reader.readLine()) != null) {
				// regex
				// String[] words = line.split(" ");

				String[] words = line.split("\\s+");

				for (String word : words) {
					if (wordCounts.containsKey(word)) {
						wordCounts.put(word, wordCounts.get(word) + 1);
					} else {
						wordCounts.put(word, 1);
					}
				}
			}
			Set<Entry<String, Integer>> entrySet = wordCounts.entrySet();
			for (Map.Entry<String, Integer> entry : entrySet) {
				String word = entry.getKey();
				int count = entry.getValue();
				writer.write(word + " = " + count + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
