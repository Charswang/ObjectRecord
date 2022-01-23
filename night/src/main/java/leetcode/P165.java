package leetcode;

/**
 * 2021-9-2
 */
public class P165 {
    public static void main(String[] args) {
        String version1 = "1";
        String version2 = "1.1";
        int i = compareVersion(version1, version2);
        System.out.println(i);
    }

    public static int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int len1 = split1.length;
        int len2 = split2.length;
        int len = len1 > len2 ? len2 : len1;
        for (int i = 0;i < len;i++){
            int i1 = Integer.parseInt(split1[i]);
            int i2 = Integer.parseInt(split2[i]);
            if (i1==i2){
                continue;
            }else{
                return i1 > i2 ? 1 : -1;
            }
        }
        if (len1>len){
            for (int i = len;i < len1;i++){
                if (Integer.parseInt(split1[i])>0){
                    return 1;
                }
            }
        }
        if (len2 > len){
            for (int i = len;i < len2;i++){
                if (Integer.parseInt(split2[i])>0){
                    return -1;
                }
            }
        }
        return 0;
    }
}
