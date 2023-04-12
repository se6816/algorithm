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

/**
 * 해당 문제는 모든 고도를 정렬한 뒤  투 포인터를 이용하면서 모든 K가 연결되는 최소의 고도 차를 찾으면 됩니다.
 * @author SSAFY
 *
 */
public class BJ2842{
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int w;
		public Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Node o) {
			
			return this.w-o.w;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", w=" + w + "]";
		}
		
		
	}
	public static int[] moveX= {-1,-1,0,1,1,1,0,-1};
	public static int[] moveY= {0,1,1,1,0,-1,-1,-1};
	public static boolean[][] canVisited;
	public static char[][] list;
	public static int[][] depth;
	public static int result;
	static int N;
	public static Node myLocation;
	public static int visitCnt;
	public static List<Node> gardenList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		N=Integer.parseInt(br.readLine());
		list=new char[N][N];
		depth=new int[N][N];
		canVisited=new boolean[N][N];
		gardenList=new ArrayList<>();
		result=1000001;
		visitCnt=0;
		for (int i = 0; i < N; i++) {
			char[] temp=br.readLine().toCharArray();
			for (int j = 0; j < temp.length; j++) {
				list[i][j]=temp[j];
				if(list[i][j]=='P') {
					myLocation=new Node(i,j);
				}
				if(list[i][j]=='K') {
					visitCnt+=1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			stz=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				depth[i][j]=Integer.parseInt(stz.nextToken());
			}
		}
		myLocation.w=depth[myLocation.x][myLocation.y];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(myLocation.x==i && myLocation.y==j) {
					continue;
				}
				gardenList.add(new Node(i,j,depth[i][j]));
			}
		}
		Collections.sort(gardenList);

		dfs(0,0);
		System.out.println(result);
		
	}
	private static void dfs(int start, int end) {
		Node init=gardenList.get(start);
		canVisited[myLocation.x][myLocation.y]=true;
		canVisited[init.x][init.y]=true;
		while(start<=end) {
			if(isPossible(start,end)) {
				result=Math.min(result, getDiff(start,end));
				Node n=gardenList.get(start);
				canVisited[n.x][n.y]=false;
				start++;
			
			}else {
				end++;
				if(end>=gardenList.size()) {
					break;
				}
				Node n2=gardenList.get(end);
				canVisited[n2.x][n2.y]=true;
			}
		}
		
	}
	private static int getDiff(int start, int end) {
		Node n=gardenList.get(start);
		Node n2=gardenList.get(end);
		int min=Math.min(myLocation.w, Math.min(n.w, n2.w));
		int max=Math.max(myLocation.w, Math.max(n.w, n2.w));
		return max-min;
	}
	private static boolean isPossible(int start, int end) {
		boolean[][] visited=new boolean[N][N];
		int cnt=0;
		Queue<Node> que=new ArrayDeque<>();
		que.offer(new Node(myLocation.x,myLocation.y));
		visited[myLocation.x][myLocation.y]=true;
		
		while(!que.isEmpty()) {
			Node n=que.poll();
			for(int i=0; i<8;i++) {
				int tempX=n.x+moveX[i];
				int tempY=n.y+moveY[i];
				if(tempX<0 ||tempY<0 || tempX>=N ||tempY>=N) {
					continue;
				}
				if(!canVisited[tempX][tempY]) {
					continue;
				}
				if(visited[tempX][tempY]) {
					continue;
				}
				if(list[tempX][tempY]=='K') {
					cnt+=1;
				}
				visited[tempX][tempY]=true;
				que.offer(new Node(tempX,tempY));
				
			}
		}
		if(cnt==visitCnt) {
			return true;
		}else {
			return false;			
		}
	}
	
	
		
}
	

		
		
		
		

