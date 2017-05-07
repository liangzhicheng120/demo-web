package test;

import org.junit.Test;

import com.xinrui.demo.util.math.MathUtil;

public class TestMathUtil {
	@Test
	public void testSigmoid() {
		for (int i = 1; i < 101; i++) {
			System.out.println(i + ":" + MathUtil.sigmoid(i));
		}

	}

	@Test
	public void testLog() {
		for (int i = 1; i < 201; i++) {
			System.out.println(i + ":" + MathUtil.log(i, 2));
		}
	}
}
