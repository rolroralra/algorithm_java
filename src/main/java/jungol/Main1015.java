package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main1015 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> forwardStack = new Stack<String>(), backwardStack = new Stack<String>();
		String currentPage = "http://www.acm.org/";
		String input = null;
		while (!(input = in.readLine()).equalsIgnoreCase("QUIT")) {
			StringTokenizer st = new StringTokenizer(input);
			String cmd = st.nextToken();
			boolean isIgnoredCmd = false;
			if (cmd.equalsIgnoreCase("VISIT")) {
				backwardStack.push(currentPage);
				currentPage = st.nextToken();
				forwardStack.clear();
			}
			else if (cmd.equalsIgnoreCase("BACK")) {
				if (!backwardStack.isEmpty()) {
					forwardStack.push(currentPage);
					currentPage = backwardStack.pop();
				} 
				else { isIgnoredCmd = true; }
			}
			else if (cmd.equalsIgnoreCase("FORWARD")) {
				if (!forwardStack.isEmpty()) {
					backwardStack.push(currentPage);
					currentPage = forwardStack.pop();
				} 
				else { isIgnoredCmd = true; }
			} 
			else { }
			
			if (isIgnoredCmd) {
				System.out.println("Ignored");
			}
			else {
				System.out.println(currentPage);
			}
		}
	}
}