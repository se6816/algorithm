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
 * 이 문제는 전형적인 다익스트라 문제이다.
 * 
 * @author user
 *
 */
public class Main{
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		stz=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stz.nextToken());
		M=Integer.parseInt(stz.nextToken());
		BigInteger[][] dp=new BigInteger[N+1][N+1];
		for(int i=1; i<=N;i++) {
			for (int j = 0; j <= i; j++) {
				if(j==0 || j==i) {
					dp[i][j]=new BigInteger("1");
				}else {
					dp[i][j]=dp[i-1][j].add(dp[i-1][j-1]);					
				}
			}
		}
		System.out.println(dp[N][M].toString());
		
		
	}
	
	
	
	
		
}
	

		
		
		
		

