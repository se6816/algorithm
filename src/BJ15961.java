import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ15961 {
	

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int result=0;
		Map<Integer,Integer> map=new HashMap<>();
		stz=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(stz.nextToken()); // 접시 수 
		int d=Integer.parseInt(stz.nextToken()); // 초밥 가짓 수
		int k=Integer.parseInt(stz.nextToken()); // 연속 해서 먹는 접시의 수
		int c=Integer.parseInt(stz.nextToken()); // 쿠폰 번호 
		int[] list=new int[N];
		map.put(c, 1);
		for(int i=0; i<N;i++) {
			list[i]=Integer.parseInt(br.readLine());
		}
		for(int i=0; i<k;i++) {
			map.put(list[i], map.getOrDefault(list[i], 0)+1);
		}
		result=map.size();
		for(int i=k;i<N+k;i++) {
			int idx=i%N;
			if(map.get(list[((i+N)-k)%N])==1) {
				map.remove(list[((i+N)-k)%N]);
			}else {
				map.put(list[((i+N)-k)%N], map.get(list[((i+N)-k)%N])-1);
			}
			map.put(list[idx], map.getOrDefault(list[idx], 0)+1);
			result=Math.max(result, map.size());
			if(result==d) {
				break;
			}
		}
		System.out.println(result);
	}
	
}
