package leetcode;

public class LocalTest2 {
    public static void main(String[] args) {
        /*double[] compress_ratio = {1, 0.945976, 0.456963, 0.389478, 1};
        double[] compress_speed = {0.410591, 0.304972, 0.959953, 1, 0.361761};
        double[] uncompress_speed = {0.895684, 0.490017, 0.977078, 1, 0.90604};
        // warm_alg
        int warm_alg = -1;
        double max = 0;
        for (int i = 0;i < 5;i++){
//            double v = 0.5 * compress_ratio[i] + 0.5 * compress_speed[i];
//            double v = 1 * compress_ratio[i] + 0 * compress_speed[i];
            double v = 0 * compress_ratio[i] + 1 * compress_speed[i];
            if (v>max){
                max = v;
                warm_alg=i;
            }
        }
        System.out.println("max: " + max);
        System.out.println("warm_alg: " + warm_alg);*/

        test01();
        test02();
    }
    public static void test01(){
        long[] compress_size={44630016,17758047,18355086,26384964,28080341,17758059};
        long[] compress_time={6364,8568,2722,2613,7223};
        long[] uncompress_time={2713,4959,2487,2430,2682};

        double[] compress_size2 = new double[6];
        double[] compress_time2 = new double[5];
        double[] uncompress_time2 = new double[5];

        long max_size = 44630016;
        long min_size = 17758047;

        long max_comTime = 8568;
        long min_comTime = 2613;

        for (int i = 0;i < compress_size.length;i++){
            compress_size2[i] = (compress_size[i] - min_size)*1.0/(max_size-min_size);
            System.out.print(compress_size2[i] + "  ");
        }
        System.out.println();
        for (int i = 0;i < compress_time.length;i++){
            compress_time2[i] = (compress_time[i] - min_comTime)*1.0/(max_comTime-min_comTime);
            System.out.print(compress_time2[i] + "  ");
        }
        System.out.println();
        // 1.0  0.0  0.02222  0.32104  0.38413  4.4656199179152076E-7
        // 0.62989  1.0  0.01830  0.0  0.77414
    }
    public static void test02(){
        double[] compress_size2 = {1.0, 0.0, 0.02222, 0.32104, 0.38413, 4.4656199179152076E-7};
        double[] compress_time2 = {0.62989, 1.0, 0.01830, 0.0, 0.77414};
        int warm_alg = -1;
        double min = 10.0;
        for (int i = 0;i < 5;i++){
            double v = 0.5 * compress_size2[i+1] + 0.5 * compress_time2[i];
//            double v = 1 * compress_size2[i+1] + 0 * compress_time2[i];
//            double v = 0 * compress_size2[i+1] + 1 * compress_time2[i];
            if (v<min){
                min = v;
                warm_alg=i;
            }
        }
        System.out.println("min: " + min);
        System.out.println("warm_alg: " + warm_alg);
    }
}
