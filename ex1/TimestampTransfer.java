package No1;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
public class TimestampTransfer {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		//获取控制台的输入
		Scanner scanner = new Scanner(System.in);
		//定义一个输入流的用于解析输入数据
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//定义一个输出流的转换为输出的数据
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//判断控制台的输入是否有下一个
		while (scanner.hasNext()){
// 			//如果有，输出下一行
			String line = scanner.nextLine();
// 			// 定义一个日期的输出链
			Date lineDate = null;
			// 转化为long存储
			long lineTimestamp;
			try {
// 				//抛异常。
				lineDate = inputFormat.parse(line);
				//将lineDate转化为lineTimestamp
				lineTimestamp = lineDate.getTime();
// 				//输出数据。
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
