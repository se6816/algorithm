import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 이 문제는 위상정렬 문제이다.
 * 이 문제에서 주의할 점은 강의 strahler 값의 갱신을
 * 매번 하는 것이 아닌 선수 조건이 완료되었을 때 갱신이 발생해야 한다.
 * 그 전에 갱신이 발생하면 엉뚱한 값이 발생한다. 예로
 * 2,2,3이 들어올 때 매 번 갱신을 해버린다면
 * strahler 순서 값이 4가 되버리므로 선수 조건이 완료되었을 때 갱신이 발생해야 한다.
 * 
 * @author user
 *
 */
public class BJ9470{
	static class Node{
		int x;
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		public Node(int x) {
			this.x = x;
		}
		public void add(int v) {
			pq.offer(v);
		}
		public void update() {
			int n=0;
			while(!pq.isEmpty()) {
				int p=pq.poll();
				if(p>n) {
					n=p;
				}else if(p==n) {
					n+=1;
				}else {
					break;
				}
			}
			pq.clear();
			x=n;
			
		}
	}
	static int[] degree; // 위상배열
	static Node[] strahler; // 위상배열
	static List<ArrayList<Integer>> list;
	static StringBuilder sb;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int test=1; test<=T;test++) {
			stz=new StringTokenizer(br.readLine());
			int K=Integer.parseInt(stz.nextToken()); // 테스트 케이스 번호
			M=Integer.parseInt(stz.nextToken());  // 노드의 수
			int P=Integer.parseInt(stz.nextToken()); // 간선의 수
			degree=new int[M+1];
			strahler=new Node[M+1];
			list=new ArrayList<>();
			for(int i=0; i<=M;i++) {
				list.add(new ArrayList<>());
				strahler[i]=new Node(0);
			}
			for(int i=0; i<P;i++) {
				stz=new StringTokenizer(br.readLine());
				int from=Integer.parseInt(stz.nextToken());
				int to=Integer.parseInt(stz.nextToken());
				list.get(from).add(to);
				degree[to]+=1;
			}	
			bfs();
			int maxR=0;
			for(int i=1;i<=M;i++) {
				if(strahler[i].x>maxR) {
					maxR=strahler[i].x;
				}
			}
			sb.append(test).append(" ").append(maxR).append("\n");
		}
		System.out.println(sb);
		

		
	}
	private static void bfs() {
		Queue<Integer> que=new ArrayDeque<>();
		for(int i=1;i<=M;i++) {
			if(degree[i]==0) {
				que.offer(i);
				strahler[i].x=1;
			}
		}
		while(!que.isEmpty()) {
			int n=que.poll();
			for(int target : list.get(n)) {
				if(strahler[n].x>=strahler[target].x) {
					strahler[target].add(strahler[n].x);
				}
				degree[target]-=1;
				if(degree[target]==0) {
					strahler[target].update();
					que.offer(target);
				}
			}
		}
	}
	

	
	
	
	
	
		
}
	

		
		
		
		

