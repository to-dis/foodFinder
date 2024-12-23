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
		// 프로그램 제목 설정
		setTitle("음식점 선택 프로그램");
		// 창 크기 설정
		setSize(500, 500);
		// 창 닫기 동작 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 창을 화면 중앙에 배치
		setLocationRelativeTo(null);
		// 레이아웃 설정
		setLayout(new BorderLayout());

		// 상단 제목 레이블 생성 및 추가
		JLabel titleLabel = new JLabel("음식 장르 고르기", SwingConstants.CENTER);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		add(titleLabel, BorderLayout.NORTH);

		// 버튼 패널 생성 및 설정
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 2, 5, 5)); // 3행 2열의 버튼 레이아웃, 간격 5px

		// 음식 장르 버튼 추가
		String[] genres = { "한식", "일식", "중식", "분식", "양식", "기타" };
		for (String genre : genres) {
			JButton button = new JButton(genre);
			button.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
			// 버튼 클릭 시 동작 정의
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showRestaurantInfo(genre);
				}
			});
			buttonPanel.add(button);
		}

		// 버튼 패널을 중앙에 추가
		add(buttonPanel, BorderLayout.CENTER);

		// 창 보이기 설정
		setVisible(true);
	}

	/**
	 * 선택한 음식 장르에 대한 가게 정보를 표시하는 새 창을 엽니다.
	 * 
	 * @param genre 선택된 음식 장르
	 * 
	 * @description
	 * 이 메서드는 JTextArea를 사용해 선택된 음식 장르에 대한 가게 정보를
	 * 표시하는 새 JFrame 창을 생성하고 가게 정보를 출력합니다.
	 */
	private void showRestaurantInfo(String genre) {
		// 새로운 창 생성
		JFrame infoFrame = new JFrame(genre + " 음식점 정보");
		infoFrame.setSize(400, 300);
		infoFrame.setLocationRelativeTo(null);
		infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 텍스트 영역 생성 및 설정
		JTextArea infoText = new JTextArea();
		infoText.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		infoText.setEditable(false); // 텍스트 편집 불가능 설정
	}

	/**
	 * 
	 * FoodFinder 프로그램을 실행하는 메인 메서드입니다.
	 * 
	 */
	public static void main(String[] args) {
		new FoodFinder();
	}
}
