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
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ19238{
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
		
	}
	public static int[] moveX= {-1,0,1,0};
	public static int[] moveY= {0,1,0,-1};
	public static Node myLocation;
	public static Map<Node,Node> map;
	public static int N;
	public static int remainGas;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		map=new HashMap<>();
		stz=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stz.nextToken());
		int M=Integer.parseInt(stz.nextToken());
		remainGas=Integer.parseInt(stz.nextToken());
		int[][] list=new int[N][N];
		for(int i=0; i<N;i++) {
			stz=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				// 0은 빈칸 1은 벽
				list[i][j]=Integer.parseInt(stz.nextToken());
			}
		}
		stz=new StringTokenizer(br.readLine());
		myLocation=new Node(Integer.parseInt(stz.nextToken())-1,Integer.parseInt(stz.nextToken())-1); 
		for(int i=0; i<M;i++) {
			stz=new StringTokenizer(br.readLine());
			map.put(new Node(Integer.parseInt(stz.nextToken())-1,Integer.parseInt(stz.nextToken())-1), new Node(Integer.parseInt(stz.nextToken())-1,Integer.parseInt(stz.nextToken())-1));
		}
		int client=map.size();
		while(client!=0) {
			Node idx=drive(list);
			if(idx.x==Integer.MAX_VALUE) {
				remainGas=-1;
			}
			if(remainGas==-1) {
				break;
			}
			client--;
		}
		System.out.println(remainGas);
		
		
	}
	private static Node drive(int[][] list) {
		Node result=new Node(Integer.MAX_VALUE,Integer.MAX_VALUE);
		Queue<Node> que=new ArrayDeque<>();
		boolean[][] visited=new boolean[N][N];
		que.offer(new Node(myLocation.x,myLocation.y));
		visited[myLocation.x][myLocation.y]=true;
		int len=0;
		while(!que.isEmpty()) {
			int size=que.size();
			while(size--!=0){
				Node n=que.poll();
				if(map.containsKey(new Node(n.x,n.y))) {
					if(result.x>n.x) {
						result=new Node(n.x,n.y);
					}else if(result.x==n.x && result.y>n.y) {
						result=new Node(n.x,n.y);
					}
				}
				for(int i=0; i<4;i++) {
					int tempX=n.x+moveX[i];
					int tempY=n.y+moveY[i];
					if(tempX<0 || tempY<0 || tempX>=N ||tempY >=N) {
						continue;
					}
					if(visited[tempX][tempY]) {
						continue;
					}
					if(list[tempX][tempY]==0) {
						visited[tempX][tempY]=true;
						que.offer(new Node(tempX,tempY));
					}
				}
			}
			if(result.x!=Integer.MAX_VALUE) {
				Node target=map.get(result);
				int arrivedDistance=search(result,target,list);
				if(arrivedDistance==-1) {   // 고객이 도착지로 가야하는데 도착지가 벽으로 감싸져 있을 경우
					remainGas=-1;
				}else if(remainGas>=(len+arrivedDistance)) {   // 원하는 목적지까지 가스가 충분할 경우
					remainGas-=len+arrivedDistance;
					remainGas+=arrivedDistance*2;
					
					myLocation.x=target.x;
					myLocation.y=target.y;

					map.remove(result);
				}else {                                       // 목적지까지 가스가 모자랄 경우
					remainGas=-1;
				}
				break;
			}
			len++;
		}
		return result;
	}
	private static int search(Node result, Node node,int[][] list) {
		Queue<Node> que=new ArrayDeque<>();
		boolean[][] visited=new boolean[N][N];
		que.offer(result);
		visited[result.x][result.y]=true;
		int len=0;
		while(!que.isEmpty()) {
			int size=que.size();
			while(size--!=0){
				Node n=que.poll();
				if(n.equals(node)) {
					return len;
				}
				for(int i=0; i<4;i++) {
					int tempX=n.x+moveX[i];
					int tempY=n.y+moveY[i];
					if(tempX<0 || tempY<0 || tempX>=N ||tempY >=N) {
						continue;
					}
					if(visited[tempX][tempY]) {
						continue;
					}
					if(list[tempX][tempY]==0) {
						visited[tempX][tempY]=true;
						que.offer(new Node(tempX,tempY));
					}
				}
			}
			len++;
		}
		return -1;
	}

	
		
}
	

		
		
		
		

