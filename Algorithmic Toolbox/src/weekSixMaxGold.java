import java.util.*;

public class weekSixMaxGold {
	private static Random random = new Random();
	
	static int optimalWeight(int W, int[] w) {
		
		int n = w.length;
		
		quickSort(w, 0, n-1);
		
		int weight = 0;
		int[] value = new int[W+1];
		
		for(int t = 0; t < value.length-1; t++) {
			value[t] = 0;
		}
		
		for(weight=1; weight <=W; weight++) {

			int i =0;
			while(w[i] <= weight) {
			
				if(value[i] <= value[i-1] + w[i] ) {
					value[i] = value[i-1] + w[i];
				}
				i++;
				}
			}
		
		
		return value[W+1];
    }

	
	private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void quickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        int m = partition2(a, l, r);
        quickSort(a, l, m - 1);
        quickSort(a, m + 1, r);
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

