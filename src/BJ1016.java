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
 * �ش� ������ �Ƹ������׳׽��� ü�� �̿��� �����̴�.
 * ���õ� ������ ���� min�� ���� ��û ũ���� �ᱹ min�� max ���̿����� ���� 100�� �����̰�
 * �� 100���� ���Ͽ� �Ƹ������׳׽��� ü�� �̿��ϸ� Ǯ ���ִ� �����̴�.
 * �� ���� ������ ���� ��� �������� long���� �ؾ� �Ѵ�. 
 * @author SSAFY
 *
 */
public class BJ1016{
	public static boolean[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		StringBuilder sb=new StringBuilder();
		stz=new StringTokenizer(br.readLine());
		long min=Long.parseLong(stz.nextToken());
		long max=Long.parseLong(stz.nextToken());
		int cnt=0;
		result=new boolean[1000001];
		for(long i=2; i<=Math.min(Math.sqrt(Long.MAX_VALUE), Math.sqrt(max));i++) {
			
			long multi=i*i;
			long remain=min%multi;
			long start=0;
			if(remain!=0) {
				start=multi-remain;
			}
			while(start>=0 && start<result.length) {
				result[(int)start]=true;
				start+=multi;
			}
		}
		for(int i=0; i<=(max-min);i++) {
			if(!result[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
	}
	
	

	
		
}
	

		
		
		
		

