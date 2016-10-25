package edu.hit.arrays;

public class statisticsUtils {
	public static void main(String[] args) {
		//float[] height = {17.0,17.0,18.0,19,22,23,25,28,18.5,20,22,23,22.4,24.6,28.5,30.9,34,16.5,22.5,26.5,23.5,22.6};
		float[] height = {1, 3, 6, 6, 6, 7, 7, 7, 12, 12, 12};
		//float[] height = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};//, 11
		//float[] height = {17};
		sort(height);		
		System.out.println("range="+range(height));
		System.out.println("mean="+mean(height));
		System.out.println("variance="+variance(height));
		System.out.println("median="+median(height));
				
		mode(height);
	}
	public static float mean(float[] items){
		int quantity = items.length;
		if(quantity==0)return 0.0f;
		float sum=0.0f;
		for(int i=0;i<quantity;i++){
			//System.out.println(items[i]);
			sum = sum + items[i];
		}
		return sum/quantity;
	}
	public static float variance(float[] items){
		float mean= mean(items);
		float variance =0.0f;

		for(int i=0;i<items.length;i++){
			variance=variance+(items[i]-mean)*(items[i]-mean);
		}
		variance=variance/items.length;
		variance = (float) Math.sqrt(variance);		
		return variance;
	}
	public static float median(float[] items){
		int quantity = items.length;
		int k=quantity%2;
		//System.out.println(k);
		//System.out.println(quantity/2);
		if(k==0)return (items[quantity/2-1]+items[quantity/2])/2;
		else return items[quantity/2];
	}
	public static float range(float[] items){
		int quantity = items.length;
		if (quantity<=1)return 0.0f;
		else return (items[quantity-1]-items[0]);
	}
	//输入的数组必须是排序的
	public static void mode(float[] items){
		int quantity = items.length;
		int modes[] = new int[quantity];
		int tags[] = new int[quantity];
		for(int i=0;i<quantity;i++) modes[i]=1 ;
		//for(int i=0;i<quantity;i++) System.out.println(tags[i]);
		int k=0;
		int j=0;
		for(int i=0; i<quantity ;i++){
			k++;
			if (i==(quantity-1)) continue;
			if (items[i]!=items[i+1]) continue;

			for(j=i+1;j<quantity;j++)
				if(items[i]==items[j] ){
					modes[i]++;
					tags[j]=1;
					k++;
				}else{
					i=j;
					//System.out.println("i="+i);
					k++;

				}

		}
		//System.out.println("k="+k);
		int max=modes[0];
		for(int i=0;i<quantity;i++){
			if (modes[i]>=max) max=modes[i];
			//if(tags[i]==0) System.out.println(""+items[i]+" "+modes[i]);
		}
		if (max==1){ 
			System.out.println("{}");
			return;
		}
		//System.out.println("max="+max);
		String s="";
		int flag=0;
		for(int i=0;i<quantity;i++){
			if (modes[i]==max){
				if(flag==0) {
					s=""+items[i];
					flag=1;
				}else{
					s=s+","+items[i];
				}
				
			}
		}
		System.out.println("modes={"+s+"}");
		
		//return modes;
	}
	//
	public static void sort(float[] items){
		int quantity = items.length;
		float tmp=0.0f;
		for(int i=0;i<quantity;i++)
			for(int j=i+1;j<quantity;j++)
				if(items[i]>items[j]){
					tmp=items[j];
					items[j]=items[i];
					items[i]=tmp;
				}
		//return items;
	}
}
