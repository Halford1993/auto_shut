package auto_shutd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		new Window();
	}
	
	public static void executing(int time) throws Exception {
		Runtime run = Runtime.getRuntime();
		//here we abort previous scheduled shut down (if any)
		Process pr = run.exec("shutdown -a");
		pr.waitFor();
		String cmd = "shutdown -s -t " + time;
		pr = run.exec(cmd);
		pr.waitFor();
	}
}
