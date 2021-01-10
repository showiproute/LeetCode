public class hanoid {

    public void hano(int n,char A,char B,char C) {
        if(n <= 0) return;

        hano(n-1,A,C,B);
        move(A,C);
        hano(n-1,B,A,C);
    }

    public void move(char a,char c) {
        System.out.printf("move from %c to %c",a,c);
        System.out.println();
    }


    public static void main(String[] args) {
        hanoid obj = new hanoid();
        obj.hano(10,'A','B','C');
    }
}
