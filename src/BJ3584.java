

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 이 문제는 두 노드의 가장 가까운 공통 조상을 찾는 문제이다.
 * 물론 선형 탐색으로도 가능하다. 그러나 선형 탐색으로 LCA를 찾을 경우
 * 최악의 경우 O(N)의 시간 복잡도를 가지게 된다.
 * 그러나 아래처럼 DP를 이용하여 이분탐색을 하는 것처럼 탐색하면
 * 해당 알고리즘으로 시간 복잡도는 O(log N)으로 줄일 수 있다.
 * 
 * @author user
 *
 */
public class BJ3584 {
	public static int findParents(int n) {
		if(parents[n][0]==n) {
			return n;
		}
		return findParents(parents[n][0]);
	}
	public static int N;
	public static int root;
	public static int[][] parents; // 부모 테이블
	public static int[] depth;
	public static int[][] dp;
	public static int maxDeep;
	public static List<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer stz;
		StringBuilder sb=new StringBuilder();
		for(int test=0; test<T;test++) {
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
			depth=new int[N+1];
			
			for(int i=0; i<=N;i++) {
				list.add(new ArrayList<>());
				parents[i][0]=i;
			}
			
			for(int i=0; i<N-1;i++) {
				stz=new StringTokenizer(br.readLine());
				int parent=Integer.parseInt(stz.nextToken());
				int child=Integer.parseInt(stz.nextToken());
				list.get(parent).add(child);
				list.get(child).add(parent);
				parents[child][0]=parent;
			}
			root=findParents(1);
			dfs(root,1);
			init();
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
		for(int i= maxDeep-1;i>=0;i--) {
			if(depth[a]-depth[b]>=(1<<i)) {
				a=parents[a][i];
			}
		}
		if(a==b) {
			return a;
		}
		
		if(parents[a][0]!=parents[b][0]) {
			for(int i=maxDeep-1;i>=0;i--) {
				if(parents[a][i]!=parents[b][i]) {
					a=parents[a][i];
					b=parents[b][i];
				}
			}
		}
		return parents[a][0];
		
	}
	private static void init() {
		for(int i=1;i<maxDeep;i++) {
			for(int j=1; j<=N;j++) {
				parents[j][i]=parents[parents[j][i-1]][i-1];
			}
		}
	}
	private static void dfs(int vtx,int deep) {
		depth[vtx]=deep;
		for(int target : list.get(vtx)) {
			if(depth[target]==0) {
				dfs(target,deep+1);
			}
		}
	}
}
