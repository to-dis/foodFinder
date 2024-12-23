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
 *            <li>2024-12-23: 한식 장르에 대한 창과 가게 정보 추가</li>
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
     * 
     * 이 메서드는 JTextArea를 사용해 선택된 음식 장르에 대한 가게 정보를
     * 표시하는 새 JFrame 창을 생성하고 가게 정보를 출력합니다.
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
                    + "1. 가게 이름: 묵꼬먹꼬\n   위치: 청주대 중문, 1층\n   메뉴: 제육덮밥, 닭갈비덮밥\n   가격대: 7000~8000\n\n"
                    + "2. 가게 이름: 청대불고기\n   위치: 청주대 중문, 1층\n   메뉴: 불고기세트, 김치찌개, 부대찌개\n   가격대: (2인)18000~\n\n"
                    + "3. 가게 이름: 인생찌개집\n   위치: 청주대 중문, 1층\n   메뉴: 삼겹듬뿍찌개, 햄듬뿍부대찌개\n   가격대: 7000~15000\n\n"
            		+ "4. 가게 이름: 부활\n   위치: 청주대 중문, 1층\n   메뉴: 짜글이찌개, 뚝불고기\n   가격대: 5000~6000\n\n"
            		+ "5. 가게 이름: 오로지\n   위치: 청주대 중문, 2층\n   메뉴: 김치찌개냄비, 불고기냄비\n   가격대: 7000~14000\n\n"
            		+ "6. 가게 이름: 백미순대\n   위치: 청주대 중문, 1층\n   메뉴: 순대국밥\n   가격대: 8000~");
        }

        infoFrame.add(new JScrollPane(infoText));
        infoFrame.setVisible(true);
    }

    /**
     * 프로그램의 진입점.
     * 
     * FoodFinder 프로그램을 실행하는 메인 메서드입니다.
     * 
     */
	public static void main(String[] args) {
		new FoodFinder();
	}
}