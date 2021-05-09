import java.net.Socket;

public class PortChecker {
	public static boolean available(String ipAddress, int port) {
		if (port < 0 || port > 9999) {
			throw new IllegalArgumentException("Invalid start port: " + port);
		}

		try {
			Socket socket = new Socket(ipAddress, port);
			socket.close();
			return true;
		} catch (Exception er) {
			return false;
		}
	}

	public static void main(String[] args) {
		boolean flag = false;
		int port = 22;
		flag = available("localhost", port);
		System.out.println(flag + " " + port);

		port = 80;
		flag = available("10.32.111.6", port);
		System.out.println(flag + " " + port);
	}
}
