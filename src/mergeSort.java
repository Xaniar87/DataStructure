import java.util.Arrays;

public class mergeSort {


    public static void main(String[] args){

        int[] arr={100,5,2,88,15,12,17,3,23,5,6};
        System.out.println("main input: "+Arrays.toString(arr));
        int[] sorted=mergeSort(arr,0,arr.length-1);
        System.out.println("main output: "+Arrays.toString(sorted));
    }
    public static int[] mergeSort(int[] array, int left, int right){
        if (left<right){
            int med=left+(right-left)/2;//cause I am using int for med, it will return only the integer part of the division
            mergeSort(array,left,med);
            mergeSort(array,med+1,right);
            merge(array,left,med,right);
        };
        return array;
    }
    public static int[] merge(int[] arr, int left, int med, int right){
        int ind1=0;
        int ind2=0;
        int len1=med-left+1;
        int len2=right-med;
//        System.out.println(len1+ " len   "+ len2);
//        System.out.println("left: "+left+ " "+ (med)+ "   right: "+(med)+" "+right);
        int[] arr1=new int[len1];
        int[] arr2=new int[len2];
        for (int i=0;i<len1;i++){
            arr1[i]=arr[left+i];
        }
        for (int j=0;j<len2;j++){
            arr2[j]=arr[med+j+1];
        }
//        System.out.println("arr1: "+Arrays.toString(arr1));
//        System.out.println("arr2: "+Arrays.toString(arr2));
        while (ind1<arr1.length && ind2< arr2.length){
            if (arr1[ind1]>arr2[ind2]) {
                arr[left+ind1 + ind2] =arr2[ind2];
                ind2++;
            }else{
                arr[left+ind1 + ind2] =arr1[ind1];
                ind1++;
            }
        }
        if (ind1==arr1.length) {
            while (ind2 < arr2.length) {
                arr[left+ind1 + ind2] = arr2[ind2];
                ind2++;
            }
        }else if(ind2==arr2.length){
            while(ind1 < arr1.length) {
                arr[left+ind1 + ind2] = arr1[ind1];
                ind1++;
            }
        }
//        System.out.println("merge output: "+Arrays.toString(arr)+"\n");
        return arr;
    }
}
