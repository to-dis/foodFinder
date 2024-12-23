package cjy;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * FoodFinder 프로그램의 메인 클래스입니다.
 * 이 클래스는 GUI 기반의 음식점 선택 프로그램의 틀을 제공합니다.
 * 
 * 
 * @author Choi Jong Yun
 * @version 1.1
 * @since 1.0
 * 
 * @created 2024-12-23
 * @lastModified 2024-12-23
 * 
 * @changelog
 * <ul>
 *   <li>2024-12-23: 최초 생성 (Choi Jong Yun)</li>
 *   <li>2024-12-23: 음식 장르 선택 UI 추가</li>
 * </ul>
 */

public class FoodFinder extends JFrame {
	
	 /**
     * FoodFinder 생성자.
     * 프로그램의 기본 창 설정(크기, 제목, 닫기 동작, 위치)을 수행합니다.
     * 
     * 사용자는 상단의 텍스트 지시문에 따라 음식 장르 버튼을 선택할 수 있습니다. 버튼과 레이아웃은
     * GridLayout과 BorderLayout을 사용해 구성되어 있습니다.
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

        String[] genres = {"한식", "일식", "중식", "분식", "양식", "기타"};
        for (String genre : genres) {
            JButton button = new JButton(genre);
            button.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new FoodFinder(); 
    }
}