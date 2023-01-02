package vendingmochine.vo;

import java.util.ArrayList;

public class ProductDAO {
	ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
	
	public void insert(ProductVO product) {
		productList.add(product);
	}
	
	public ArrayList<ProductVO> select() {
		return productList;
	}
	
}//class
