import java.io.*;
import java.util.*;

/* 
  Example input:
   5
  ()()
  ([])
  ([)]
  ((]]
  )(
  
  Example output:
  YES
  YES
  NO
  NO
  NO
  

*/

public class Solution {
	static FastReader in;
	static PrintWriter out;
	
	public static void Solve(){
        int n = in.nextInt();
        while(n-->0){
        	String brackets = in.next();
        	Stack<Character>open = new Stack<Character>();

        	if(brackets.length()%2!=0){
        		out.println("NO");
        	}
        	
        	else{
        		boolean flag=true;
            	for(int i=0;i<brackets.length();i++){
            		if(brackets.charAt(i)=='(' || brackets.charAt(i)=='[')
            			open.push(brackets.charAt(i));
            		else{
            			if(open.isEmpty()){
            				out.println("NO");
            				flag=false;
            				break;
            			}
            			else{
            				char c = open.pop();
            				if((c=='(' && brackets.charAt(i)!=')') || (c=='[' && brackets.charAt(i)!=']')){
            					out.println("NO");
            					flag=false;
            					break;
            				}
            			}
            		}	
            	}
            	if(flag){
            		if(open.isEmpty())
            			out.println("YES");
            		else
            			out.println("NO");
            	}
        	}
        }
       
	}
	
	public static void main(String[] args) {
		in = new FastReader();
		out = new PrintWriter(System.out);
		
		//long s = System.currentTimeMillis();
		Solve();
		out.flush();
		//System.out.println(System.currentTimeMillis()-s +"ms");
	}
	
	
	
	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

}


