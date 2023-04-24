import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr[] = {7, 4,5,1,8,2};
        System.out.println(Arrays.toString(arr));
        int size = arr.length;
        for(int i =0; i < size; i ++){
            for (int j = 0; j < size-1; j ++){
                if(arr[j] > arr[j + 1]){
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }

            }
        }
        System.out.println(Arrays.toString(arr));
    }

}