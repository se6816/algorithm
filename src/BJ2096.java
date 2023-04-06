import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2096 {
	

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int N=Integer.parseInt(br.readLine());
		int[][] minDp=new int[2][3];
		int[][] maxDp=new int[2][3];
		for(int i=1; i<=N;i++) {
//			stz=new StringTokenizer(br.readLine());
//			int n1=Integer.parseInt(stz.nextToken());
//			int n2=Integer.parseInt(stz.nextToken());
//			int n3=Integer.parseInt(stz.nextToken());
			String s=br.readLine();
			int prevIdx=(i-1)%2;
			int curIdx=i%2;
			minDp[curIdx][0]=Math.min(minDp[prevIdx][0], minDp[prevIdx][1])+(s.charAt(0)-'0');
			minDp[curIdx][1]=Math.min(minDp[prevIdx][0],Math.min(minDp[prevIdx][1], minDp[prevIdx][2]))+(s.charAt(2)-'0');
			minDp[curIdx][2]=Math.min(minDp[prevIdx][1], minDp[prevIdx][2])+(s.charAt(4)-'0');
			maxDp[curIdx][0]=Math.max(maxDp[prevIdx][0], maxDp[prevIdx][1])+(s.charAt(0)-'0');
			maxDp[curIdx][1]=Math.max(maxDp[prevIdx][0],Math.max(maxDp[prevIdx][1], maxDp[prevIdx][2]))+(s.charAt(2)-'0');
			maxDp[curIdx][2]=Math.max(maxDp[prevIdx][1], maxDp[prevIdx][2])+(s.charAt(4)-'0');
		
		}
		int min=Math.min(minDp[N%2][0], Math.min(minDp[N%2][1], minDp[N%2][2]));
		int max=Math.max(maxDp[N%2][0], Math.max(maxDp[N%2][1], maxDp[N%2][2]));

		System.out.println(max+" "+min);		
	}
	
}
