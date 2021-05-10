import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidateEmail {

	public static String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
//  String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	public static void main(String[] args) {

		File file = new File("/Users/jjijo/eclipse-workspace/workspace/filename.txt");
		List<String> content = new ArrayList<String>();
		String line = "";
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				line = scanner.next();
				if (!line.matches(regex)) {
					content.add(line);
					content.add("\n");
				} else {
					System.out.println("Excluded - " + line);
				}
			}

			scanner.close();
		} catch (Exception er) {
			er.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

		for (String str : content) {
			System.out.println(str);
		}

	}

}
