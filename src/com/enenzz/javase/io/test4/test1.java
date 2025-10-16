package com.enenzz.javase.io.test4;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class test1 {
    public static void main(String[] args) throws IOException {
        File src = new File("D:\\Study\\Java\\资料\\day30-阶段综合案例（带权重的随机&每日一记）.zip");
        File dest = new File("C:\\Users\\26698\\Desktop\\test");
        upzip(src, dest);
    }

    public static void upzip(File src, File dest) throws IOException {
        //创建解压缩流来获取压缩包内数据
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
        
        //读取数据获取每一个对象
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            if (entry.isDirectory()) {
                //文件夹
                File fileDir = new File(dest, entry.toString());
                fileDir.mkdirs();
            } else {
                //文件
                FileOutputStream fos = new FileOutputStream(new File(dest, entry.toString()));
                byte[] bytes = new byte[1024 * 1024 * 5];
                int len;
                while ((len = zis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                fos.close();
                zis.closeEntry();
            }
        }
        zis.close();
    }
}
