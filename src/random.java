import java.util.Random;

public class random {

    public static void main(String[] args) {
        Random random = new Random();
        for(int k = 0;k<13;k++){
            int i = random.nextInt(70) % (70 + 1);
            System.out.println(i);
        }
    }
}
