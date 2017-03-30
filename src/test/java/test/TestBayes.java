package test;

import java.io.IOException;

import com.xinrui.demo.ml.Bayes;

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
//		String fileName = "房产";
//		Bayes bayes = new Bayes();
//		BufferedReader reader = new BufferedReader(new FileReader("D:\\workspace\\eclipse-workspace\\demo-web\\src\\main\\java\\com\\xinrui\\demo\\ml\\bayes\\files\\" + fileName + ".txt"));
//		ArrayList<ArrayList<String>> model = Bayes.read("D:\\workspace\\eclipse-workspace\\demo-web\\src\\main\\resources\\model\\classify.txt");
//		ArrayList<String> testData = (ArrayList<String>) HanLP.extractKeyword("据了解，2017年，北京市将加大自住房供应力度，将新增1.5万套自住房用地，而近期就有近一半自住房用地有了着落。", 15);
//		System.out.println(bayes.predictClassify(model,testData));
		Bayes.trainBayes("房产.txt", 15);
	}

}
