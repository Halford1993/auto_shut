package auto_shutd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		Runtime run = Runtime.getRuntime();
		System.out.println("Set how long until the shutdown (in minutes): ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		int tiempo = Integer.parseInt(br2.readLine())*60;
		//here we abort previous scheduled shut down (if any)
		Process pr = run.exec("shutdown -a");
		pr.waitFor();
		String cmd = "shutdown -s -t " + tiempo;
		pr = run.exec(cmd);
		pr.waitFor();
	}

}
