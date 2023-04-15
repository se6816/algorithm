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
 * 이 문제는 조합문제이다.
 * 그러나 N이 최대 100이기 떄문에 재귀를 썼다간 터질 수 있다.
 * 그리고 값이 long으로도 저장될 수 없어서 BigInteger을 써야한다.
 * 
 * @author user
 *
 */
public class BJ2407{
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
	

		
		
		
		

