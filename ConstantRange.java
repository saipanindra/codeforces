
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
 
public class ConstantRange{
   public static void main(String[] args) {
      MyScanner sc = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      
      int n      = sc.nextInt();        // read input as integer
      if(n == 2)
      {
    	 int x = sc.nextInt();
    	 int y = sc.nextInt();
    	 out.println(2);
      }
      else
      {
              int a = sc.nextInt();
              int b = sc.nextInt();
              int j = 0, l = 0;
              int d = b - a;
              int m_l = Integer.MIN_VALUE;
              
              for(int i = 2; i < n ;i++)
              {
                      int c = sc.nextInt();
                      int c_d = c - b;
                      b = c;
                      if(c_d == 0) {
                              m_l = Math.max(i - l + 1, m_l);
                              continue;
                              }
                      if(c_d != d) {
                              j = i - 1;
                              d = c_d;
                      m_l = Math.max(i - l + 1, m_l);
                              continue;
                      }
                      
                      l = j + 1;
                      j = i - 1;
                         m_l = Math.max(i - l + 1, m_l);
              }
              out.println(m_l);
      }
      
      // Stop writing your solution here. -------------------------------------
      out.close();
   }

     

   
   //-----------PrintWriter for faster output---------------------------------
   public static PrintWriter out;
      
   //-----------MyScanner class for faster input----------
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
 
      String nextLine(){
          String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
      }

   }
   //--------------------------------------------------------
}
