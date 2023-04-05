import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이 문제는 세개의 문자열에 대해 LCS를 진행해야 한다.
 * 만약 두개의 문자열씩 따로따로 LCS를 진행했을 떄 그 결과로 나온 것이 반드시 최선이라고 할 수 없다.
 * 그래서 이 문제는 3차원 배열을 이용하여 문제를 풀었다.
 * @author SSAFY
 *
 */
public class BJ1958 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		String[] st=new String[3];
		for(int i=0; i<3;i++) {
			st[i]=br.readLine();
		}
		String result=LCS(st[0],st[1],st[2]);
		System.out.println(result.length());
	}
	public static String LCS(String s1, String s2,String s3) {
		int[][][] dp=new int[s1.length()+1][s2.length()+1][s3.length()+1];
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				for (int z = 1; z <= s3.length(); z++) {
					if(s1.charAt(i-1)==s2.charAt(j-1) && s2.charAt(j-1)==s3.charAt(z-1)) {
						dp[i][j][z]=dp[i-1][j-1][z-1]+1;
					}else {
						dp[i][j][z]=Math.max(dp[i-1][j][z], Math.max(dp[i][j][z-1], dp[i][j-1][z]));
					}
					
				}
			}
		}
		int curX=s1.length();
		int curY=s2.length();
		int curZ=s3.length();
		StringBuilder sb=new StringBuilder();
		while(curX!=0 && curY!=0 && curZ!=0) {
			if(dp[curX][curY][curZ]==dp[curX][curY][curZ-1]) {
				curZ=curZ-1;
			}else if(dp[curX][curY][curZ]==dp[curX][curY-1][curZ]) {
				curY=curY-1;
			}else if(dp[curX][curY][curZ]==dp[curX-1][curY][curZ]) {
				curX=curX-1;
			}else {
				sb.append(s1.charAt(curX-1));
				curX=curX-1;
				curY=curY-1;
				curZ=curZ-1;
			}
		}
		return sb.reverse().toString();
	}
	
}
