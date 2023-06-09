package Arrays;

import java.util.*;

public class arr {

    public static void arra(){
        // creating an array
        // datatype arrayname[]= new datatype[size]
        int marks[]=new int[20];// we can't change array size at runtime. we must have to declare here..
        int numbers[]={1,2,3,4};
        String fruits[]={"apple","mango","orange"};


        // input/output 
        Scanner sc = new Scanner(System.in);
        marks[0]=sc.nextInt();//phy
        marks[1]=sc.nextInt();//chem

        System.out.println("The mark of physics is :"+marks[0]);
        System.out.println("The mark of chemistry is :"+marks[1]);


        //update
        marks[1]=299;
    }
    public static void update(int marks[]){
        for(int i=1;i<marks.length;i++){
            marks[i]=marks[i]+1;
            //here we don't need to return array bcz array pass by reference, it means when we pass array in any function then all the manipulation directly changes to orignial one.
        }
    }
    public static int lSearch(int arr[],int key){

        for(int i=0;i<arr.length;i++){
            if(key==arr[i]){
                return i;
            }
        }
        return -1;
    }
    public static int getLargest(int num[]){
        int largest=Integer.MIN_VALUE;// -infinity
        for(int i=0;i<num.length;i++){
            if(num[i]>largest){
                largest=num[i];
            }
        }
        return largest;
    }
    public static int bSearch(int num[], int key){
        int start=0, end=num.length-1;

        while(start<=end){
            int mid=(start+end)/2;
            if(num[mid]==key){
                return mid;
            }
            if(key>num[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
    public static void revArray(int num[]){
        int start=0;
        int end=num.length-1;
        while(start<end){
            int temp=num[end];
            num[end]=num[start];
            num[start]=temp;
            start++;
            end--;
        }
    }
    public static void pairs(int num[]){
        int length=num.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                System.out.print("("+num[i]+","+num[j]+")");
            }
            System.out.println();
        }
    }
    public static void subArray(int num[]){
        int length=num.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(num[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static int maxSubarray(int num[]){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        int length=num.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                currSum=0;
                for(int k=i;k<=j;k++){
                    currSum+=num[k];
                    if(currSum>maxSum){
                        maxSum=currSum;
                    }
                }
                
            }
            
        }
        return maxSum;
    }
   public static int kadane(int num[]){
    int currSum=0;
    int maxSum=Integer.MIN_VALUE;
    for(int i=0;i<num.length;i++){
        currSum=currSum+num[i];
        if(currSum<0){
            currSum=0;
        }
        maxSum=Math.max(currSum, maxSum);
    }
    return maxSum;
   }
   public static int trapWater(int arr[]){
    int l=arr.length;
    //calculate left boundary max
    int leftMax[]= new int[l];
    leftMax[0]=arr[0];
    for(int i=1;i<l;i++){
        leftMax[i]=Math.max(arr[i], leftMax[i-1]);
    }
    //calculate right boundary max
    int rightMax[]=new int[l];
    rightMax[l-1]=arr[l-1];
    for(int i=l-2;i>=0;i--){
        rightMax[i]=Math.max(arr[i],rightMax[i+1]);
    }

    //loop

    int trappedWater=0;

    for(int i=0;i<l;i++){
        int waterLevel=Math.min(leftMax[i], rightMax[i]);
        trappedWater+= waterLevel-arr[i];
    }

    return trappedWater;
   } 
   public static int buyAndSellStock(int arr[]){
    int maxProfit=0;
    int buyPrice=Integer.MAX_VALUE;

    for(int i=0;i<arr.length;i++){
        if(buyPrice<arr[i]){//profit
            int profit=arr[i]-buyPrice;
            maxProfit=Math.max(maxProfit, profit);
        }else{
            buyPrice=arr[i];
        }
    }
    return maxProfit;
   }
   public static void main(String args[]){
        //arra();
        //int mark[]={12,23,22};
        //update(mark);
        //_________Linear Search_______
        int number[]={2,3,4,5,6,24,22,25,8,5};
        int index=lSearch(number, 4);
        if (index==-1){
            System.out.println("The key is not found");
        }else{
            System.out.println("The key is found at index : "+index);
        }
        //__________Largest in array____________________
        System.out.println("The largest element in the array is : "+getLargest(number));

        //__________binary Search____________________
        int num[]={2,3,4,5,6,7,8,9};
        int bIndex=bSearch(num,7);
        if(bIndex==-1){
            System.out.println("The key is not found");
        }else{
            System.out.println("The key is found at index : "+bIndex);
        }
        //__________reverse array____________________
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();
        revArray(num);
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
        //__________pairs of array____________________
        System.out.println();
        int n[]={2,3,4,5,6,7,8,9};
        pairs(n);
        //__________subarrays____________________
        subArray(n);
        //__________Max subarray sum(Bruteforce)____________________
        System.out.println("The max sum of subarray is : "+maxSubarray(n) );
        //__________Max subarray sum(kadane's algo)____________________
        int knum[]={2,3,4,-2,-4,2,-3,32,-45,2};
        // int knum[]= {2,3,4,5,6,7,8,9};
        System.out.println(kadane(knum));

        //__________Trapped rain water____________________
        int height[]={4,2,0,6,3,2,5};
        System.out.println("The total trapped water is "+trapWater(height));


        //__________Buy and Sell stocks____________________
        int prices[]={7,1,5,3,6,4};
        System.out.println("The maximum profit is : "+ buyAndSellStock(prices));





    }
}
