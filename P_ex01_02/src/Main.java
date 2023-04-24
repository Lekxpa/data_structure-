public class Main {
    // для трех шестигранных кубиков
    public static void main(String[] args) {

    }
    public static double findSum(int sum){
        int count = 0;
        int sucsessResult = 0;
        for(int i = 1; i <= 6; i ++){
            for(int j = 1; j <= 6; j++){
                for(int k = 1; k <= 6; k++){
                    if(i + j + k = sum){
                        sucsessResult++;
                    }
                    count++;
                }
            }
        }
        return ((double) sucsessResult) / ((double) count);
    }
}