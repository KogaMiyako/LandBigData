package com.dlut.util;

import ch.ethz.ssh2.*;
import sun.misc.Unsafe;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by febiven on 2018/07
 */

public class SSHHelper {
    public static Connection connection = null;
    public static Session session = null;
    public static InputStream stdout = null;
    public static InputStream stderr = null;
    public static BufferedReader stdoutBr = null;
    public static BufferedReader stderrBr = null;
    private static String hostname = null;
    private static String username = null;
    private static String password = null;
    public static String uploadPath = null;
    public static String downloadPath = null;

    public static String getHostname() {
        return hostname;
    }

    public static void setHostname(String hostname) {
        SSHHelper.hostname = hostname;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        SSHHelper.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        SSHHelper.password = password;
    }

    /**
     * 读取ssh.properties配置文件内容
     * ssh连接初始化
     */

    public static String other2UTF8(String src) {
        try {
            return URLDecoder.decode(src, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void init() {
        try {
            Properties prop = new Properties();
            String baseDir = other2UTF8(SSHHelper.class.getResource("/").getPath());
            String propPath = baseDir + "ssh.properties";
            System.out.println("配置文件目录为 " + propPath);

            //项目编译过后，resources目录不存在，配置文件直接在LandBigData/WEB-INF/classes下
            InputStream in = new BufferedInputStream(new FileInputStream(propPath));
            prop.load(in);
            String hostname = prop.getProperty("hostname1");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            System.out.println("准备SSH连接 " + hostname);
            connection = new Connection(hostname);
            connection.connect();
            boolean isAuthenticated = connection.authenticateWithPassword(username, password);
            if (isAuthenticated == false)
                throw new IOException("Authentication failed.");
            session = connection.openSession();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        init();
    }
    /**
     * ssh连接函数，主要建立propDirPTY连接
     *
     * @param cmd
     * @throws IOException
     */
    public static void ssh(String cmd) throws IOException {

        SSHHelper.init();
        /*
         * 打开虚拟终端进行命令执行
         * 使用其他方法无法正常加载环境变量
         */
        session.requestPTY("bash");
        session.startShell();
        PrintWriter out = new PrintWriter(session.getStdin());
//        out.println("ls -l");
        String[] arr = cmd.split("[ ]+");
        String command = arr[0];
        String fileName = arr[1];
        String[] fileSp = fileName.split("\\.");
        String resultFileName = fileSp[0] + "Result.txt";
        String fullCommand = "java -jar " + PathHelper.ALGORITHM_PATH +"/"+ command + ".jar " +PathHelper.UPLOAD_PATH + "/" + fileName + " " + PathHelper.CALCULTATOR_RESULT_PATH + "/" + resultFileName;
        out.println(fullCommand);
        out.flush();
        out.close();

        stdout = session.getStdout();
        stderr = session.getStderr();

    }


    /**
     * 前端轮询请求，获取log
     *
     * @return
     * @throws IOException
     */
    public static String getLogs() throws IOException {

        String logs = null;
        byte[] buffer = new byte[8192];
        char[] bufferC = new char[8192];

        if ((stdout.available() == 0) && (stderr.available() == 0)) {
            if(session == null)
                return null;
            int conditions = session.waitForCondition(ChannelCondition.STDOUT_DATA | ChannelCondition.STDERR_DATA
                    | ChannelCondition.EOF, 10000);
            //
            if ((conditions & ChannelCondition.TIMEOUT) != 0) {
                return null;
            }
            if ((conditions & ChannelCondition.EOF) != 0) {
                if ((conditions & (ChannelCondition.STDOUT_DATA | ChannelCondition.STDERR_DATA)) == 0) {
                    return null;
                }
            }
        }

        while (stdout.available() > 0) {
            InputStreamReader isr = new InputStreamReader(stdout,"UTF-8");
//            int len = stdout.read(buffer);
            int len = isr.read(bufferC);
            System.out.println("length:" + len);
            if (len > 0) { // this check is somewhat paranoid
//                System.out.write(bufferC, 0, len);
                logs = new String(bufferC);
            } else {
                return null;
            }
        }

        while (stderr.available() > 0) {
            InputStreamReader isr = new InputStreamReader(stderr,"UTF-8");
            int len = isr.read(bufferC);
            if (len > 0) { // this check is somewhat paranoid
//                System.err.write(buffer, 0, len);
                logs = new String(bufferC);
            }
        }
        System.out.println("return:" + logs);
        return logs;
    }

    /**
     * 关闭session与connection
     */
    public static void close() {
        if (session != null) {
            session.close();
            System.out.println("[" + SSHHelper.class.getName() + "]" + "session被关闭");
        }
        ;
        if (connection != null) {
            connection.close();
            System.out.println("[" + SSHHelper.class.getName() + "]" + "connection 被关闭");
        }
        ;
        connection = null;
        session = null;
    }


    /**
     * OLD
     * 获取执行输出结果
     */
    public static ArrayList<String> getLogs(String downloadPath) throws IOException {
        ArrayList<String> arrs = null;
        try {

            init();
            SCPClient scpClient = new SCPClient(connection);

            //System.out.println(LoginServer.username+"@"+LoginServer.hostname+":/home/zhonghua/resultLog"+ propDir.getServletContext().getRealPath("/WEB-INF/temp/"));
            //远程获取文件到本地
            scpClient.get("/home/zhonghua/resultLog", downloadPath);

            //读文件
            arrs = ReadFromFile.readFileByLines(downloadPath + "/resultLog");

            //ssh("rm /home/zhonghua/resultLog && touch resultLog");
            // DelFile.deleteFolder(propDir.getServletContext().getRealPath("/WEB-INF/temp") + "/resultLog");
            System.out.println(arrs.toString());
            session.close();
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return arrs;
    }

    /**
     * 向Hadoop集群发生命令并执行，不返回执行过程的日志信息
     */
    public static void executeOnly(String cmd) {
        try {
            System.out.println("执行命令 " + cmd);
            init();
          /*  //防止执行中文乱码
            String encodeSet = "export LC_CTYPE=zh_CN.GB18030;";
            cmd=encodeSet+cmd;*/

            session.execCommand("source /etc/profile;" + cmd);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }


    /**
     * 关闭文件流
     */
    private static void closeBr() {
        try {
            if (stdoutBr != null)
                stdoutBr.close();
            if (stderrBr != null)
                stderrBr.close();

            stderrBr = stdoutBr = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按行读取执行命令过程中的标准输出信息
     *
     * @return 一行信息
     */

    public static String readStdout() {

        try {
            //命令还未执行
            if (stdoutBr == null && stderrBr == null) {
                return null;
            }
            //读取过程是阻塞的

            String line = stdoutBr.readLine();

            //读取到null时，说明已经读完了，所以要关闭流
            if (line == null) {
                closeBr();
                close();
            }

            return line;
        } catch (IOException e) {
            //出错时，直接关闭流并返回null
            closeBr();
            close();
            return null;
        }
    }

    public static boolean executeCmd(String cmd) {
        try {
            //命令还未执行，先执行命令
            if (stdoutBr == null && stderrBr == null) {
                init();

                session.requestDumbPTY();
                //防止执行中文乱码
                String encodeSet = "export LC_CTYPE=zh_CN.GB18030;";
                cmd = encodeSet + cmd;
                session.execCommand("source /etc/profile;" + cmd);

                stdoutBr = new BufferedReader(
                        new InputStreamReader(
                                new StreamGobbler(session.getStdout())));
                stderrBr = new BufferedReader(
                        new InputStreamReader(
                                new StreamGobbler(session.getStderr())));
            }
            return true;
        } catch (IOException e) {
            close();
            return false;
        }
    }


    public static ArrayList<String> getFileContent(String downloadPath) {
        ArrayList<String> arrs = null;
        try {

            init();
            SCPClient scpClient = new SCPClient(connection);
            scpClient.get("/home/zhonghua/result", downloadPath);
            arrs = ReadFromFile.readFileByLines(downloadPath + "/result");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return arrs;
    }

    /**
     * 上传指定文件到Hadoop集群
     *
     * @param localFiles      待上传的文件列表，（注意以String数组形式存在）
     * @param remoteTargetDir 目的地址/目录
     * @return 上传成功（boolean true）/失败（boolean false）
     */
    public static boolean uploadFilesToRemote(String[] localFiles, String remoteTargetDir) {
        init();
        try {
            SCPClient scpClient = connection.createSCPClient();
            for (String localFile : localFiles) {
                File item = new File(localFile);
                if (item.isFile()) {
                    scpClient.put(URLDecoder.decode(localFile, "UTF-8"), remoteTargetDir, "0777");
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            close();
        }

    }

    /**
     * 从hadoop集群下载文件到本地
     *
     * @param remoteFiles          待下载的文件列表
     * @param localTargetDirectory 保存文件的目录
     * @return 下载成功与否
     */
    public static boolean downloadFileFromRemote(String[] remoteFiles, String localTargetDirectory) {

        try {
            init();
            SCPClient scpClient = new SCPClient(connection);
            scpClient.get(remoteFiles, localTargetDirectory);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
