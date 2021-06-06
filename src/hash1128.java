public class hash1128 {

    public int numEquivDominoPairs(int[][] dominoes) {
        if(dominoes == null || dominoes.length == 0) return 0;
        int[] arr = new int[100];
        int cnts = 0;
        for(int i = dominoes.length-1;i>=0;i--){
            int a = dominoes[i][0];
            int b = dominoes[i][1];
            int val = a>b ? a*10+b : a+10*b;
            cnts+=arr[val];
            arr[val]++;
        }

        return cnts;
    }

    //[[1,2],[1,2],[1,1],[1,2],[2,2]]
    public static void main(String[] args) {
        hash1128 obj = new hash1128();
        int[][] arr = new int[][]{
                {1,2},
                {1,2},
                {1,1},
                {1,2},
                {2,2}
        };
        int i = obj.numEquivDominoPairs(arr);
        System.out.println(i);
    }
}
