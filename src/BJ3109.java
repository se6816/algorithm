import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 해당 문제에서는 1열에서 M열까지 파이프를 겹치지 않고 연결하는 문제이다.
 *   
 * @author SSAFY
 *
 */
public class BJ3109{
	public static boolean[][] visited;
	public static boolean[][] list;
	public static int result=0;
	public static boolean isEnd;
	public static int N;
	public static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stz.nextToken());
		M=Integer.parseInt(stz.nextToken());
		visited=new boolean[N][M];
		list=new boolean[N][M];
		for(int i=0; i<N;i++) {
			char[] temp= br.readLine().toCharArray();
			for (int j = 0; j < temp.length; j++) {
				if(temp[j]=='.') {
					list[i][j]=true; 
				}else {
					list[i][j]=false;
				}
			}
		}
		for(int i=0; i<N;i++) {
			if(list[i][0]) {
				isEnd=false;
				dfs(i,0);
			}
		}
		System.out.println(result);
	}
	private static void dfs(int x, int y) {
		if(isEnd) {
			return;
		}
		list[x][y]=false;
		int[] moveX= {-1,0,1};
		int[] moveY= {1,1,1};
		if(y==M-1) {
			result+=1;
			isEnd=true;
			return;
		}
		
		for(int i=0; i<3;i++) {
			int tempX=x+moveX[i];
			int tempY=y+moveY[i];
			if(tempX < 0 || tempX >=N) {
				continue;
			}
			if(!list[tempX][tempY]) {
				continue;
			}
			dfs(tempX,tempY);
		}
		
	}
		
		
}
	

		
		
		
		

