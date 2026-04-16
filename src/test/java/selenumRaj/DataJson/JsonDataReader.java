package selenumRaj.DataJson;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;

public class JsonDataReader {
	public List<HashMap<String, String>> getJsonData() throws IOException {
		// Read Json String
		String jsonContent = FileUtils.readFileToString(new File(
				System.getProperty("user.dir") + "\\src\\test\\java\\selenumRaj\\DataJson\\PurchaseOrder.json"),StandardCharsets.UTF_8);
		// String to HashMap
		ObjectMapper mapper = new ObjectMapper(); // JavaClass
		List<HashMap<String, String>> Data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return Data; // Data -> {{HashMap},{HashMap}}
	}
}
