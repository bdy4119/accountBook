package Main;

import java.util.Scanner;

import dao.AccountDao;

public class MainClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		AccountDao dao = new AccountDao();
		
		while(true) {
			//menu
			System.out.println(" << 가계부 >>");
			System.out.println("1. 항목추가");
			System.out.println("2. 항목삭제");
			System.out.println("3. 항목검색");
			System.out.println("4. 정보수정");
			System.out.println("5. 데이터저장");
			System.out.println("6. 파일생성");
			System.out.println("7. 모두출력");
			
			System.out.println("실행할 번호를 입력해주세요 >>> ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1 :
					dao.insert();
					break;
				case 2 :
					dao.delete();
					break;
				case 3 :
					dao.allSelect();
					break;
				case 4 :
					dao.update();
					break;
				case 5 :
					dao.fileSave();
					break;
				case 6 :
					dao.fileload();
					break;
				case 7 :
					dao.allDataPrint();
					break;
			}
		}
		
		
	}

}
