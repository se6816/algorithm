import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
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
 * 해당 문제는 그리디 문제이다.
 * 답을 구하는 방식은 map에 특정 알파벳의 자릿수 값을 더하고
 * 자릿수 값을 다 더한 다음 가장 큰 값을 가진 수부터 9부터 차례대로 배정하고
 * 그 값을 더한 값을 반환한다. 
 * 
 * @author user
 *
 */
public class BJ1339{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		Map<Character,Integer> map=new HashMap<>();
		int N=Integer.parseInt(br.readLine());
		for(int i=0; i<N;i++) {
			char[] temp=br.readLine().toCharArray();
			for(int j=0; j<temp.length;j++) {
				char ch=temp[j];
				int num=(int)Math.pow(10, (temp.length-1)-j);
				map.put(ch, map.getOrDefault(ch, 0)+num); // 우선순위를 정하기 위해 알파벳별 가중치 더하기
			}
		}
		for(Map.Entry<Character,Integer> entry : map.entrySet()) {
			pq.offer(entry.getValue());
		}
		int sum=0;
		int c=9;
		while(!pq.isEmpty()) {
			int num=pq.poll();
			sum+=c*num;
			c--;
		}
		System.out.println(sum);
		
		
	}
	
	

	
	
	
	
	
		
}
	

		
		
		
		

