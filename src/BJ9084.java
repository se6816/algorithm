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
 * 전형적인 DP문제이다.
 * 
 * @author user
 *
 */
public class BJ9084{

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++) {
			int N=Integer.parseInt(br.readLine());
			int[] dp=new int[10001];
			stz=new StringTokenizer(br.readLine());
			for(int i=0; i<N;i++) {
				int money=Integer.parseInt(stz.nextToken());
				dp[money]+=1;
				for(int j=0;j<=10000;j++) {
					if(dp[j]!=0 && j+money<=10000) {
						dp[j+money]=dp[j]+dp[j+money];
					}
				}
				
			}
			int M=Integer.parseInt(br.readLine());
			sb.append(dp[M]).append("\n");
		}
		System.out.println(sb);
		
		
	}
	
	
	
	
		
}
	

		
		
		
		

