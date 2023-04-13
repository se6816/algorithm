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

public class BJ2477{
	// 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4
	public static int rowMin;
	public static int rowMax;
	public static int colMin;
	public static int colMax;
	public static int standard=3000;
	public static int myX=3000;
	public static int myY=3000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		rowMin=standard;
		colMin=standard;
		rowMax=standard;
		colMax=standard;
		int N=Integer.parseInt(br.readLine());
		int[] len=new int[7];
		int sum=0;
		for(int i=0;i<6;i++) {
			stz=new StringTokenizer(br.readLine());
			int direct=Integer.parseInt(stz.nextToken());
			int dist=Integer.parseInt(stz.nextToken());
			len[i]=dist;
			switch(direct) {
				case 1:
					myY+=dist;
					colMax=Math.max(colMax,myY);
					break;
				case 2:
					myY-=dist;
					colMin=Math.min(colMin, myY);
					break;
				case 3:
					myX+=dist;
					rowMax=Math.max(rowMax,myX);
					break;
				case 4:
					myX-=dist;
					rowMin=Math.min(rowMin, myX);
					break;
			}
		}
		len[6]=len[0];
		for(int i=0; i<6;i++) {
			sum+=len[i]*len[i+1];
		}
		int max=(rowMax-rowMin)*(colMax-colMin);
		System.out.println(N*(max-(3*max-sum)));
		
	}
	
		
}
	

		
		
		
		

