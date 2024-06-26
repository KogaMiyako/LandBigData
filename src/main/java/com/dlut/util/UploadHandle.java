package com.dlut.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhonghua on 2015/8/23.
 */
public class UploadHandle {

    private static String uploadFilePath=null;
    private static String saveFilename=null;


    public static int uploadFile(HttpServletRequest request){
        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = request.getServletContext().getRealPath("/WEB-INF/upload");
        //上传时生成的临时文件保存目录
        String tempPath = request.getServletContext().getRealPath("/WEB-INF/temp");
        File tmpFile = new File(tempPath);
        if (!tmpFile.exists()) {
            //创建临时目录
            tmpFile.mkdir();
        }

        //消息提示
        String message = "";
        try {
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
            factory.setSizeThreshold(1024 * 1000);//设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
            //设置上传时生成的临时文件的保存目录
            factory.setRepository(tmpFile);
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //监听文件上传进度
            upload.setProgressListener(new ProgressListener() {
                public void update(long pBytesRead, long pContentLength, int arg2) {
                    System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
                    //out.println((double)pBytesRead/(double)pContentLength);
                    /**
                     * 文件大小为：14608,当前已处理：4096 文件大小为：14608,当前已处理：7367
                     * 文件大小为：14608,当前已处理：11419 文件大小为：14608,当前已处理：14608
                     */
                }
            });
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据
            if (!ServletFileUpload.isMultipartContent(request)) {
                //按照传统方式获取数据
                return 0;
            }

            //设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
            upload.setFileSizeMax(1024 * 1024 *1024);
            //设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
            upload.setSizeMax(1024 * 1024 * 1024);
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                //如果fileitem中封装的是普通输入项的数据
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                    System.out.println(name + "=" + value);
                } else {//如果fileitem中封装的是上传文件
                    //得到上传的文件名称，
                    String filename = item.getName();
                    System.out.println(filename);
                    if (filename == null || filename.trim().equals("")) {
                        continue;
                    }
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    filename = filename.substring(filename.lastIndexOf("\\") + 1);
                    //得到上传文件的扩展名
                    String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
                    //如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
                    System.out.println("上传的文件的扩展名是：" + fileExtName);
                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //得到文件保存的名称
                    saveFilename = makeFileName(filename);
                    //得到文件的保存目录
                    String realSavePath = makePath(saveFilename, savePath);
                    //创建一个文件输出流
                    FileOutputStream outputStream = new FileOutputStream(realSavePath + "\\" + saveFilename);
                    uploadFilePath=realSavePath + "\\" + saveFilename;

                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while ((len = in.read(buffer)) > 0) {
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        outputStream.write(buffer, 0, len);
                    }
                    //关闭输入流
                    in.close();
                    //关闭输出流
                    outputStream.close();
                    //删除处理文件上传时生成的临时文件
                    //item.delete();

                    /**
                     *
                     * 在使用算法的前提是集群的开启
                     * 将文件上传到HDFS
                     * 本机虚拟机用户为zhonghua，集群用户为slave
                     * 本机服务器应搭建在Linux系统上，所以realSavePath+"/"+saveFilename应为linux下的路径
                     * 所以现阶段无法使用测试，暂用其他代替进行测试
                     *
                     */
                    // System.out.println("hadoop -put "+realSavePath+"/"+saveFilename+" /user/zhonghua/testdata/");
                    // SSHHelper.ssh("hadoop -put "+realSavePath+"/"+saveFilename+" /user/zhonghua/testdata/");

//                    SSHHelper.ssh("hadoop dfs -rmr /user/zhonghua/testdata/synthetic_control.data " +
//                            "&& hadoop dfs -put data.txt /user/zhonghua/testdata/synthetic_control.data");

                    System.out.println("文件上传成功！");
                }
            }
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
            System.out.println("文件超出最大值");
            return -1;
        } catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
            System.out.println("文件超出最大值");
            return -1;
        } catch (Exception e) {
            System.out.println("文件上传失败");
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    public static String getUploadFilePath(){
        return uploadFilePath;
    }

    public static String getSaveFileName(){
        return saveFilename;
    }


    private static String makeFileName(String filename) {  //2.jpg
        //为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
        return UUID.randomUUID().toString() + "_" + filename;
    }

    private static String makePath(String filename, String savePath) {
        //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
        int hashcode = filename.hashCode();
        int dir1 = hashcode & 0xf;  //0--15
        int dir2 = (hashcode & 0xf0) >> 4;  //0-15
        //构造新的保存目录
        String dir = savePath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        //File既可以代表文件也可以代表目录
        File file = new File(dir);
        //如果目录不存在
        if (!file.exists()) {
            //创建目录
            file.mkdirs();
        }
        return dir;
    }
}
