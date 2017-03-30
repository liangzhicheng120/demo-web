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
		// BayesCalculator calculator = new BayesCalculator();
		// String sentence =
		// "4节8人次，NBL新赛季的外援新政让这个过去较CBA而言冷清许多的联赛，在今年，至少从场面上看，火爆了起来。除拉萨和东部陆军这样少数没有引进外援的球队，各支球队最主要的得分力量都集中在了这些“外来户”身上。他们是全场的目光焦点，他们有着无限开火权，在NBL联赛得分王前15名中，有14个外援，而那唯一一个国产球员，就是即将参加CBA选秀的，北京东方雄鹿球员乔文瀚。";
		// ArrayList<String> testData = (ArrayList<String>)
		// HanLP.extractKeyword(sentence, 20);
		// System.out.print("\n分类：" + calculator.predictClassify(testData));
		String fileName = "房产";
		Bayes bayes = new Bayes();
		File file = new File("D:\\workspace\\eclipse-workspace\\demo-web\\src\\main\\java\\com\\xinrui\\demo\\algorithm\\bayes\\files\\" + fileName + ".txt");
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
