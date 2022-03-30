import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class DatasetGenerator {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader("data.json"));
			JSONObject jsonObject = (JSONObject)obj;
			String[] names = (String[])jsonObject.get("firstNames");
			for(int i = 0 ; i < names.length; i++) {
				System.out.print(names[i]+" ");
			}
			System.out.println();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
