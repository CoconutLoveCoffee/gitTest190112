package string.one;

public class StringInverse {
	
	public static void main(String[] org){
		String str = "abcdef";
		String string = solution(str,2);
		System.out.println(string);

	}
	
	public static void inverse(char a[],int start,int end){
		while(start<end){
			char temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}
	public static String solution(String string,int length){
		length = length%string.length();//若要左移动大于string.length() 位，那么和%string.length() 是等价的
		char a[] = string.toCharArray();
		inverse(a,0,length-1);//套用到上面举的例子中，即 ab->ba
		inverse(a,length,a.length-1);//即 cdef->fedc
		inverse(a,0,a.length-1);//即如整个反转，即 bafedc->cdefab
		String str = String.valueOf(a);
		return str;
	}

}
