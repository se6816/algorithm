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
 * 해당 문제는 단순한 그리디 문제이다. 
 * 
 * @author user
 *
 */
public class BJ1715{
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
	

		
		
		
		

