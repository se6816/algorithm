import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 해당 문제의 N은 100만이다. 그래서 dp를 이용하여 LIS를 돌리면 시간초과가 난다.
 * 그래서 해당 문제는 이분탐색을 이용하여 LIS를 진행해야 한다.
 * 그리고 추가적으로 입력을 좀더 최적화하면 메모리와 시간을 단축시킬 수 있다.
 * @author SSAFY
 *
 */
public class BJ14003{
	static int[] number;   // LIS 순서 저장 배열
	static int[] result;  // LIS 진행 저장 배열
	static final int MIN=1000_000_001;
	static int cnt;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
//		N=Integer.parseInt(br.readLine());
		N=readInt();
		cnt=0;
		number=new int[N];
		result=new int[N];
		Arrays.fill(result, MIN);
		int[] list=new int[N];
		List<Integer> resultList=new ArrayList<>();
//		stz=new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
//			list[i]=Integer.parseInt(stz.nextToken());
			list[i]=readInt();
		}
		for(int i=0; i<N;i++) {
			int idx=binarySearch(cnt,list[i]);
			number[i]=idx;
			result[idx]=list[i];
			cnt=Math.max(cnt, idx);
		}
		StringBuilder sb=new StringBuilder();
		sb.append(cnt+1).append("\n");
		for(int i=N-1;i>=0;i--) {
			if(number[i]==cnt) {
				resultList.add(list[i]);
				cnt--;
			}
		}
		
		for(int i=resultList.size()-1;i>=0;i--) {
			sb.append(resultList.get(i)).append(" ");
		}
		
		System.out.println(sb);
		
		
	}
	private static int binarySearch(int idx,int v) {
		int start=0;
		int end=idx;
		while(start<=end) {
			int mid=(end+start)/2;
			if(v>result[mid]) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return start;
		
	}
	static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input<=32)
                return isNegative ? n * -1 : n;
            else if(input=='-')
                isNegative = true;
            else
                n = (n<<3) + (n<<1) + (input&15);
        }
    }
	
		
}
	

		
		
		
		

