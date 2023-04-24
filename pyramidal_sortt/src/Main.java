public class Main {
    public static void main(String[] args) {
        int[] array = {5,7,2,4,3,8,1,0,9};
        sortarr(array);
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + ", ");
    }
    public static void sortarr(int[] array) {
        int n = array.length;
        for(int i  = n / 2 - 1; i >= 0; i--)
            mainsort(array, i , n);
        for (int i = n - 1; i >= 0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            mainsort(array, 0, i);
        }
    }
    private static void mainsort(int[] array, int i, int n) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int rt = i;
        if(left < n && array[left] > array[rt])
            rt = left;
        if(right < n && array[right] > array[rt])
            rt = right;
        if (i != rt){
            int temp = array[i];
            array[i] = array[rt];
            array[rt] = temp;
            mainsort(array, rt, n);
        }
    }
}