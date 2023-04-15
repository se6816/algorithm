import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class BJ1916{
	static class Node implements Comparable<Node>{
		int vtx;
		int w;
		public Node(int vtx, int w) {
			this.vtx = vtx;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
		@Override
		public String toString() {
			return "Node [vtx=" + vtx + ", w=" + w + "]";
		}
		
		
	}
	static List<ArrayList<Node>> list;
	static int N;
	static int M;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		list=new ArrayList<>();
		dist=new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0; i<=N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0; i<M;i++) {
			stz=new StringTokenizer(br.readLine());
			int v1=Integer.parseInt(stz.nextToken());
			int v2=Integer.parseInt(stz.nextToken());
			int w=Integer.parseInt(stz.nextToken());
			list.get(v1).add(new Node(v2,w));
		}
		stz=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(stz.nextToken());
		int end=Integer.parseInt(stz.nextToken());
		execute(start);
		System.out.println(dist[end]);
	}
	private static void execute(int start) {
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.offer(new Node(start,0));
		dist[start]=0;
		while(!pq.isEmpty()) {
			Node n=pq.poll();
			if(dist[n.vtx]<n.w) {
				continue;
			}
			for(Node target : list.get(n.vtx)) {
				if(dist[target.vtx]>(dist[n.vtx]+target.w)) {
					dist[target.vtx]=dist[n.vtx]+target.w;
					
					pq.offer(new Node(target.vtx,dist[n.vtx]+target.w));
				}
			}
		}
	}
	
	
	
		
}
	

		
		
		
		

