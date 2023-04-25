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
public class BJ14567{
	
	static boolean[] visited; // 방문
	static int[] degree; // 위상배열
	static int[] semesters; // 이수 학기
	static List<ArrayList<Integer>> list;
	static StringBuilder sb;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		sb=new StringBuilder();
		stz=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stz.nextToken()); // 과목의 수 
		int M=Integer.parseInt(stz.nextToken()); // 선수 조건
		degree=new int[N+1];
		semesters=new int[N+1];
		visited=new boolean[N+1];
		list=new ArrayList<>();
		for(int i=0; i<=N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0; i<M;i++) {
			stz=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(stz.nextToken());
			int to=Integer.parseInt(stz.nextToken());
			list.get(from).add(to);
			degree[to]+=1;
		}
		bfs();
		for(int i=1; i<=N;i++) {
			sb.append(semesters[i]+" ");
		}
		System.out.println(sb);
		
	}
	private static void bfs() {
		Queue<Integer> pq=new ArrayDeque<>();
		int num=1;
		for(int i=1; i<=N;i++) {
			if(degree[i]==0) {
				pq.offer(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int size=pq.size();
			while(--size>=0) {
				int n=pq.poll();
				semesters[n]=num;
				for(int target : list.get(n)) {
					degree[target]-=1;
					if(degree[target]==0) {
						pq.offer(target);
					}
				}				
			}
			num++;
		}
		
	}

	
	
	
	
	
		
}
	

		
		
		
		

