import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 1일, 1달, 3달, 1년
// 1. 각 이용권의 가격을 입력받는다.
// 2. 월별 이용계획을 입력받는다.
// 3. 이용 요금을 계산한다.
// 3-1. 모두 1일 이용권으로만 사용하는 경우 -> 이용하는 날짜 총합 * 1일 이용권 가격
// 3-2. 1년 이용권 사용하는 경우 -> 1년 이용권 1장 가격
// 4. 이용권을 사용하는 부분집합을 구한다
// 4-1. sum이 현재 minPrice보다 크면 더이상 구하지 않는다
// 4-2. 모든 달에 대해서 구했으면 minPrice를 업데이트한다 (이때의 sum 은 무조건 minPrice)
// 4-3. 각 달에 대해서 어떤 이용권을 쓸지 정한다
// 		- 11월 부터는 3달 이용권을 구매할 수 없다
//      - 해당 달에 이용일수가 0인 경우에는 이용권을 사거나/사지 않거나 할수 있다


public class Solution {
    static BufferedReader bf;
    static StringTokenizer st;
    static StringBuilder sb;
    static int price[] = new int[4];
    static int month[] = new int[12];
    static int daySum;
    static int minPrice;
    
    public static void powerSet(int elementIdx, int sum) {
    	// 4-1. sum이 현재 minPrice보다 크면 더이상 구하지 않는다
    	if(sum >= minPrice) return;
    	
    	// 4-2. 모든 달에 대해서 구했으면 minPrice를 업데이트한다 (이때의 sum 은 무조건 minPrice)
    	if(elementIdx == 12) {
    		minPrice = Math.min(minPrice, sum);
    		return;
    	}
    	
    	
		// 4-3. 각 달에 대해서 어떤 이용권을 쓸지 정한다
		powerSet(elementIdx+1, sum + month[elementIdx] * price[0]);
		powerSet(elementIdx+1, sum + price[1]);
//     	- 11월 부터는 3달 이용권을 구매할 수 없다
		if(elementIdx < 10) powerSet(elementIdx+3, sum + price[2]);
//      - 해당 달에 이용일수가 0인 경우에는 이용권을 사거나/사지 않거나 할수 있다
		if(month[elementIdx] == 0) powerSet(elementIdx+1, sum);
    	
    }
      
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int Test = Integer.parseInt(bf.readLine().trim());
         
        for(int tcase = 1; tcase <= Test; tcase++) {
        	
        	// 1. 각 이용권의 가격을 입력받는다.
        	st = new StringTokenizer(bf.readLine().trim());
        	for(int idx = 0; idx<4; idx++) {
        		price[idx] = Integer.parseInt(st.nextToken());
        	}
        	// 2. 월별 이용계획을 입력받는다.
        	st = new StringTokenizer(bf.readLine().trim());
        	for(int idx = 0; idx<12; idx++) {
        		month[idx] = Integer.parseInt(st.nextToken());
        		daySum += month[idx];
        	}
        	// 3. 이용 요금을 계산한다.
        	// 3-1. 모두 1일 이용권으로만 사용하는 경우 -> 이용하는 날짜 총합 * 1일 이용권 가격
        	// 3-2. 1년 이용권 사용하는 경우 -> 1년 이용권 1장 가격
        	minPrice = Math.min(price[3], daySum*price[0]);
        	// 4. 이용권을 사용하는 부분집합을 구한다
        	powerSet(0, 0);
        	
        	System.out.println("#" + tcase + " " + minPrice);
            
        }
         
    }
}
