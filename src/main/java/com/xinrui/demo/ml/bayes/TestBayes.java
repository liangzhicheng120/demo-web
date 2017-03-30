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
 * @Description:���Ա�Ҷ˹������
 * @author liangzhicheng
 * @date 2017��1��20�� ����9:55:14
 *
 */
public class TestBayes {

	public static void main(String[] args) throws IOException {
		// BayesCalculator calculator = new BayesCalculator();
		// String sentence =
		// "4��8�˴Σ�NBL����������Ԯ�����������ȥ��CBA�������������������ڽ��꣬���ٴӳ����Ͽ��������������������Ͷ���½����������û��������Ԯ����ӣ���֧�������Ҫ�ĵ÷�����������������Щ�������������ϡ�������ȫ����Ŀ�⽹�㣬�����������޿���Ȩ����NBL�����÷���ǰ15���У���14����Ԯ������Ψһһ��������Ա�����Ǽ����μ�CBAѡ��ģ�����������¹��Ա����嫡�";
		// ArrayList<String> testData = (ArrayList<String>)
		// HanLP.extractKeyword(sentence, 20);
		// System.out.print("\n���ࣺ" + calculator.predictClassify(testData));
		String fileName = "����";
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
			System.out.print("\n���ࣺ" + clzss);
			line++;
		}
		reader.close();
		long end = System.currentTimeMillis();
		System.out.println("��ȷ���ࣺ" + correct);
		System.out.println("��������" + line);
		System.out.println("��ȷ�ʣ�" + MathUtil.div(correct, line, 4) * 100 + "%");
		System.out.println("��������ʱ�䣺 " + (end - start) / 1000 + "s");
	}

}
