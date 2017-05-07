package test;

import java.io.File;

import weka.classifiers.AbstractClassifier;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class TestWeka {

	public static void main(String[] args) throws Exception {
		String fileName = "D:\\workspace\\scala-workspace\\ml\\src\\test\\java\\ml\\weka\\data\\house.arff";
		trainModel(fileName, 5);
	}

	public static AbstractClassifier trainModel(String arffFile, int classIndex) throws Exception {
		File inputFile = new File(arffFile); // 训练文件
		ArffLoader loader = new ArffLoader();
		loader.setFile(inputFile);
		Instances insTrain = loader.getDataSet(); // 读入训练文件
		insTrain.setClassIndex(classIndex);
		LinearRegression linear = new LinearRegression();
		linear.buildClassifier(insTrain);// 根据训练数据构造分类器
		double[] coef = linear.coefficients();
		System.out.println("Price=" + coef[0] + "*houseSize+" + coef[1] + "*lotSize+" + coef[2] + "*bedrooms+" + coef[3] + "*granite+" + coef[4] + "*bathroom");
		return linear;
	}
}
