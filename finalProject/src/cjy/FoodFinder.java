package cjy;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * FoodFinder 프로그램의 메인 클래스입니다. 이 클래스는 GUI 기반의 음식점 선택 프로그램의 틀을 제공합니다.
 * 
 * 
 * @author Choi Jong Yun
 * @version 1.3
 * @since 1.0
 * 
 * @created 2024-12-23
 * @lastModified 2024-12-23
 * 
 * @changelog
 *            <ul>
 *            <li>2024-12-23: 최초 생성 (Choi Jong Yun)</li>
 *            <li>2024-12-23: 음식 장르 선택 UI 추가</li>
 *            <li>2024-12-23: 버튼 클릭 시 음식점 정보 표시 기능 추가</li>
 *            </ul>
 */

public class FoodFinder extends JFrame {

	/**
	 * FoodFinder 생성자. 프로그램의 기본 창 설정(크기, 제목, 닫기 동작, 위치)을 수행합니다.
	 * 
	 * 사용자는 상단의 텍스트 지시문에 따라 음식 장르 버튼을 선택할 수 있습니다. 버튼과 레이아웃은 GridLayout과
	 * BorderLayout을 사용해 구성되어 있습니다.
	 */

	public FoodFinder() {
		setTitle("음식점 선택 프로그램");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JLabel titleLabel = new JLabel("음식 장르 고르기", SwingConstants.CENTER);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		add(titleLabel, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 2, 5, 5));

		String[] genres = { "한식", "일식", "중식", "분식", "양식", "기타" };
		for (String genre : genres) {
			JButton button = new JButton(genre);
			button.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showRestaurantInfo(genre);
				}
			});
			buttonPanel.add(button);
		}

		add(buttonPanel, BorderLayout.CENTER);

		setVisible(true);
	}

	/**
     * 선택한 음식 장르에 대한 가게 정보를 표시하는 새 창을 엽니다.
     * 
     * genre : 선택된 음식 장르
     */
    private void showRestaurantInfo(String genre) {
        JFrame infoFrame = new JFrame(genre + " 음식점 정보");
        infoFrame.setSize(400, 300);
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea infoText = new JTextArea();
        infoText.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        infoText.setEditable(false);
        if (genre.equals("한식")) {
            infoText.setText("한식 관련 가게 정보:\n"
                    + "1. 가게 이름: 솥정\n   위치: 청주시 청원구 내덕동 123-45, 1층\n   메뉴: 김치찌개, 된장찌개, 제육볶음\n\n"
                    + "2. 가게 이름: 수미백반\n   위치: 청주시 청원구 내덕동 67-89, 2층\n   메뉴: 백반, 제육볶음, 생선구이\n\n"
                    + "3. 가게 이름: 리정식당\n   위치: 청주시 청원구 내덕동 101-23, 지하 1층\n   메뉴: 육개장, 설렁탕, 갈비탕");
        }

        infoFrame.add(new JScrollPane(infoText));
        infoFrame.setVisible(true);
    }

	public static void main(String[] args) {
		new FoodFinder();
	}
}