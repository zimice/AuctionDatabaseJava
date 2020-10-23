import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AdvertParser {
	public static Auction getAuction(String filepath) {
		Auction result = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			Person auctioningPerson = new Person(br.readLine(),br.readLine(),br.readLine(),br.readLine());
			br.readLine();
			String description = br.readLine();
			br.readLine();
			Wine auctioningWine = new Wine(Integer.parseInt(br.readLine()),TypeOfWine.valueOf(br.readLine()),br.readLine(),Double.parseDouble(br.readLine()),Integer.parseInt(br.readLine()));
			result = new Auction(auctioningWine,auctioningPerson,description);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
}
