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
 * 해당 문제는 위상 정렬문제이다. 
 * 그러나 주의할 점이 있다. 연속적으로 정렬이 이루어지면서 하는 것이 아닌
 * 1번째 턴에 선수 아이템 없는 것들끼리 모아서 정렬하여 처리하고
 * 처리가 다 끝나고 2번 째 턴에 선수 아이템이 없는 것들끼리 모아서 처리하는 것을 반복해야 한다. 
 * 
 * @author user
 *
 */
public class Main{

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
	

		
		
		
		

