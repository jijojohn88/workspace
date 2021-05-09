import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadTestIntArray {

	public List<Integer> read(File f) {
		List<Integer> returnList = new ArrayList<>();
		try {
			Scanner myReader = new Scanner(f);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data.contains(",")) {
					String[] splits = data.split(",");
					for (String split : splits) {
						returnList.add(Integer.parseInt(split));
					}
				}
			}
			myReader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnList;
	}
	
	public List<Integer> read() {
		File file = new File("/Users/jjijo/eclipse-workspace/workspace/loadtestIntArray");
		return read(file);
	}

	public static void main(String[] args) {

		List<Integer> returnList = new LoadTestIntArray().read();
		System.out.println(returnList.size());

	}

}
