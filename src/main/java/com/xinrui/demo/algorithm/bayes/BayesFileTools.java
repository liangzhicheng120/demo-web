package com.xinrui.demo.algorithm.bayes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: BayesFileTools
 * @Description:读取文件工具
 * @author liangzhicheng
 * @date 2017年1月20日 下午3:21:22
 *
 */
public class BayesFileTools {

	/**
	 * 读取训练文档中的训练数据 并进行封装
	 * 
	 * @param filePath
	 *            训练文档的路径
	 * @return 训练数据集
	 */
	public static ArrayList<ArrayList<String>> read(String filePath) {
		if (Tools.isEmptyString(filePath)) {
			return null;
		}

		ArrayList<ArrayList<String>> trainningSet = new ArrayList<ArrayList<String>>();
		List<String> datas = readFile(filePath);
		ArrayList<String> singleTrainning = null;
		for (int i = 0; i < datas.size(); i++) {
			String[] characteristicValues = datas.get(i).split(" ");
			singleTrainning = new ArrayList<String>();
			for (int j = 0; j < characteristicValues.length; j++) {
				if (!Tools.isEmptyString(characteristicValues[j])) {
					singleTrainning.add(characteristicValues[j]);
				}
			}

			trainningSet.add(singleTrainning);
		}

		return trainningSet;
	}

	/**
	 * 直接进行文件操作的方法
	 * 
	 * @param filePath
	 *            训练文档的路径
	 * @return 训练数据集
	 */
	private static ArrayList<String> readFile(String filePath) {
		if (Tools.isEmptyString(filePath)) {
			return null;
		}

		ArrayList<String> datas = new ArrayList<String>();

		File file = new File(filePath);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				if (!Tools.isEmptyString(tempString)) {
					datas.add(tempString);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					System.out.println(e1);
				}
			}
		}

		return datas;
	}
}
