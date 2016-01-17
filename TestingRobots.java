
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashSet;

public class TestingRobots {
	static int x, y;
	static int x0, y0;
	static int current_x, current_y;
	static HashSet path = new HashSet();

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));

		x = sc.nextInt(); // read input as integer
		y = sc.nextInt(); // read input as long
		x0 = sc.nextInt();
		y0 = sc.nextInt();
		String s = sc.nextLine();

		int total = x * y;
		int remaining_places_for_mines = total - 1;
		current_x = x0;
		current_y = y0;
		path.add(x0 + "," + y0);

		out.print(1);
		if (s.length() > 0)
			out.print(" ");
		int prev_x = current_x, prev_y = current_y;
		for (int i = 0; i < s.length() - 1; i++) {
			prev_x = current_x;
			prev_y = current_y;
			UpdateCurrentXY(s.charAt(i));
			if (prev_x == current_x && prev_y == current_y) {
				out.print(0 + " ");
			} else {
				if (path.contains(current_x + "," + current_y))
					out.print(0 + " ");
				else {
					path.add(current_x + "," + current_y);
					out.print(1 + " ");
				}
			}

		}
		UpdateCurrentXY(s.charAt(s.length() - 1));
		if(x == 1 && y == 1)
		{
			out.print(0);
		}
		else if (path.contains(current_x + "," + current_y)) {
			out.print(total - path.size());
		}

		else if (prev_x != current_x || prev_y != current_y) {
			path.add(current_x + "," + current_y);
			out.print(total - path.size() + 1);
		}
		out.close();
	}

	private static void UpdateCurrentXY(char current_move) {
		switch (current_move) {
		case 'U':
			if (current_x > 1)
				current_x--;
			break;

		case 'D':
			if (current_x < x)
				current_x++;
			break;
		case 'R':
			if (current_y < y)
				current_y++;
			break;
		case 'L':
			if (current_y > 1)
				current_y--;
			break;
		}
	}

	// -----------PrintWriter for faster output---------------------------------
	public static PrintWriter out;

	// -----------MyScanner class for faster input----------
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

}
