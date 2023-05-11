import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ParseJson {
	public static void main(String[] args) {
        String json = "{ \"name\" : \"sarah\", \"age\" : 23 }";

        Map<String, Object> jsonMap = new HashMap<>();
        String[] keyValuePairs = json.replace("{", "").replace("}", "").split(",");
        for (String keyValuePair : keyValuePairs) {
            String[] parts = keyValuePair.trim().split(":");
            String key = parts[0].trim().replace("\"", "");
            String value = parts[1].trim().replace("\"", "");
            //check
            if (value.matches("\\d+")) {
            	//parse
                jsonMap.put(key, Integer.parseInt(value));
            } else {
                jsonMap.put(key, value);
            }
        }
       // Set<Entry<String, Object>> entrySet = jsonMap.entrySet();
       // System.out.println(entrySet);

       StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
           output.append(entry.getKey()).append("=").append(entry.getValue()).append(" ");
       }

       System.out.println(output);
   }
}
