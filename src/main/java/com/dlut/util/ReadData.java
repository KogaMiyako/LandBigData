package com.dlut.util;

public class ReadData {
	private String inputFile;

	public ReadData(String inputFile) {
		this.inputFile = inputFile;
	}

	/**
	 * 从文件中读取数据并返回
	 * @return arrayData double型数组
	 */
//	public  double[][] getData() throws NumberFormatException, IOException {
//
//		 double[][] arrayData = new double[30][4];  //存放读取的数组
////		 double[][] arrayData = new double[5][2];  //存放读取的数组
//
//
//
//
//		 File file = new File("src/main/java/demo/pcademo/array.txt");  //读取文件
////		 System.out.println(file.getAbsolutePath());
//
//		  String line;  //一行数据
//
//		  String[] temp;//临时数组
//
//		  BufferedReader filein = new BufferedReader(new FileReader(file));  //创建流
//
//		  int row=0;
//		  //逐行读取，并将每个数组放入到数组中
//		  while((line = filein.readLine()) != null){
//
//		   temp = line.split("\t"); //读取一行
//
//		   for(int i=0;i<temp.length;i++){
//
//			   arrayData[row][i] = Double.parseDouble(temp[i]);
//		   }
//		   row++;
//		  }
//		  filein.close();//关闭流
//
//		  return arrayData;
//	}
	
}