package test;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import com.xinrui.demo.algorithm.mahout.Recommender;
import com.xinrui.demo.python.PyConstants;

public class TestRecommender {
	public static void main(String[] args) throws Exception {
		// PythonUtil.run(PyConstants.ml.RECOMMEND_PY);
		String model = PyConstants.ml.CF_MODEL;
		for (int i = 171; i < 183; i++) {
			List<RecommendedItem> recommendations = Recommender.userBaseRecommend(i, model);
			System.out.printf("size:%s", recommendations.size());
			for (RecommendedItem recommendedItem : recommendations) {
				System.out.printf("(%s,%f)", recommendedItem.getItemID(), recommendedItem.getValue());
			}
		}

	}
}
