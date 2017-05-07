package test;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import com.xinrui.demo.algorithm.mahout.Recommender;
import com.xinrui.demo.python.PyConstants;

public class TestRecommender {
	public static void main(String[] args) throws Exception {
		String model = PyConstants.ml.CF_MODEL;
		int uid = 1;
		List<RecommendedItem> recommendations = Recommender.itemBaseRecommend(uid, model, 1);
		System.out.printf("uid:%s", uid);
		if (recommendations.isEmpty()) {
			System.out.println(":null");
		} else {
			for (RecommendedItem recommendedItem : recommendations) {
				System.out.printf("(%s,%f)", recommendedItem.getItemID(), recommendedItem.getValue());
			}
		}
	}

}
