import java.util.*;

public class selection_sort{

    static void sort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int small=i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[small]>arr[j]){
                    small=j;
                }
            }
            int temp = arr[small];
            arr[small] = arr[i];
            arr[i] = temp;
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args){
        int arr[] = {2,4,3,6,1};
        sort(arr);
    }
            
}
