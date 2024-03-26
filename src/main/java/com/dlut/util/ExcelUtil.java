package com.dlut.util;

import Jama.Matrix;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Description: Excel操作
 *
 * CreateTime: 2019年10月11日  下午3:08:09
 *
 * Change History:
 *
 *        Date             CR Number              Name              Description of change
 *
 *
 *
 */
public class ExcelUtil {

    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    private static String[] elementNames = null;
    private static String[] standardName = null;
    public static DecimalFormat df =  new DecimalFormat("0.0000");


    private static double[][] standard = initStandard();

    /**
     * 判断Excel的版本,获取Workbook
     * @param in
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbok(InputStream in,File file) throws IOException{
        Workbook wb = null;
        if(file.getName().endsWith(EXCEL_XLS)){  //Excel 2003
            wb = new HSSFWorkbook(in);
        }else if(file.getName().endsWith(EXCEL_XLSX)){  // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    /**
     * 判断文件是否是excel
     * @throws Exception
     */
    public static void checkExcelVaild(File file) throws Exception{
        if(!file.exists()){
            throw new Exception("文件不存在");
        }
        if(!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))){
            throw new Exception("文件不是Excel");
        }
    }

    /**
     * 读取Excel测试，兼容 Excel 2003/2007/2010
     * @throws Exception
     */
    public static double[][] getData(String inputFile) throws Exception {
        return getData(inputFile,2);
    }


    public static double[][] getData(String inputFile,int precision) throws Exception {
//        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        int pre = 1;
        for(int i=0;i<precision;i++){
            pre = pre * 10;
        }
        double[][] arrays = null;
        try {
            // 同时支持Excel 2003、2007
            File excelFile = new File(inputFile); // 创建文件对象
            FileInputStream in = new FileInputStream(excelFile); // 文件流
            checkExcelVaild(excelFile);
            Workbook workbook = getWorkbok(in,excelFile);
            //Workbook workbook = WorkbookFactory.create(is); // 这种方式 Excel2003/2007/2010都是可以处理的

//            int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
            /**
             * 设置当前excel中sheet的下标：0开始
             * 默认一个文件只处理第一个Sheet，即Sheet0
             */
            Sheet sheet = workbook.getSheetAt(0);   // 遍历第一个Sheet
//            Sheet sheet = workbook.getSheetAt(2);   // 遍历第三个Sheet

            //获取总行数和总列数，并构建double二维数组
            int rowSum = sheet.getLastRowNum();
            int columeSum = getMaxPhysicalNumberOfCells(sheet);
            elementNames = new String[columeSum];
            Row nameRow = sheet.getRow(0);
            for(int i=0;i<columeSum;i++){
                Cell cell = nameRow.getCell(i);
                if(cell != null)
                    elementNames[i] = ""+getValue(cell);
                else
                    elementNames[i] = "N/A";
            }
            arrays = new double[rowSum][columeSum];
            for (int i=1;i<=rowSum;i++) {
                for (int j = 0; j < columeSum; j++) {
//                    System.out.println(i+","+j);
                    Cell cell = sheet.getRow(i).getCell(j);
                    if(cell == null || (""+getValue(cell)).trim().equals("") ) {
                        arrays[i-1][j] = 0.0;

                    }
                    else{
                        try{
                            arrays[i-1][j] = (double) Math.round(Double.parseDouble(""+getValue(cell)) * pre) / pre;
                        }catch (Exception e){
                            arrays[i-1][j] = 0.0;
                            System.out.println("转型错误，第"+i+"行第"+j+"列的数值有误，无法转型为double类型，自动改为0.0进行后续处理");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrays;
    }

    public static int[][] getIntData(String inputFile) throws Exception {
//        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        int[][] arrays = null;
        try {
            // 同时支持Excel 2003、2007
            File excelFile = new File(inputFile); // 创建文件对象
            FileInputStream in = new FileInputStream(excelFile); // 文件流
            checkExcelVaild(excelFile);
            Workbook workbook = getWorkbok(in,excelFile);
            //Workbook workbook = WorkbookFactory.create(is); // 这种方式 Excel2003/2007/2010都是可以处理的

//            int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
            /**
             * 设置当前excel中sheet的下标：0开始
             * 默认一个文件只处理第一个Sheet，即Sheet0
             */
            Sheet sheet = workbook.getSheetAt(0);   // 遍历第一个Sheet
//            Sheet sheet = workbook.getSheetAt(2);   // 遍历第三个Sheet

            //获取总行数和总列数，并构建double二维数组
            int rowSum = sheet.getLastRowNum();
            int columeSum = getMaxPhysicalNumberOfCells(sheet);
            elementNames = new String[columeSum];
            Row nameRow = sheet.getRow(0);
            for(int i=0;i<columeSum;i++){
                Cell cell = nameRow.getCell(i);
                if(cell != null)
                    elementNames[i] = ""+getValue(cell);
                else
                    elementNames[i] = "N/A";
            }
            arrays = new int[rowSum][columeSum];
            for (int i=1;i<=rowSum;i++) {
                for (int j = 0; j < columeSum; j++) {
//                    System.out.println(i+","+j);
                    Cell cell = sheet.getRow(i).getCell(j);
                    if(cell == null || (""+getValue(cell)).trim().equals("") ) {
                        arrays[i-1][j] = 0;

                    }
                    else{
                        try{
                            arrays[i-1][j] = (int)Integer.parseInt(""+getValue(cell));
                        }catch (Exception e){
                            arrays[i-1][j] = 0;
                            System.out.println("转型错误，第"+i+"行第"+j+"列的数值有误，无法转型为int类型，自动改为0进行后续处理");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrays;
    }


    public static Object[][] getObjectData(File excelFile,int precision) throws Exception {
//        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        int pre = 1;
        for(int i=0;i<precision;i++){
            pre = pre * 10;
        }
        Object[][] arrays = null;
        try {
            // 同时支持Excel 2003、2007
            FileInputStream in = new FileInputStream(excelFile); // 文件流
            checkExcelVaild(excelFile);
            Workbook workbook = getWorkbok(in,excelFile);
            //Workbook workbook = WorkbookFactory.create(is); // 这种方式 Excel2003/2007/2010都是可以处理的

//            int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
            /**
             * 设置当前excel中sheet的下标：0开始
             * 默认一个文件只处理第一个Sheet，即Sheet0
             */
            Sheet sheet = workbook.getSheetAt(0);   // 遍历第一个Sheet
//            Sheet sheet = workbook.getSheetAt(2);   // 遍历第三个Sheet

            //获取总行数和总列数，并构建double二维数组
            int rowSum = sheet.getLastRowNum();
            int columeSum = getMaxPhysicalNumberOfCells(sheet);
            elementNames = new String[columeSum];
            Row nameRow = sheet.getRow(0);
            for(int i=0;i<columeSum;i++){
                Cell cell = nameRow.getCell(i);
                if(cell != null)
                    elementNames[i] = ""+getValue(cell);
                else
                    elementNames[i] = "N/A";
            }
            arrays = new Object[rowSum][columeSum];
            for (int i=1;i<=rowSum;i++) {
                for (int j = 0; j < columeSum; j++) {
//                    System.out.println(i+","+j);
                    Cell cell = sheet.getRow(i).getCell(j);
                    if(cell == null || (""+getValue(cell)).trim().equals("") ) {
                        arrays[i-1][j] = 0.0;

                    }
                    else{
                        try{
                            arrays[i-1][j] = (double) Math.round(Double.parseDouble(""+getValue(cell)) * pre) / pre;
                        }catch (Exception e){
                            arrays[i-1][j] = getValue(cell);
//                            System.out.println("转型错误，第"+i+"行第"+j+"列的数值有误，无法转型为double类型，自动改为0.0进行后续处理");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrays;
    }
    public static double[][] getData(File file,int precision) throws Exception {
//        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        int pre = 1;
        for(int i=0;i<precision;i++){
            pre = pre * 10;
        }
        double[][] arrays = null;
        try {
            // 同时支持Excel 2003、2007
            File excelFile = file; // 创建文件对象
            FileInputStream in = new FileInputStream(excelFile); // 文件流
            checkExcelVaild(excelFile);
            Workbook workbook = getWorkbok(in,excelFile);
            //Workbook workbook = WorkbookFactory.create(is); // 这种方式 Excel2003/2007/2010都是可以处理的

//            int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
            /**
             * 设置当前excel中sheet的下标：0开始
             * 默认一个文件只处理第一个Sheet，即Sheet0
             */
            Sheet sheet = workbook.getSheetAt(0);   // 遍历第一个Sheet
//            Sheet sheet = workbook.getSheetAt(2);   // 遍历第三个Sheet

            //获取总行数和总列数，并构建double二维数组
            int rowSum = sheet.getLastRowNum();
            int columeSum = getMaxPhysicalNumberOfCells(sheet);
            elementNames = new String[columeSum];
            Row nameRow = sheet.getRow(0);
            for(int i=0;i<columeSum;i++){
                Cell cell = nameRow.getCell(i);
                if(cell != null)
                    elementNames[i] = ""+getValue(cell);
                else
                    elementNames[i] = "N/A";
            }
            arrays = new double[rowSum][columeSum];
            for (int i=1;i<=rowSum;i++) {
                for (int j = 0; j < columeSum; j++) {
//                    System.out.println(i+","+j);
                    Cell cell = sheet.getRow(i).getCell(j);
                    if(cell == null || (""+getValue(cell)).trim().equals("") ) {
                        arrays[i-1][j] = 0.0;

                    }
                    else{
                        try{
                            arrays[i-1][j] = (double) Math.round(Double.parseDouble(""+getValue(cell)) * pre) / pre;
                        }catch (Exception e){
                            arrays[i-1][j] = 0.0;
                            System.out.println("转型错误，第"+i+"行第"+j+"列的数值有误，无法转型为double类型，自动改为0.0进行后续处理");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrays;
    }
    private static Object getValue(Cell cell) {
        Object obj = null;
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case ERROR:
                obj = cell.getErrorCellValue();
                break;
            case NUMERIC:
                obj = cell.getNumericCellValue();
                break;
            case STRING:
                obj = cell.getStringCellValue();
                break;
            default:
                break;
        }
        return obj;
    }


    public static int getMaxPhysicalNumberOfCells(Sheet sheet){
        int max = 0;
        for (Row row : sheet) {
            if(row.getPhysicalNumberOfCells()>max)
                max = row.getPhysicalNumberOfCells();
        }
        return  max;
    }
    public static String[] getElementNames(){
        return elementNames;
    }


    /**
     * min-max的归一化处理函数
     * @param data 待归一化double二维数组
     * @return 归一化后的数组
     */
    public static double[][] minMaxForStandard(double[][] data){
        int row = data.length;
        int column = data[0].length;
        for(int j=0;j<column;j++){
            double min = data[0][j];
            double max = min;
            for(int i=1;i<row;i++){
                if(data[i][j] > max)
                    max = data[i][j];
                if(data[i][j] < min)
                    min = data[i][j];
            }
            double amplitude = max - min;
            for(int i=0;i<row;i++){
                data[i][j] = (data[i][j] - min)/amplitude;
            }
        }
        return data;
    }
    public static boolean exportArrayToTxt(double [][] data,String fileName) throws IOException {
        Matrix matrix = new Matrix(data);
        PrintWriter pw = new PrintWriter(new FileWriter(fileName));
        matrix.print(pw,8,4);
        pw.flush();
        pw.close();
        return true;
    }
    public static boolean exportArrayToXlsx(double [][] data,String fileName) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        try{
            HSSFSheet sheet = wb.createSheet("sheet0");
            HSSFRow row = null;
            row = sheet.createRow(0);
            for(int j=0;j<data[0].length;j++){
                row.createCell(j).setCellValue("label"+j);

            }
            for(int i=0;i<data.length;i++){
                row = sheet.createRow(i + 1);
                for(int j=0;j<data[i].length;j++){
                    //将内容按顺序赋给对应的列对象
                    row.createCell(j).setCellValue(data[i][j]);
                }
            }
            wb.write(new FileOutputStream(fileName));
        }catch (Exception e){
            return false;
        }finally {
            wb.close();
        }
        return true;
    }

    public static boolean exportArrayToXlsx(Object [][] data,String fileName) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        try{
            HSSFSheet sheet = wb.createSheet("sheet0");
            HSSFRow row = null;
            row = sheet.createRow(0);
            for(int j=0;j<data[0].length;j++){
                row.createCell(j).setCellValue("label"+j);

            }

            for(int i=0;i<data.length;i++){
                row = sheet.createRow(i + 1);
                for(int j=0;j<data[i].length;j++){
                    //将内容按顺序赋给对应的列对象
                    row.createCell(j).setCellValue(""+data[i][j]);
                }
            }
            wb.write(new FileOutputStream(fileName));
        }catch (Exception e){
            return false;
        }finally {
            wb.close();
        }
        return true;
    }

    public static boolean exportArrayToXlsx(Object [][] data,String fileName,String[] elementsName) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        try{
            XSSFSheet sheet = wb.createSheet("sheet0");
            XSSFRow row = null;
            row = sheet.createRow(0);
            for(int j=0;j<data[0].length;j++){
                if(j<elementsName.length)
                    row.createCell(j).setCellValue(elementsName[j]);
                else
                    row.createCell(j).setCellValue("label"+j);

            }

            for(int i=0;i<data.length;i++){
                row = sheet.createRow(i + 1);
                for(int j=0;j<data[i].length;j++){
                    //将内容按顺序赋给对应的列对象
                    if(data[i][j] instanceof Double){
                        row.createCell(j).setCellValue(Double.parseDouble(""+data[i][j]));
//                        row.createCell(j).setCellValue(1);
                    }
                    else{
                        row.createCell(j).setCellValue(""+data[i][j]);
                    }

                }
            }
            wb.write(new FileOutputStream(fileName));
        }catch (Exception e){
            return false;
        }finally {
            wb.close();
        }
        return true;
    }

    public static boolean exportArrayToXlsx(double [][] data,String fileName,String[] elementsName) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        try{
            XSSFSheet sheet = wb.createSheet("sheet0");
            XSSFRow row = null;
            row = sheet.createRow(0);
            for(int j=0;j<data[0].length;j++){
                if(j<elementsName.length)
                    row.createCell(j).setCellValue(elementsName[j]);
                else
                    row.createCell(j).setCellValue("label"+j);

            }
            for(int i=0;i<data.length;i++){
                row = sheet.createRow(i + 1);
                for(int j=0;j<data[i].length;j++){
                    //将内容按顺序赋给对应的列对象
                    row.createCell(j).setCellValue(data[i][j]);

                }
            }
            wb.write(new FileOutputStream(fileName));

        }catch (Exception e){
            return false;
        }finally {
            wb.close();
        }
        return true;
    }

    public static boolean exportArrayToXlsxWithHighLight(double [][] data,String fileName,String[] elementsName,List<ExcelDataModel.Point> errorPoint) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        try{
            Sheet sheet = wb.createSheet("sheet0");
            CellStyle style = wb.createCellStyle();
            style.setFillForegroundColor(IndexedColors.RED.getIndex());
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            Row row = null;
            row = sheet.createRow(0);
            for(int j=0;j<data[0].length;j++){
                if(j<elementsName.length)
                    row.createCell(j).setCellValue(elementsName[j]);
                else
                    row.createCell(j).setCellValue("label"+j);

            }
            for(int i=0;i<data.length;i++){
                row = sheet.createRow(i + 1);
                for(int j=0;j<data[i].length;j++){
                    //将内容按顺序赋给对应的列对象
                    row.createCell(j).setCellValue(data[i][j]);

                }
            }
            for(int i=0;i<errorPoint.size();i++){
                int x = errorPoint.get(i).x;
                int y = errorPoint.get(i).y;
                //TODO 并不高亮
                sheet.getRow(x+1).getCell(y).setCellStyle(style);
            }
            wb.write(new FileOutputStream(fileName));

        }catch (Exception e){
            return false;
        }finally {
            wb.close();
        }
        return true;
    }


    public static boolean exportArrayToOutputStream(double [][] data,OutputStream out,String[] elementsName) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        try{
            HSSFSheet sheet = wb.createSheet("sheet0");
            HSSFRow row = null;
            row = sheet.createRow(0);
            for(int j=0;j<data[0].length;j++){
                if(j<elementsName.length)
                    row.createCell(j).setCellValue(elementsName[j]);
                else
                    row.createCell(j).setCellValue("label"+j);

            }
            for(int i=0;i<data.length;i++){
                row = sheet.createRow(i + 1);
                for(int j=0;j<data[i].length;j++){
                    //将内容按顺序赋给对应的列对象
                    row.createCell(j).setCellValue(data[i][j]);

                }
            }
            wb.write(out);
        }catch (Exception e){
            return false;
        }finally {
            wb.close();
        }
        return true;
    }

    /**
     * Hakanson指数法来对单点土地进行更加精确的评定，将每一种金属的污染等级根据Hakanson毒素因子进行加权判定，使污染等级更加精确
     * @param metalData 一个数据点的8种金属含量
     * @return
     */
    public double[] getHakanson(double[] metalData,double pH){
        Object[][] data = new Object[1][metalData.length+1];
        System.arraycopy(metalData,0,data[0],1,metalData.length);
        data[0][0] = pH;
        Object[][] standardData = getStandard(data);
        double[] result = new double[HeavyMetalConstant.metalType];
        for(int i=0;i<HeavyMetalConstant.metalType;i++){
            result[i] = HeavyMetalConstant.Metal_poisons[i] * (double)standardData[0][i];
        }
        return result;
    }

    /**
     *
     * 农产品产品产地环境质量评价标准   限定重金属含量
     *
     *
     * Cr Mn  Ni Cu Zn   Se  As	Cd Hg Pb
     * 铬 /锰/ 镍 铜 锌  /硒/  砷 隔 汞 铅
     *
     * pH       <6.5        6.5~7.5     7.5
     *
     * 鎘        0.3         0.3        0.4
     *
     * 汞        0.25        0.3        0.35
     *
     * 砷        30          25         20
     *
     * 铅        50          50         50
     *
     * 铬        150         200        250
     *
     * 铜        50          100        100
     *
     * 锌        200         250        300
     *
     * 镍        40          50         60
     *
     *
     * 数组的数据顺序必须按照上述要求排好序，并且第一列为pH
     *
     *
     *
     *  @param data 即为：pH  Cr  Ni  Cu  Zn  As  Cd  Hg  Pb
         *  @return     结果序列为  Cr  Ni  Cu  Zn  As  Cd  Hg  Pb  All
     */
    public static Object[][] getStandard(Object[][] data){
        int x = data.length;
        int y = data[0].length;
        Object[][] result = new Object[x][y];
//        try{
//            if(data[0].length - 1 != standardName.length)
//                throw  new Exception("当前数据与标准资源表列数不同");
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        for(int i=0;i<x;i++){
            double pH = (double)data[i][0];
            for(int j=1;j<9;j++){
                result[i][j-1] = getSingleStandard(pH,(double)data[i][j],j-1);
            }
            result[i][8] = nemerowResult(result[i]);
        }
        return result;
    }


    // 得到单项的污染指数，例如第i个测量记录的Cr金属上的污染指数
    public static double getSingleStandard(double pH,double data,int type){
        int y = -1;

        if(pH < 6.5){
            y = 0;
        }
        else if(pH >= 6.5 && pH < 7.5){
            y = 1;
        }
        else{
            y = 2;
        }
        return data/standard[type][y];
    }

    //初始化污染指数表，对应为target下的standard.txt文件
    public static double[][] initStandard(){
        double[][] result = new double[HeavyMetalConstant.metalType][];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ExcelUtil.class.getResource("").getPath()+"/standard.txt"));
            //第一行不要
            String line = reader.readLine();
            standardName = new String[HeavyMetalConstant.metalType];
            for(int i=0;i<HeavyMetalConstant.metalType;i++){
                line = reader.readLine();
                String[] strs = line.split("\\s+");
                double[] standardCurr = new double[strs.length-1];
                for(int j=0;j<strs.length-1;j++){
                    standardCurr[j] = Double.parseDouble(strs[j+1]);
                }
                standardName[i] = strs[0];
                result[i] = standardCurr;

            }

        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("文件数据格式不正确");
            e.printStackTrace();
        }
        return result;
    }
    //内梅罗污染指数
    public static double nemerowResult(Object[] data){
        int length = 8;
        double max = -1;
        double sum = 0;
        for(int i=0;i<8;i++){
            double d = (double)data[i];
            if(d>max)
                max = d;
            sum += d;
        }
        double ave = sum/length;
        return Math.sqrt((Math.pow(ave,2)+ Math.pow(max,2))/2);
    }
    /**
     * 初始化ExcelModel数据
     */
    public static ExcelDataModel convertDoubleArrayToExcelModel(double[][] data){
        return new ExcelDataModel(data);
    }

    public static ExcelDataModel convertDoubleArrayToExcelModel(double[][] data,String[] elements){
        return new ExcelDataModel(data,elements);
    }

    public static void exportToTxtByComma(double[][] data,String outFilePath,String elementsName){
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(outFilePath));
            StringBuilder sb = new StringBuilder();
            sb.append(elementsName+",");
            for(int i =0;i< data.length;i++){
                for(int j =0;j< data[0].length;j++){
                    sb.append(data[i][j]+",");
                }
            }
            sb.append("\r\n"+data.length+","+data[0].length);
            pw.print(sb.toString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Map<String,Object>> data2FormatNemerow(Object[][] data,String[] elements){
        List<Map<String,Object>> result = new ArrayList<>();
        //第一列为pH，不做记录
        for(int i=0;i<9;i++){
            Map<String,Object> map = new HashMap<>();
            String name = elements[i];
            map.put("name",name);
            Object[][] pair = new Object[data.length][2];
            for(int j=0;j<data.length;j++){
                double curr = (double)data[j][i];
                pair[j][0] = j+1;

//                pair[j][1] = curr;
                pair[j][1] = (double) Math.round(curr * 10000) / 10000;
            }
            map.put("data",pair);
            result.add(map);
        }
        return result;
    }

    public static List<Map<String,Object>> data2FormatBox(ExcelDataModel model,String[] elements){
        List<Map<String,Object>> result = new ArrayList<>();
        double[][] data = model.getData();
        //第一列为pH，不做记录
        for(int i=0;i<data[0].length;i++){
            Map<String,Object> map = new HashMap<>();
            String name = elements[i];
            map.put("name",name);
            map.put("level1",model.getL()[i]-1.5*model.getIQR()[i]>0 ? model.getL()[i]-1.5*model.getIQR()[i]:0);
            map.put("level2",model.getL()[i]);
            map.put("level3",model.getU()[i]);
            map.put("level4",model.getU()[i]+1.5*model.getIQR()[i]);
            Object[][] pair = new Object[data.length][2];
            for(int j=0;j<data.length;j++){
                double curr = data[j][i];
                pair[j][0] = j+1;
                pair[j][1] = curr;
            }
            map.put("data",pair);
            result.add(map);
        }
        return result;
    }
    //将double后小数点乘以n个0转化为int
    public static int[][] convertDoublePrecisionToInt(double[][] data,int precision){
        int pre = 1;
        for(int i=0;i<precision;i++){
            pre *= 10;
        }
        int[][] result = new int[data.length][data[0].length];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                result[i][j] = (int)(data[i][j] * pre);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(""+1.0);
        System.out.println(a);
    }
}
