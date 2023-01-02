package vendingmochine.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vendingmochine.vo.ProductVO;

public class ProductView {

	ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
	ArrayList<JLabel> jlList = new ArrayList<JLabel>();
	
	public JPanel displayProducts() {
		JPanel jpC = new JPanel(new GridLayout(3,3));
		for (ProductVO vo : productList) {
			ImageIcon icon = new ImageIcon("images/" + vo.getImageName() + ".jpg");
			JLabel jl = new JLabel(icon);
			jlList.add(jl);
			jpC.add(jl);
		}//for
		return jpC;
	}
	
	public void inputPurchase() {
		
	}
	
	public void setProductList(ArrayList<ProductVO> productList) {
		this.productList = productList;
	}
	
}//class
