package test;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import com.xinrui.demo.algorithm.mahout.Recommender;
import com.xinrui.demo.python.PyConstants;
import com.xinrui.demo.python.PythonUtil;

public class TestRecommender {
	public static void main(String[] args) throws Exception {
		PythonUtil.run(PyConstants.ml.RECOMMEND_PY);
		String model = PyConstants.ml.CF_MODEL;
		List<RecommendedItem> recommendations = Recommender.userBaseRecommend(1, model);
		System.out.printf("size:%s", recommendations.size());
		for (RecommendedItem recommendedItem : recommendations) {
			System.out.printf("(%s,%f)", recommendedItem.getItemID(), recommendedItem.getValue());
		}

	}
}
