package dto;

public class AccountDto {

	//전화번호부랑 비슷
	//항목(입력받는 항목)
	private String date; 		//날짜 ex) 22/12/24	22/12/27
	private String use; 		//용도 ex) 영화관람		월급
	private String classify; 	//수입/지출 ex) 지출	수입
	private int money; 			//금액	ex) 25000	300000
	private String memo;		//내용	ex) 아바타2	12월급여
	
	
	
	//생성자
	public AccountDto() {
		
	}

	public AccountDto(String date, String use, String classify, int money, String memo) {
		super();
		this.date = date;
		this.use = use;
		this.classify = classify;
		this.money = money;
		this.memo = memo;
	}
	
	
	
	//setter getter

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	
	
	
	
	
	@Override
	public String toString() {
		return date + ":" +  use + ":" + classify + ":" + money + ":"
				+ memo;
	}
	
}
