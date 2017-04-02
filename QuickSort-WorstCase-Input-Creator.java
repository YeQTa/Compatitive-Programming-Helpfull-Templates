
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {


/*
 *
 * @Author Yekta Anıl Aksoy
 * This code is created at 02/04/2017
 * Fast Reader class is used for making fast input / output operation
 *
 * This code gets input n to create an array which includes numbers 1 to n and
 * This code arrange these numbers to get WORST CASE SCENARIO for QuickSort when Pivot is chosen as mid.
 * Output count is stand for number of comparison in QuickSort.
 */


        static FastReader in;
        static PrintWriter out;

    static int[] array;
    static int count=0;

    static void Qsort(int left,int right){
        int i,j,key,buf;
        key = array[(left+right)/2];
        i=left;
        j=right;

        do{

            while(array[i]<key){
                i++;
                count++;
            }


            while(key<array[j]){
                j--;
                count++;

            }
            count+=2;
            if(i<=j){
                buf = array[i];
                array[i] = array[j];
                array[j] = buf;
                i++;
                j--;

            }
        }while(i<=j);

        if(left<j){
            Qsort(left,j);
        }
        if(i<right)
        {
            Qsort(i,right);
        }

    }

        public static void Solve(){
            System.out.print("Enter the n:");
            int n = in.nextInt();
            if(n==1){
                out.print("1");
            }
            else if(n==2){
                out.print("1 2");
            }
            else{
                array = new int[n];


                array[0] = 1;
                array[1] = 2;
                for(int i =2 ;i<n;i++){
                    array[i]=i+1;
                    if(array[i/2]<array[i]){
                        int tmp = array[i/2];
                        array[i/2] = array[i];
                        array[i] = tmp;
                    }
                }

                out.print("Created input : ");
                for(int number: array){
                    out.print(number+" ");
                }

                Qsort(0,n-1);
                out.println("\nAbove input given to QuickSort and After Quick sort : "+ Arrays.toString(array));
                out.println("Number of comparison in QuickSort : "+count+" ( O(n^2))");

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
