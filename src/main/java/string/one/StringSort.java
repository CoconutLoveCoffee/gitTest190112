package string.one;

public class StringSort {
	public static void CalcAllPermutation(char[] perm, int from, int to) {
		if (to <= 1) {
			return;
		}
		if (from == to) {
			for (int i = 0; i <= to; i++)
				System.out.print(perm[i]);
			System.out.println();
		} else {
			for (int j = from; j <= to; j++) {
				//一步步固定字符位置
				char temp = perm[j];
				perm[j] = perm[from];
				perm[from] = temp;
				
				CalcAllPermutation(perm, from + 1, to);
				
				//还原字符串
				char temp2 = perm[j];
				perm[j] = perm[from];
				perm[from] = temp2;
			}
		}
	}
	public static void main(String args[]) {
		CalcAllPermutation("abcd".toCharArray(), 0, "abcd".length() - 1);
	}


}
