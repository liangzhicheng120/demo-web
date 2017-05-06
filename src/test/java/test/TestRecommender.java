package test;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import com.xinrui.demo.algorithm.mahout.Recommender;

public class TestRecommender {
	public static void main(String[] args) throws Exception {
		String model = "E:/webworkspace/demo-web/src/main/java/com/xinrui/demo/algorithm/mahout/user.txt";
		int uid = 10;
		Recommender recommender = new Recommender(2, 3);
		List<RecommendedItem> recommendations = recommender.userBaseRecommend(uid, model);
		System.out.printf("uid:%s", uid);
		for (RecommendedItem recommendedItem : recommendations) {
			System.out.printf("(%s,%f)", recommendedItem.getItemID(), recommendedItem.getValue());
		}
	}
}
