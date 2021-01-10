public class recursion1611 {

    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0) return new int[]{};
        if(shorter == longer) return new int[]{shorter*k};

        int[] rst = new int[k+1];
        for(int i = 0;i<=k;i++){
            rst[i] = shorter*(k-i)+longer*(i);
        }

        return rst;
    }


}
