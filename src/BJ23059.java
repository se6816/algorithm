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
public class BJ23059{
	static StringBuilder sb;
	static Map<String, Integer> degree;
	static Map<String, List<String>> relations;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		degree=new HashMap<>();
		relations=new HashMap<>();
		sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine()); // 관계 수
		for(int i=0; i<N;i++) {
			stz=new StringTokenizer(br.readLine());
			String from=stz.nextToken();
			String to=stz.nextToken();
			relations.put(to,relations.getOrDefault(to,new ArrayList<>()));
			List<String> list=relations.get(from);
			if(list==null) {
				list=new ArrayList<>();
			}
			list.add(to);
			relations.put(from, list);
			degree.put(from,degree.getOrDefault(from,0));
			Integer num =degree.get(to);
			if(num==null) {
				num=0;
			}
			num+=1;
			degree.put(to, num);
		}
		bfs();
		for(String s : degree.keySet()) {
			if(degree.get(s)!=0) {
				sb.setLength(0);
				sb.append(-1);
				break;
			}
		}
		System.out.println(sb);
		

		
	}
	private static void bfs() {
		PriorityQueue<String> pq=new PriorityQueue<>();
		List<String> list=new ArrayList<>();
		for(String s : degree.keySet()) {
			if(degree.get(s)==0) {
				list.add(s);
			}
		}
		while(true) {
			pq.addAll(list);
			list.clear();
			while(!pq.isEmpty()) {
				String st= pq.poll();
				sb.append(st).append("\n");
				for(String s : relations.get(st)) {
					degree.put(s, degree.get(s)-1);
					if(degree.get(s)==0) {
						list.add(s);
					}
				}
			}
			if(list.size()==0) {
				break;
			}
		}
		
	}
	
	

	
	
	
	
	
		
}
	

		
		
		
		

