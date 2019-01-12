package yushao.array.one;

public class TopNums {
	public static void main(String[] args) {
		int array[] = {0,9,2,6,8,1,6,11,10,4,5,20,123,33,7};
		quickSort(array,0,array.length-1,5);
	}
	public static void quickSort(int array[],int low,int high,int k){
		int i = low;
		int j = high;
		int tmp = array[i];//中间数
		while(i<=j){
//			将小于tmp的数换到tmp的左边
			while(array[j]>=tmp){
				if(0>--j){
					break;
				}
			}
			if(i<j){
				int tt  = array[i];
				array[i++] = array[j];
				array[j] = tt;
			}
//			将大于tmp的数换到tmp的右边
			while(array[i]<tmp){
				if(high<++i){
					break;
				}
			}
			if(i<j){
				int tt  = array[j];
				array[j--] = array[i];
				array[i] = tt;
			}
		}
//		输出一轮换位之后的数组
		System.out.println(tmp);
		for(int m = 0;m<=high;m++){
			System.out.print(array[m]+"     ");
		}
		System.out.println("=====");
		array[i] = tmp;
		if(i+1==k){
//			输出最小的k个数
			for(int m = 0;m<k;m++){
				System.out.print(array[m]+"     ");
			}
			System.out.println();
		}else if(i+1>k){
			quickSort(array,low,i-1,k);
		}else{
			quickSort(array,i+1,high,k);
			
		}
	}

}
