package com.xinrui.demo.ml.bayes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.hankcs.hanlp.HanLP;
import com.xinrui.demo.util.MathUtil;

/**
 * 
 * @ClassName: TestBayes
 * @Description:测试贝叶斯分类器
 * @author liangzhicheng
 * @date 2017年1月20日 上午9:55:14
 *
 */
public class TestBayes {

	public static void main(String[] args) throws IOException {

		String fileName = "房产";
		Bayes bayes = new Bayes();
		File file = new File("D:\\workspace\\eclipse-workspace\\demo-web\\src\\main\\java\\com\\xinrui\\demo\\ml\\bayes\\files\\" + fileName + ".txt");
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String tempString = null;
		int line = 1;
		int correct = 0;
		long start = System.currentTimeMillis();
		while ((tempString = reader.readLine()) != null) {
			ArrayList<String> testData = (ArrayList<String>) HanLP.extractKeyword(tempString, 15);
			String clzss = bayes.predictClassify(testData);
			if (clzss.equals(fileName)) {
				correct += 1;
			}
			System.out.print("\n分类：" + clzss);
			line++;
		}
		reader.close();
		long end = System.currentTimeMillis();
		System.out.println("正确分类：" + correct);
		System.out.println("总行数：" + line);
		System.out.println("正确率：" + MathUtil.div(correct, line, 4) * 100 + "%");
		System.out.println("程序运行时间： " + (end - start) / 1000 + "s");
	}

}
