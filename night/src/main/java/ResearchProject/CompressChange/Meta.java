package ResearchProject.CompressChange;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Meta {
    public static void main(String[] args) throws Exception {
        List<HashMap> meta1202 = getMeta1202("");
        HashMap greatAlgMap = meta1202.get(0);
        HashMap comSizeMap = meta1202.get(1);
        HashMap comTimeMap = meta1202.get(2);
        HashMap decomTimeMap = meta1202.get(3);
        HashMap originSizeMap = meta1202.get(4);

        for (Object o : greatAlgMap.keySet()) {
            System.out.println(o + " ");
            String[] strings = (String[])greatAlgMap.get(o);
            for (String string:strings){
                System.out.println(string + " ");
            }
            System.out.println();
        }
        System.out.println("=====================================================");

        for (Object o : comSizeMap.keySet()) {
            System.out.println(o + " ");
            long[] longs = (long[])comSizeMap.get(o);
            for (long aLong:longs){
                System.out.println(aLong + " ");
            }
            System.out.println();
        }
        System.out.println("=====================================================");

        for (Object o : comTimeMap.keySet()) {
            System.out.println(o + " ");
            long[] longs = (long[])comTimeMap.get(o);
            for (long aLong:longs){
                System.out.println(aLong + " ");
            }
            System.out.println();
        }
        System.out.println("=====================================================");

        for (Object o : decomTimeMap.keySet()) {
            System.out.println(o + " ");
            long[] longs = (long[])decomTimeMap.get(o);
            for (long aLong:longs){
                System.out.println(aLong + " ");
            }
            System.out.println();
        }
        System.out.println("=====================================================");

        for (Object o : originSizeMap.keySet()) {
            System.out.println(o + " " + originSizeMap.get(o));
        }
    }
    public static List<HashMap> getMeta1202(String path) throws Exception {
        // 获取所有文件再所有压缩算法上的压缩后的文件大小、压缩时间、解压缩时间以及未压缩数据大小、文件名信息
        // 存放所有文件的最佳压缩算法
        HashMap<String,String[]> greatAlgMap = new HashMap<>();
        HashMap<String,long[]> comSizeMap = new HashMap<>();
        HashMap<String,long[]> comTimeMap = new HashMap<>();
        HashMap<String,long[]> decomTimeMap = new HashMap<>();
        HashMap<String,Long> originSizeMap = new HashMap<>();
        // 元数据文件读取 -- 每4行为一个文件的元数据信息
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        // 这里5行为一个文件的元数据
        while((line=br.readLine())!=null){
            // 第一行--文件路径+未压缩文件大小
            String[] fileInfo = line.split(" ");
            String filePath = fileInfo[0];
            long originFileSize = Long.parseLong(fileInfo[1]);
            originSizeMap.put(filePath,originFileSize);//存放未压缩文件大小
            // 读取文件元数据剩余的4行信息
            for (int i = 0;i < 4;i++){
                if ((line=br.readLine())!=null){
                    if (i==0){
                        String[] greatAlgs = line.split(" ");
                        // 存放文件再三种温度下的最佳压缩算法
                        greatAlgMap.put(filePath,greatAlgs);
                    }
                    if (i==1){
                        String[] compressSize = line.split(" ");
                        long[] comSizes = new long[compressSize.length];
                        for (int j = 0;j < comSizes.length;j++){
                            comSizes[j] = Long.parseLong(compressSize[j]);
                        }
                        // 存放文件在所有压缩算法下的大小
                        comSizeMap.put(filePath,comSizes);
                    }
                    if (i==2){
                        String[] compressTimes = line.split(" ");
                        long[] comTimes = new long[compressTimes.length];
                        for (int j = 0;j < comTimes.length;j++){
                            comTimes[j] = Long.parseLong(compressTimes[j]);
                        }
                        // 存放文件在所有压缩算法下的压缩时间
                        comTimeMap.put(filePath,comTimes);
                    }
                    if (i==3){
                        String[] decompressTimes = line.split(" ");
                        long[] decomTimes = new long[decompressTimes.length];
                        for (int j = 0;j < decomTimes.length;j++){
                            decomTimes[j] = Long.parseLong(decompressTimes[j]);
                        }
                        // 存放文件在左右压缩算法下的解压缩时间
                        decomTimeMap.put(filePath,decomTimes);
                    }
                }
            }
        }
        List<HashMap> resList = new ArrayList<>();
        resList.add(greatAlgMap);
        resList.add(comSizeMap);
        resList.add(comTimeMap);
        resList.add(decomTimeMap);
        resList.add(originSizeMap);
        return resList;
    }
}
