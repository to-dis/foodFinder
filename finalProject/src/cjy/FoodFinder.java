package cjy;

import javax.swing.*;

/**
 * FoodFinder 프로그램의 메인 클래스입니다.
 * 이 클래스는 GUI 기반의 음식점 선택 프로그램의 틀을 제공합니다.
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
 * </ul>
 */

public class FoodFinder extends JFrame {
	
	 /**
     * FoodFinder 생성자.
     * 
     * 프로그램의 기본 창 설정(크기, 제목, 닫기 동작, 위치)을 수행합니다.
     */
	
    public FoodFinder() {
        setTitle("음식점 선택 프로그램");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FoodFinder();
    }
}