package vendingmochine.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vendingmochine.vo.ProductVO;

public class ProductView {
	ProductVO pvo;
	ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
	ArrayList<JLabel> jlList = new ArrayList<JLabel>();
	JTextField jtf = new JTextField(10);
	JLabel result = new JLabel("");
	JFrame frame;
	JLabel chagejl;
	
	public JPanel displayProducts(JFrame frame) {
		this.frame = frame;
		JPanel jpC = new JPanel(new GridLayout(3,3));
		JLabel pricejl = null;
		for (ProductVO vo : productList) {
			ImageIcon icon = new ImageIcon("images/" + vo.getImageName() + ".jpg");
			JLabel jl = new JLabel(icon);
			jl.setOpaque(true);
			jl.setBackground(Color.WHITE);
			jl.addMouseListener(jlL);
			jlList.add(jl);
			pricejl = new JLabel(vo.getPrice() + "원", JLabel.CENTER);
			pricejl.setFont(new Font("한컴 고딕", Font.BOLD, 15));
			pricejl.setOpaque(true);
			pricejl.setBackground(Color.WHITE);
			JPanel jp = new JPanel(new BorderLayout());
			jp.add(jl, "Center");
			jp.add(pricejl, "South");
			jpC.add(jp);
		}//for
		return jpC;
	}
	
	public JPanel inputPurchase() {
		JPanel jpS = new JPanel();
		JLabel money = new JLabel("금액 : ");
		JButton jb = new JButton("투입");
		jb.addActionListener(jbL);
		jpS.add(money); jpS.add(jtf); jpS.add(jb); jpS.add(result);
		return jpS;
	}
	
	public void setProductList(ArrayList<ProductVO> productList) {
		this.productList = productList;
	}
	
	MouseAdapter jlL = new MouseAdapter() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			chagejl = (JLabel)e.getSource();
			for(int i = 0; i < jlList.size(); i++) {
				if(e.getSource() == jlList.get(i)) {
					result.setIcon(null);
					chagejl.setBackground(Color.RED);
					pvo = productList.get(i);
				}//if
			}//for
			JOptionPane.showMessageDialog(frame, "제품명 : " + pvo.getName() + "\n제품 가격 : "+ pvo.getPrice() + "원");
		}
		
	};//jlL
	
	ActionListener jbL = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			//투입버튼이 클릭됐을 때 JTextField 입력된 금액과 현재 금액을 비교하여 제품과 거스름 돈이 나오게한다
			int money = Integer.parseInt(jtf.getText());
			if(pvo.getPrice() < money) {
				result.setIcon(null);
				ImageIcon icon = new ImageIcon("images/" + pvo.getImageName() + ".jpg");
				result.setIcon(icon);
				JOptionPane.showMessageDialog(frame, "거스름돈 : " + (money - pvo.getPrice()) + "원");
				jtf.setText("");
			} else if(pvo.getPrice() > money) {
				result.setIcon(null);
				result.setText("돈 부족");
				jtf.setText("");
			} else if(pvo.getPrice() == money) {
				result.setIcon(null);
				ImageIcon icon = new ImageIcon("images/" + pvo.getImageName() + ".jpg");
				result.setIcon(icon);
				jtf.setText("");
			}//if
			chagejl.setBackground(Color.WHITE);
		}
		
	};//jbL
	
}//class
