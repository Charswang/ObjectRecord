package ResearchProject.CompressChange;

import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.io.compress.CompressionInputStream;

public class ReadFileTime {
    public static void main(String[] args) throws Exception {
        if (args[0].equals("readHdfsFile")){
            long queryTime = readHdfsFile(args[1]);
            System.out.println("Read " + args[1] + " cost: " + queryTime + " millis");
        }
        if (args[0].equals("readUncompressFile")){
            long l = readUncompressFile(args[1]);
            System.out.println("Read " + args[1] + " cost: " + l + " millis");
        }
    }
    public static long readUncompressFile(String filePath) throws Exception {
        long start = new Date().getTime();
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(conf);
        Path path = new Path(filePath);
        long fs_end = new Date().getTime();
        System.out.println("get fileSystem cost time: " + (fs_end - start));

        long de_start = new Date().getTime();
        FSDataInputStream inputStream = fileSystem.open(path);
        // 解压输出到内存
        long read_stream_start = new Date().getTime();
        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(bytes)) != -1) {

        }
        inputStream.close();
        long end = new Date().getTime();
        System.out.println("only read stream cost time: " + (end - read_stream_start));
        return end - de_start;
    }

    public static long readHdfsFile(String filePath) throws Exception {
        // 加载文件系统
        long start = new Date().getTime();
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(conf);
        Path path = new Path(filePath);
        long fs_end = new Date().getTime();
        System.out.println("get fileSystem cost time: " + (fs_end - start));

        long de_start = new Date().getTime();
        CompressionCodecFactory factory = new CompressionCodecFactory(conf);
        CompressionCodec codec = factory.getCodec(path);
        FSDataInputStream inputStream = fileSystem.open(path);
        CompressionInputStream compressionInputStream = codec.createInputStream(inputStream);
        // 解压输出到内存
        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len = compressionInputStream.read(bytes)) != -1) {

        }
        compressionInputStream.close();
        long end = new Date().getTime();
        System.out.println("only read stream cost time: " + (end - de_start));
        return end - de_start;
    }
    public static void deleteHdfsFile(String filePath) throws Exception {
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(conf);
        Path path = new Path(filePath);
        boolean isok = fileSystem.deleteOnExit(path);
        if (isok){
            System.out.println("delete file " + filePath + "success!");
        }else {
            System.out.println("delete file " + filePath + "fail!");
        }
        fileSystem.close();
    }
}
