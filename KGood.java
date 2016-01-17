import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KGood {

	static int[] counter_array = new int[1000001];
	static int current_diff_count;

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));

		int n = sc.nextInt(); // read input as integer
		int k = sc.nextInt(); // read input as long
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		/*
		 * if (n == k) { out.print(1 + " " + n); } else if (k == 1) {
		 * out.print(1 + " " + 1);
		 */

		int max_start = -1, max_end = -1;
		add(input[0]);
		int end = 1;
		for (int start = 0; start < n; start++) {
			while (end < n) {
				add(input[end]);
				if (current_diff_count > k) {
					remove(input[end]);
					break;
				}
				end++;
			}
			if (max_end - max_start < end - 1 - start) {
				max_start = start + 1;
				max_end = end;
			}
			remove(input[start]);
		}
		if(max_start == -1) max_start = 1;
		if (max_end == -1) max_end = 1;
		out.print(max_start + " " + max_end);
		// Stop writing your solution here.
		// -------------------------------------
		out.close();
	}

	private static void add(int v) {
		counter_array[v]++;
		if (counter_array[v] == 1) {
			current_diff_count++;
		}

	}

	private static void remove(int v) {
		counter_array[v]--;
		if (counter_array[v] == 0) {
			current_diff_count--;
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
