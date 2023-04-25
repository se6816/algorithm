import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 
 * 
 * @author user
 *
 */
public class BJ2637{
	static class Node{
		int targetX;
		int weight;
		public Node(int targetX, int weight) {
			this.targetX = targetX;
			this.weight = weight;
		}
		
	}
	static int[] degree; // 위상배열
	static int[] usedComponents;
	static boolean[] isLeaf;
	static List<ArrayList<Node>> list;
	static StringBuilder sb;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		sb=new StringBuilder();
//		stz=new StringTokenizer(br.readLine());
		N=Integer.parseInt(br.readLine()); // 부품의 수 
		int M=Integer.parseInt(br.readLine()); // 선수 조건
		isLeaf=new boolean[N+1];
		degree=new int[N+1];                  // 위상 배열
		usedComponents=new int[N+1];                  // 사용 부품 수
		list=new ArrayList<>();
		for(int i=0; i<=N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0; i<M;i++) {
			// X가 만들어지려면 Y부품이 K개 필요하다.
			stz=new StringTokenizer(br.readLine());
			int X=Integer.parseInt(stz.nextToken());
			int Y=Integer.parseInt(stz.nextToken());
			int K=Integer.parseInt(stz.nextToken());
			list.get(X).add(new Node(Y,K));
			degree[Y]+=1;
		}
		bfs(N);
		for(int i=1; i<N;i++) {
			if(isLeaf[i] && usedComponents[i]!=0) {
				sb.append(i).append(" ").append(usedComponents[i]).append("\n");
			}
		}
		System.out.println(sb);
		
	}
	private static void bfs(int start) {
		Queue<Integer> que=new ArrayDeque<>();
		que.offer(start);
		usedComponents[start]=1;
		while(!que.isEmpty()) {
			int n=que.poll();
			boolean flag=true;
			for(Node target : list.get(n)) {
				flag=false;
				degree[target.targetX]-=1;
				usedComponents[target.targetX]+=usedComponents[n]*target.weight;
				if(degree[target.targetX]==0) {
					que.offer(target.targetX);
				}
			}			
			if(flag) {
				isLeaf[n]=true;
			}
		}
	}

	
	
	
	
	
		
}
	

		
		
		
		

