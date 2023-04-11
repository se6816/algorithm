import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static int[][] list;
	public static long maxResult;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb=new StringBuilder();
		stz=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stz.nextToken());
		M=Integer.parseInt(stz.nextToken());
		maxResult=-1;
		list=new int[N][M];
		for (int i = 0; i < N; i++) {
			String s=br.readLine();
			for (int j = 0; j < M; j++) {
				list[i][j]=s.charAt(j)-'0';
			}
		}
		for(int i=0; i<N;i++) {
			for (int j = 0; j < M; j++) {
				execute(i,j);				
			}
		}
		System.out.println(maxResult);
	}
	private static void execute(int x, int y) {
		for (int i = -N; i < N; i++) {
			for (int j = -M; j < M; j++) {
				if(i==0 && j==0) {
					continue;
				}
				
				int curX=x;
				int curY=y;
				int result=0;
				
				while(curX>=0 && curY>=0 && curX<N && curY<M) {
					result=result*10+list[curX][curY];
					System.out.println(result);
					if(Math.sqrt(result)%1==0) {
						maxResult=Math.max(maxResult, result);
					}
					
					curX+=i;
					curY+=j;
				}
			}
		}
	}
	
		
}
	

		
		
		
		

