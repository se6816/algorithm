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
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		int N=Integer.parseInt(br.readLine());
		for(int i=0; i<N;i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		int sum=0;
		while(pq.size()>=2) {
			int first=pq.poll();
			int second=pq.poll();
			sum+=first+second;
			pq.offer(first+second);
		}
		System.out.println(sum);
	}
	
	

	
	
	
	
	
		
}
	

		
		
		
		

