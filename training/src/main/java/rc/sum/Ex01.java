package rc.sum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import rc.bean.Product;

/**
 * 數字加總練習。
 */
public class Ex01 {

	public static void main(String[] args) {
		new Ex01().run();
	}
	
	public void run() {
		
	}
	
	public void quz1() {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(8);
		list.add(12);
		
	}
	
	public void quz2() {
		List<Double> list = new ArrayList<>();
		list.add(3.32);
		list.add(8.43);
		list.add(12.55);
		
	}
	
	public void quz3() {
		List<BigDecimal> list = new ArrayList<>();
		list.add(new BigDecimal("3.32"));
		list.add(new BigDecimal("8.43"));
		list.add(new BigDecimal("12.55"));
		
	}
	
	public void quz4() {
		List<Product> list = new ArrayList<>();
		list.add(new Product("Book", new BigDecimal("39.99")));
		list.add(new Product("iPhone", new BigDecimal("300.55")));
		list.add(new Product("DVD", new BigDecimal("9.33")));
		
	}

}
