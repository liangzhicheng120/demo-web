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
 * @Description:��ȡ�ļ�����
 * @author liangzhicheng
 * @date 2017��1��20�� ����3:21:22
 *
 */
public class BayesFileTools {

	/**
	 * ��ȡѵ���ĵ��е�ѵ������ �����з�װ
	 * 
	 * @param filePath
	 *            ѵ���ĵ���·��
	 * @return ѵ�����ݼ�
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
	 * ֱ�ӽ����ļ������ķ���
	 * 
	 * @param filePath
	 *            ѵ���ĵ���·��
	 * @return ѵ�����ݼ�
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
			// һ�ζ���һ�У�ֱ������nullΪ�ļ�����
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
