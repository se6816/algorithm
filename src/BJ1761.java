
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 해당 문제는 두 노드 간의 거리를 구하는 문제이다.
 * 루트노드는 따로 지정되지 않았기에 임의로 지정해도 된다.
 * 먼저 루트노드를 임의로 지정한다. 그리고 DFS를 통하여 DEPTH를 지정해준다.
 * 그리고 LCA알고리즘을 통하여 값을 구하는 것인데 여기서 올라간 경로의 수에 따라 while문으로 계산을 하면 LCA를 한번 돌릴 떄마다
 * 그 값을 더하는 시간까지 더해져 최악의 경우 시간 복잡도가 O(log N)이 아니라 O(N+logN)이 되어버린다.
 * 그래서 거리에 대한 값도 부모테이블처럼 값을 미리 저장해둬야 시간 복잡도를 피할 수 있다.
 * @author user
 *
 */
public class BJ1761 {
	static class Node{
		int target;
		int weight;
		public Node(int target, int weight) {
			this.target = target;
			this.weight = weight;
		}
		
	}
	public static int N;
	public static int root;
	public static int[][] parents; // 부모 테이블
	public static int[][] dist;
	public static int[] depth;
	public static int[][] dp;
	public static int maxDeep;
	public static List<ArrayList<Node>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		;
		StringTokenizer stz;
		StringBuilder sb=new StringBuilder();
		
		list=new ArrayList<>();
		N=Integer.parseInt(br.readLine());
		maxDeep=0;
		while(true) {
			if((N+1)<(1<<maxDeep)) {
				break;
			}else {
				maxDeep++;
			}
		}
		parents=new int[N+1][maxDeep];
		dist=new int[N+1][maxDeep];
		depth=new int[N+1];
		
		for(int i=0; i<=N;i++) {
			list.add(new ArrayList<>());
			parents[i][0]=i;
		}
			
		for(int i=0; i<N-1;i++) {
			stz=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(stz.nextToken());
			int B=Integer.parseInt(stz.nextToken());
			int w=Integer.parseInt(stz.nextToken());
			
			list.get(A).add(new Node(B,w));
			list.get(B).add(new Node(A,w));
		}
		root=1;
		dfs(root,1);
		init();
		int M=Integer.parseInt(br.readLine());
		for(int i=0; i<M;i++) {
			stz=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(stz.nextToken());
			int B=Integer.parseInt(stz.nextToken());
			int result;
			if(depth[A]>depth[B]) {
				result=LCA(A,B);
			}else {
				result=LCA(B,A);
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	
	}
	// a가 좀더 깊이가 깊다는 가정이다.
	private static int LCA(int a, int b) {
		int cnt=0;
		for(int i= maxDeep-1;i>=0;i--) {
			if(depth[a]-depth[b]>=(1<<i)) {
				cnt+=dist[a][i];
				a=parents[a][i];
			}
		}
		if(a==b) {
			return cnt;
		}
		
		if(parents[a][0]!=parents[b][0]) {
			for(int i=maxDeep-1;i>=0;i--) {
				if(parents[a][i]!=parents[b][i]) {
					cnt+=dist[a][i]+dist[b][i];
					a=parents[a][i];
					b=parents[b][i];
				}
			}
		}
		return cnt+dist[a][0]+dist[b][0];
		
	}
	private static void init() {
		for(int i=1;i<maxDeep;i++) {
			for(int j=1; j<=N;j++) {
				parents[j][i]=parents[parents[j][i-1]][i-1];
				dist[j][i]=dist[j][i-1]+dist[parents[j][i-1]][i-1];
			}
		}
	}
	private static void dfs(int vtx,int deep) {
		depth[vtx]=deep;
		for(Node node : list.get(vtx)) {
			if(depth[node.target]==0) {
				parents[node.target][0]=vtx;
				dist[node.target][0]=node.weight;
				dfs(node.target,deep+1);
			}
		}
	}
}
