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

public class BJ27945{
	static int findParent(int n) {
		if(parents[n]==n) {
			return n;
		}else {
			return parents[n]=findParent(parents[n]);
		}
	}
	static boolean union(int n1, int n2) {
		int ROOT_A=findParent(n1);
		int ROOT_B=findParent(n2);
		if(ROOT_A==ROOT_B) {
			return false;
		}else if(ROOT_A>ROOT_B){
			parents[ROOT_A]=ROOT_B;
		}else {
			parents[ROOT_B]=ROOT_A;
		}
		return true;
	}
	static class Node implements Comparable<Node>{
		int v1;
		int v2;
		int t;
		public Node(int v1, int v2, int t) {
			this.v1 = v1;
			this.v2 = v2;
			this.t = t;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.t-o.t;
		}
		
	}
	public static int parents[];
	public static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		stz=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(stz.nextToken()); // 요리 학원의 수
		int M=Integer.parseInt(stz.nextToken()); // 길의 수
		parents=new int[N+1];
		int result=1;
		PriorityQueue<Node> pq=new PriorityQueue<>();
		for(int i=0; i<=N;i++) {
			parents[i]=i;
		}
		for(int i=0; i<M;i++) {
			stz=new StringTokenizer(br.readLine());
			int v1=Integer.parseInt(stz.nextToken());
			int v2=Integer.parseInt(stz.nextToken());
			int t1=Integer.parseInt(stz.nextToken());
			pq.offer(new Node(v1,v2,t1));
		}
		
		while(!pq.isEmpty()) {
			Node n=pq.poll();
			if(union(n.v1,n.v2)) {
				if(n.t==result) {
					result++;					
				}else {
					break;
				}
			}else {
				break;
			}
		}
		System.out.println(result);
		
		
	}
	
	

	
		
}
	

		
		
		
		

