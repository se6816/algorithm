import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 
 * 
 * @author user
 *
 */
public class BJ2438{

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++) {
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	}
	
	
	
	
		
}
	

		
		
		
		

