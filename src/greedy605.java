public class greedy605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0;i<flowerbed.length;i++){
            if(i == 0){
                if(flowerbed[i] == 0) {
                    if(flowerbed.length < 2) {
                        return n <= 1;
                    }else{
                        if(flowerbed[i+1] == 0) {
                            flowerbed[i] = 1;
                            n--;
                        }
                    }
                }
            }else if (i == flowerbed.length -1 ) {
                if(flowerbed[i] == 0) {
                    if(flowerbed[i-1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }else{
                if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        return n <= 0 ;
    }

    public static void main(String[] args) {
        //1,0,0,0,1
        int[] nums ={0,0,1,0,0};
        greedy605 obj = new greedy605();
        boolean b = obj.canPlaceFlowers(nums, 1);
        System.out.println(b);
    }


}
