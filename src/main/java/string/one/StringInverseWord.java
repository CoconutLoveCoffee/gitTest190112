package string.one;

public class StringInverseWord {
	public static void main(String[] args) {
		String str = "I am a student.";
		System.out.println(swapWords(str));
	}
	public static void swap(char[] cArr,int front,int end){
		while(front<end){
			char tmp = cArr[end];
			cArr[end] = cArr[front];
			cArr[front] = tmp;
			front++;
			end--;
		}
	}
	public static String swapWords(String s){
		char[] cArr = s.toCharArray();
		//对整个字符串进行字符反转操作
		swap(cArr,0,cArr.length-1);
		int begin = 0;
		//对每个单词进行字符反转操作
		for(int i = 1;i<cArr.length;i++){
			if(cArr[i]==' '){
				swap(cArr,begin,i-1);
				begin = i+1;
			}
		}
		swap(cArr,begin,cArr.length-1);
		return new String(cArr);
	}

}
