package No3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex3
 * 1. 编写代码完成以下功能：
 * 		a. 从access.log中读入数据，获取IP和Time
 * 		b. 输出在时间区间[beginTime, endTime]内的IP和Time，以tab分割
 * 2. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class FilterByTime {
	
	public static void main(String[] args) throws ParseException, FileNotFoundException{
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date beginDate = regularFormat.parse("2015-12-31 18:00:00");
		Date endDate = regularFormat.parse("2015-12-31 19:00:00")	;
		String filePath = "G:/hadoop/陈老师/access.log";
		FileInputStream inputStream = new FileInputStream(filePath);
		Scanner scanner = new Scanner(inputStream, "UTF-8");
	
		while (scanner.hasNext()){
			// 对每行进行处理
			String line = scanner.nextLine();
		
			//正则表达式捕获ip和date
			String pattern = "(\\d+.\\d+.\\d+.\\d+) [^ ]* [^ ]* \\[([^ ]*) [^ ]*\\] \"[^ ]+ ([^ ]+) .*";
			Pattern pt = Pattern.compile(pattern);
			Matcher mc = pt.matcher(line);
			Locale locale = Locale.US; 
//			定义时间格式，用于转换从文件中提取得时间
			SimpleDateFormat regularFormat1 = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", locale);
			if(mc.find()){
				String strIp = null;
				String strTime = null;
				Date date = regularFormat1.parse(mc.group(2));//转换时间格式
				if (date.before(endDate) && date.after(beginDate)) {//时间和开始结束时间比较，符合就赋值并输出
						 strIp = mc.group(1);
						 strTime = mc.group(2);
				
						 System.out.println(strIp + "\t" + strTime);
						}		
			}
			
		
		}
	}
	
}
