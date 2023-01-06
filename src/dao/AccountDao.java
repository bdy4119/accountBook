package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.AccountDto;
import proc.FileProc;

public class AccountDao {
	
	Scanner sc = new Scanner(System.in);
	
	private List<AccountDto> list = new ArrayList<AccountDto>();
	
	private FileProc fileProc = null;
	
	//생성자
	public AccountDao() {
		
		fileProc = new FileProc("account");
		fileload();
		
		
		AccountDto d = new AccountDto("22/12/24", "영화", "지출", 25000, "아바타2");
		list.add(d);
		
		d = new AccountDto("22/12/27", "월급", "수입", 300000, "12월급여");
		list.add(d);
		
	}
	
	
	//CRUD(검색 저장 삭제 추가)
	public void insert() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("항목을 추가합니다.");
		
		System.out.print("날짜 >>");
		String date = sc.next();
		
		System.out.print("용도 >>");
		String use = "";
		try {
			use = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("수입/지출 >>");
		String classify = sc.next();
		
		System.out.print("금액 >>");
		int money = sc.nextInt();
		
		System.out.print("메모 >>");
		String memo = "";
		try {
			memo = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AccountDto dto = new AccountDto(date, use, classify, money, memo);
		list.add(dto);
		
	}
	

	public void delete() {
		System.out.print("삭제할 목록을 검색하세요(지출/수입, 메모, 용도)>>>");
		String str = sc.next();
		
		int index = search(str);
		
		if(index == -1) {
			System.out.println("해당 정보를 찾을 수 없습니다.");
		} else {
			list.remove(index);
			System.out.println("해당 정보를 삭제했습니다.");
		}
	}
	
	
	//검색
	// 각 항목을 따로해서 selct를 만듬
	public void selectMonth() {
		// 연도월별 결산
		System.out.println("날짜를 검색하세요 (00/00/00) >>>");
		String date = sc.next();
		
		for(AccountDto dto : list) {
			if(date.equals(dto.getDate())) {
				System.out.println(dto.toString());
			}
		}
		//해당 데이터를 찾을 수 없습니다..??
		
		
	}
	
	public void selectUse() {
		// 수입/지출
		System.out.println("수입/지출 중에 골라주세요.>> ");
		String classify = sc.next();
		
		for(AccountDto dto : list) {
			if(classify.equals(dto.getClassify())) {
				System.out.println(dto.toString());
			}
		}
	}
	
	public void select() {
		
		// 용도 -> 뭐에 썼는지
		System.out.println("어떤 용도로 사용했는지 검색해주세요>> ");
		String use = sc.next();
		
		for(AccountDto dto : list) {
			if(use.equals(dto.getUse())) {
				System.out.println(dto.toString());
			}
		}
	}
	
	public void update() {
		System.out.println("수정할 목록을 검색해주세요.(지출/수입, 메모한내용, 용도)>>>");
		String str = sc.next();
		
		int index = search(str);
		if(index == -1) {
			System.out.println("해당 정보를 찾을 수 없습니다.");
			return;
		}
		//수정
		System.out.println("데이터를 찾았습니다");
		System.out.println("금액 >>> ");
		int money =sc.nextInt();
		
		System.out.println("지출/수입 >>> ");
		String classify =sc.next();
		
		
		list.get(index).setMoney(money);
		list.get(index).setClassify(classify);
		System.out.println("정상적으로 수정되었습니다");
		
	}
	
	
	public void allDataPrint() {
		for(AccountDto dto : list) {
			System.out.println(dto.toString());
		}
	}
	
	
	//search메소드 만들어서 각항목에서 문자열 비교해서 출력
	public int search(String str) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			AccountDto dto = list.get(i);
			if(str.equals(dto.getDate())) {
				index = i;
				break;
			} else if(str.equals(dto.getMemo()) ) {
				index = i;
				break;
			} else if(str.equals(dto.getClassify())) {
				index = i;
				break;
			} else if(str.equals(dto.getUse())) {
				index = i;
				break;
			} else if(str.equals(Integer.toString(dto.getMoney()))) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	
	public void allSelect() {
		System.out.println("검색유형을 선택하세요 >>>");
		System.out.println("1. 날짜검색");
		System.out.println("2. 수입/지출");
		System.out.println("3. 용도");
		
		System.out.println("실행할 번호 >>> ");
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1 :
				selectMonth();
				break;
			case 2 :
				selectUse();
				break;
			case 3 :
				select();
				break;
		}
	}
	
	
	
	public void fileSave() {
		String dataArr[] = new String[list.size()];
	
		for (int i = 0; i < list.size(); i++) {
			dataArr[i] = list.get(i).toString();
		}
		fileProc.write(dataArr);
	}
	
	
	
	public void fileload() {
		String datas[] = fileProc.read();
		
		for (int i = 0; i < datas.length; i++) {
			String split[] = datas[i].split(":");
			
			AccountDto h = new AccountDto(split[0], split[1], split[2], 		
											Integer.parseInt(split[3]), 
											split[4]);			
			list.add(h);
		}
		
	}
	
	
}
