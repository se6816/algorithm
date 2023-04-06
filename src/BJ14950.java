import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @author SSAFY
 *
 */
public class BJ14950 {

	static class Node implements Comparable<Node>{
		int n1;
		int n2;
		int cost;
		public Node(int n1, int n2, int cost) {
			this.n1 = n1;
			this.n2 = n2;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
		
		
	}
	public static int[] parents;
	public static int findParents(int n) {
		if(parents[n]==n) {
			return n;
			
		}else {
			return parents[n]=findParents(parents[n]);
		}
	}
	public static boolean union(int a,int b) {
		int ROOT_A=findParents(a);
		int ROOT_B=findParents(b);
		if(ROOT_A==ROOT_B) {
			return false;
		}else if(ROOT_A>ROOT_B) {
			parents[ROOT_A]=ROOT_B;
		}else if(ROOT_A<ROOT_B) {
			parents[ROOT_B]=ROOT_A;
		}
		return true;
	}
	public static int N;
	public static int M;
	public static int t;
	public static int winCount;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		PriorityQueue<Node> pq=new PriorityQueue<>();
		stz=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stz.nextToken());  // 도시 개수
		M=Integer.parseInt(stz.nextToken());  // 도로 개수
		t=Integer.parseInt(stz.nextToken()); //정복할 때마다 증가하는 비용
		winCount=0;
		parents= new int[N+1];
		for(int i=0;i<=N;i++) {
			parents[i]=i;
		}
		int result=0;
		for(int i=0; i<M;i++) {
			stz=new StringTokenizer(br.readLine());
			pq.add(new Node(Integer.parseInt(stz.nextToken()),Integer.parseInt(stz.nextToken()),Integer.parseInt(stz.nextToken())));
		}
		while(!pq.isEmpty()) {
			Node n=pq.poll();
			if(union(n.n1, n.n2)) {
				result+=n.cost+winCount*t;
				winCount++;
			}
		}
		System.out.println(result);
		
		
	}
	
}
