package ResearchProject.CompressChange;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Date;

/**
 * 压缩 & 解压缩
 * DeflateCodec BZip2Codec SnappyCodec Lz4Codec GzipCodec
 */
public class MRTest {
    public static void main(String[] args) throws Exception {
        System.out.println("=====[" + new Date() + "]" + args[0] + " begin!!!=====");
        if (args[0].equals("compress")){
            compress(args[1],"org.apache.adoop.io.compress." + args[2],args[3]);
        }
        if (args[0].equals("uncompress")){
            uncompress(args[1]);
        }
        System.out.println("=====[" + new Date() + "]" + args[0] + " over!!!=====");
    }
    public static void compress(String inpath,String codecClassName,String output) throws Exception {
        long start = new Date().getTime();
        Class<?> codecClass = Class.forName(codecClassName);
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        CompressionCodec codec = (CompressionCodec) ReflectionUtils.newInstance(codecClass, conf);
        // 指定压缩文件路径
        FSDataOutputStream outputStream = fs.create(new Path(output));
        // 指定要被压缩的文件路径
        FSDataInputStream in = fs.open(new Path(inpath));
        // 创建压缩流
        CompressionOutputStream out = codec.createOutputStream(outputStream);
        IOUtils.copyBytes(in,out,conf);
        IOUtils.closeStream(in);
        IOUtils.closeStream(out);
        long end = new Date().getTime();
        System.out.println("Compress " + inpath + " Cost " + (end-start) + " Millis");
    }
    public static void uncompress(String uri) throws Exception {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);

        long start = new Date().getTime();
        // 要解压的文件
        Path inputPath = new Path(uri);
        CompressionCodecFactory factory = new CompressionCodecFactory(conf);
        CompressionCodec codec = factory.getCodec(inputPath);
        if (codec==null){
            System.out.println("No Codec found for " + uri);
            System.exit(1);
        }
        // 解压后文件输出路径
        String outputuri = CompressionCodecFactory.removeSuffix(uri, codec.getDefaultExtension());
        InputStream in = null;
        OutputStream out = null;
        try {
            in = codec.createInputStream(fs.open(inputPath));
            out = fs.create(new Path(outputuri));
            IOUtils.copyBytes(in,out,conf);
        } finally {
            IOUtils.closeStream(out);
            IOUtils.closeStream(in);
        }
        long end = new Date().getTime();
        System.out.println("Uncompress " + uri + " Cost " + (end-start) + " Millis");
    }
}
