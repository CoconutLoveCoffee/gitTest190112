package string.one;

public class StringContain {
	
	public static void main(String[] arg){
		System.out.println(solution("abcdef","abc"));
	}
	
	public static boolean solution(String orgStr,String targetStr){
		char[] org = orgStr.toCharArray();
		char[] target = targetStr.toCharArray();
		int hash = 0;
		for(int i=0;i<org.length;i++){
			hash |= (1<<(org[i]-'A'));
		}
		for(int j=0;j<target.length;j++){
			if((hash & (1<<target[j])) ==0){
				return false;
			}
		}
		return true;
	}
}
