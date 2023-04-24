public class Main {
    public static void main(String[] args){
        int[] array = new int[]{
                4,2,5,8,1,9,2,3,6,8,5
        };
        bubleSort(array);
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i] + " ");
        }
    }
    public static void bubleSort(int[] array) {
        boolean finish = true;
        do{
            finish = true;
            for(int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;
                }
            }
        }while (!finish);
    }
}