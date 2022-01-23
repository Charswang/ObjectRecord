package ResearchProject.CompressChange;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.io.compress.CompressionInputStream;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.util.ReflectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChangeCompression {
    static String[] compressMethodSuffix = {".deflate", ".bz2", ".snappy", ".lz4", ".gzip"};

    public static void main(String[] args) throws Exception {
        String filePath = args[0];
        String target = args[1];
        Map<String, String> map = new HashMap<>();
        map.put(".deflate", "DeflateCodec");
        map.put(".bz2", "BZip2Codec");
        map.put(".snappy", "SnappyCodec");
        map.put(".lz4", "Lz4Codec");
        map.put(".gz", "GzipCodec");
        String houzhui = filePath.substring(filePath.lastIndexOf('.'));
        if (!target.equals(map.get(houzhui))){
            changeCompressionMethod(filePath,target);
        }
    }

    /**
     * 更换压缩算法
     * 要分成两种，一种是两种压缩算法转换，一种是未压缩转压缩，最后一种是压缩转未压缩；
     * @param filePath
     * @param target
     * @return
     * @throws Exception
     */
    public static long changeCompressionMethod(String filePath, String target) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put(".deflate", "DeflateCodec");
        map.put(".bz2", "BZip2Codec");
        map.put(".snappy", "SnappyCodec");
        map.put(".lz4", "Lz4Codec");
        map.put(".gz", "GzipCodec");
        // 加载文件系统
        long start = new Date().getTime();
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(conf);
        Path path = new Path(filePath);
        long fs_end = new Date().getTime();
        System.out.println("Load FileSystem Cost: " + (fs_end - start) + "Millis");
        /**
         * 1、target为-1表示，转为未压缩，直接解压缩
         * 2、filePath不带有压缩后缀，直接压缩
         * 3、正常就是两种压缩算法之间的转换
         */
        if (Integer.parseInt(target) == -1) {
            MRTest.uncompress(filePath);
            long end = new Date().getTime();
            System.out.println("changeCompress Cost: " + (end - start));
            return end - start;
        }
        // 解压缩
        CompressionCodecFactory factory = new CompressionCodecFactory(conf);
        CompressionCodec codec = factory.getCodec(path);
        String compressSuffix = ChangeCompression.compressMethodSuffix[Integer.parseInt(target)];
        if (codec == null) {
            // 直接压缩
            MRTest.compress(filePath, "org.apache.hadoop.io.compress." + map.get(compressSuffix), filePath + compressSuffix);
            long end = new Date().getTime();
            System.out.println("changeCompress Cost: " + (end - start));
            return end - start;
        }
        FSDataInputStream inputStream = fileSystem.open(path);
        CompressionInputStream compressionInputStream = codec.createInputStream(inputStream);
        // 新压缩
        String codecClassName = "org.apache.hadoop.io.compress." + map.get(compressSuffix);
        Class<?> codecClass = Class.forName(codecClassName);
        CompressionCodec com_codec = (CompressionCodec) ReflectionUtils.newInstance(codecClass, conf);
        // 指定压缩文件路径
        // 如果要改的话，可以参考一下MRTest解压缩中的CompressionCodecFactory.removeSuffix(uri, codec.getDefaultExtension());
        String originFilePath = filePath.substring(0, filePath.lastIndexOf('.'));
        String targetFilePath = originFilePath + compressSuffix;
        FSDataOutputStream outputStream = fileSystem.create(new Path(targetFilePath));
        CompressionOutputStream out = com_codec.createOutputStream(outputStream);
        IOUtils.copyBytes(compressionInputStream, out, conf);
        IOUtils.closeStream(compressionInputStream);
        IOUtils.closeStream(out);
        // 删除未压缩文件
        ReadFileTime.deleteHdfsFile(filePath);
        long end = new Date().getTime();
        System.out.println("changeCompress Cost: " + (end - start));
        return end - start;
    }
}
