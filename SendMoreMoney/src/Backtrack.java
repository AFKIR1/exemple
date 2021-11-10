public class Backtrack { 
		// Ds = {D,E,Y,N,R,O,S,M}
	public static boolean condition1(int [] d) {
		if (d[2] == d[0]+d[1]) {
			return true;
		}
		else {
			return ((d[2]-(d[0]+d[1]))%10==0);
		}
		
	}
	
	public static boolean condition2(int [] d) {
		if (d[1] == (d[3]+d[4]+(d[0]+d[1])/10)) {
			return true;
		}
		else {
			return (d[1]-(d[3]+d[4]+(d[0]+d[1])/10))%10==0;
		}
		
	}
	
	public static boolean condition3(int [] d) {
		if (d[3] == (d[1]+d[5]+(d[3]+d[4])/10)) {
			return true;
		}
		else {
			return (d[3]-(d[1]+d[5]+(d[3]+d[4])/10))%10==0;
		}
		
	}
	
	public static boolean souscondition41(int [] d) {
		if (d[5] == (d[6]+d[7]+(d[1]+d[5])/10)) {
			return true;
		}
		else {
			return (d[5]-(d[6]+d[7]+(d[1]+d[5])/10))%10==0;
		}
		
	}
	
	public static boolean souscondition42(int [] d) {
		if (d[7] == (d[6]+d[7])/10) {
			return true;
		}
		else {
			return (d[7]-(d[6]+d[7])/10)%10==0;
		}
		
	}
	
	
	public static boolean condition4(int [] d) {
		if (souscondition41(d) & souscondition42(d)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static void affichier(int [] d) {
		System.out.println("d = " + Integer.toString(d[0]) + " ; e = " + Integer.toString(d[1]) + " ; y = "
				+ Integer.toString(d[2]) + " ; n = "+ Integer.toString(d[3]) + " ; r = " + Integer.toString(d[4]) + " ; o = " +
				Integer.toString(d[5]) + " ; s = "+ Integer.toString(d[6]) + " ; m = "+ Integer.toString(d[7]));
	}
	int [] d = {0,0,0,0,0,0,0,0};
	public static void solution(int [] d, int i,int k) {
		if (i == 7 & condition1(d) & condition2(d) & condition3(d) & condition4(d)) {
			affichier(d);
		}
		else {
			for(int j = k ; j<10 ; j++ ) {
				d[i] = j;
				if (condition1(d) & condition2(d) & condition3(d) & condition4(d)) {
					i++;
					solution(d,i,k);
				}
				else{
					if(i>0 & d[i]==9) {
						d[i] = 0;
						i--;
						d[i]++;
						k = d[i];
						solution(d,i+1,0);
					}
					
				}
				
			}
		}
	}
	
	

}
