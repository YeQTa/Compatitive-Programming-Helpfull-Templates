package com.anil;

import java.io.*;

import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

/*
This code is written for calculate the result of postfix notation aka Reverse Polish Notation(RPN).
Author: Yekta Anıl Aksoy

example input:
7
8 9 + 1 7 - *

example output:
-102


*/

    public static void main(String[] args) throws IOException {
        try (PrintWriter out = newOutput()) {
            FastScanner in = newInput();

            int n = in.nextInt();

            Stack<Integer> stack = new Stack<Integer>();
            char tmp = in.read();
            while(tmp!='\r' && tmp!='\n'){

                if(tmp!=' '){
                    if(tmp !='+' && tmp!='-' && tmp!='/' && tmp!='*')
                       stack.push(Character.getNumericValue(tmp));
                    else if(tmp =='+'){
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        stack.push(num1+num2);
                    }
                    else if(tmp =='-'){
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        stack.push(num2-num1);
                    }
                    else if(tmp =='*'){
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        stack.push(num1*num2);
                    }
                    else if(tmp =='/'){
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        stack.push(num2/num1);
                    }
                }
                tmp = in.read();
            }
            out.println(stack.pop());

        }
    }


    static class FastScanner {
        static BufferedReader br;
        static StringTokenizer st;

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
        char read() throws IOException{
            char c = (char)br.read();
            return c;
        }
    }

    static FastScanner newInput()  {
            return new FastScanner(System.in);

    }
    static PrintWriter newOutput() {
            return new PrintWriter(System.out);

    }
}
