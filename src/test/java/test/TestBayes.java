package test;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.hankcs.hanlp.HanLP;

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
		// String fileName = "房产";
		// Bayes bayes = new Bayes();
		// BufferedReader reader = new BufferedReader(new
		// FileReader("D:\\workspace\\eclipse-workspace\\demo-web\\src\\main\\java\\com\\xinrui\\demo\\ml\\bayes\\files\\"
		// + fileName + ".txt"));
		// ArrayList<ArrayList<String>> model =
		// Bayes.read("D:\\workspace\\eclipse-workspace\\demo-web\\src\\main\\resources\\model\\classify.txt");
		// ArrayList<String> testData = (ArrayList<String>)
		// HanLP.extractKeyword("据了解，2017年，北京市将加大自住房供应力度，将新增1.5万套自住房用地，而近期就有近一半自住房用地有了着落。",
		// 15);
		// System.out.println(bayes.predictClassify(model,testData));
		// Bayes.trainBayes("房产.txt", 15);
		// for (int i = 0; i < 10; i++) {
		// ArrayList<ArrayList<String>> model =
		// Bayes.get(Constants.BAYES_MODEL);
		// System.out.println(model.get(1).toString());
		// }
		System.out.println(HanLP.extractKeyword("据了解，2017年，北京市将加大自住房供应力度，将新增1.5万套自住房用地，而近期就有近一半自住房用地有了着落。", 5));
		String strno = ",1,1,2";
		for (String string : StringUtils.split(strno, ",")) {
			System.out.println(string);
		}
	}

}
