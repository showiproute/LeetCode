import java.util.Arrays;

public class binarySearch611 {

    public int triangleNumber(int[] nums) {
        //2 , 2  , 3  , 4 , 5 ,6 ,7 ,8
        /*
        2 ,2
         */
        Arrays.sort(nums);
        int cnts = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                int left = j+1;
                int right = nums.length-1;
                int k = j;
                while (left <= right) {
                    int mid = (left+right) /2 ;
                    if(nums[mid] < nums[i] + nums[j]) {
                        left = mid + 1;
                        k = mid;
                    }else if(nums[mid] >= nums[i]+nums[j]){
                        right = mid - 1;
                    }
                }
                cnts+= k - j;
            }
        }

        return cnts;
    }

    public static void main(String[] args) {
        int[] arr = {148,2,318,845,899,489,741,921,693,616,87,464,360,217,116,443,543,485,937,965,791,779,187,787,344,431,398,427,752,374,414,388,441,821,852,770,989,43,811,757,449,832,384,834,616,271,610,408,521,252,10,670,889,200,531,214,830,457,215,456,433,188,478,324,168,53,597,59,780,985,228,365,51,965,156,479,284,409,440,765,387,40,155,108,51,185,629,174,769,513,841,267,413,13,970,58,275,185,942,268,767,910,359,15,278,392,722,682,242,430,682,224,795,83,240,384,969,84,378,889,709,188,923,967,953,200,465,422,932,64,967,733,742,222,344,672,928,850,887,599,566,507,912,890,421,601,52,158,277,68,699,828,565,760,153,404,237,643,101,622,710,94,837,225,391,388,306,6,498,886,270,916,460,955,816,196,125,169,11,867,450,767,791,680,307,580,280,920,221,841,221,704,759,965,639,144,198,616,782,187,309,281,781,294,128,654,736,310,952,592,283,620,930,866,511,139,468,240,509,831,693,623,870,633,30,613,298,724,899,953,898,98,467,971,640,59,271,938,659,273,975,112,185,623,671,774,197,929,429,992,937,758,599,795,707,697,569,124,300,646,41,642,279,194,428,402,263,85,865,140,341,245,669,570,866,811,838,758,272,614,471,387,971,558,339,388,880,383,642,66,837,140,616,227,734,437,970,766,857,941,986,287,238,325,806,873,377,939,624,314,944,36,176,33,55,636,109,638,445,47,271,473,628,629,486,704,20,45,894,483,275,742,994,228,373,891,196,255,400,109,743,798,603,737,637,308,255,579,588,841,223,412,240,360,654,370,362,447,593,412,918,296,904,869,995,739,826,877,905,331,186,116,110,56,788,251,758,856,530,432,296,994,824,270,113,898,688,175,839,846,481,789,49,224,28,895,855,530,351,456,111,485,919,996,203,922,695,111,692,888,741,962,938,715,331,906,39,5,442,275,741,903,539,533,507,367,381,725,258,807,669,292,828,345,832,453,224,49,547,446,247,644,661,734,531,557,400,799,428,400,489,50,155,875,390,423,751,187,559,225,913,668,441,546,388,68,118,394,383,890,807,856,887,20,453,802,198,575,930,154,817,146,162,655,259,907,379,823,648,40,387,230,804,927,423,504,736,212,643,715,62,56,62,601,865,51,641,253,614,623,174,519,288,516,765,221,20,838,529,850,433,226,782,406,944,495,628,854,371,669,710,873,579,377,389,507,994,423,208,997,504,770,806,483,530,30,227,116,711,460,485,455,550,942,19,203,659,825,258,84,205,562,191,890,684,457,12,340,1,133,333,481,800,702,261,97,607,613,812,528,296,246,573,427,846,676,956,957,831,309,222,544,872,690,577,635,654,779,610,819,870,143,926,626,843,263,449,717,836,950,726,432,294,791,237,137,93,301,766,803,294,1000,246,155,873,422,752,826,525,109,481,652,540,507,552,75,973,740,870,662,164,39,245,639,791,46,845,483,936,905,518,298,616,745,251,649,478,513,451,40,596,221,222,314,183,489,512,263,597,405,952,436,289,138,283,643,688,17,218,191,26,713,144,321,79,60,140,767,55,300,82,936,316,227,937,372,705,627,722,553,352,295,828,308,136,798,822,397,79,81,528,986,563,22,10,276,945,337,365,680,268,395,315,713,538,199,835,503,253,643,780,841,652,259,17,884,347,540,777,723,992,64,429,189,653,153,803,426,554,466,890,1,374,914,942,391,107,51,859,317,211,407,130,728,706,219,471,781,835,532,638,767,912,791,176,831,863,595,301,225,750,762,693,913,716,784,531,934,415,93,771,910,211,686,366,488,245,998,729,998,462,165,167,371,802,382,143,479,344,468,579,786,550,749,10,858,652,581,754,25,451,681,276,320,227,400,650,260,189,372,846,971,100,248,579,547,589,953,324,757,121,688,336,418,328,316,827,557,671,763,769,267,784,19,566,119,6,613,850,616,17,361,883,54,558,149,428,429,993,572,182,720,904,12,914,974,739,31,582,866,184,662,713,458,412,977,188,867,22,301,833,977,665,167,95,740,404,969,287,78,168,850,340,530,774,764,208,37,301,937,433,825,645,745,466,617,123,661,474,961,407,88,605,546,264,594,157,664,910,819,284,325,592,806,320,73,125,132,607,548,32,315,603,147,59,603,413,883,651,905,313,516,326,516,182,215,773,322,937,827,290,946,608,651,618,131,761,799,34,818,357,914,316,621,791,606,370,237,143,807,349,989,864,123,990,750,795,220,42,443,498,586,440,574,557,345,95};
        binarySearch611 obj = new binarySearch611();
        int i = obj.triangleNumber(arr);
        System.out.println(i);
    }
}
