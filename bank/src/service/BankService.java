package service;

import java.util.List;

import domain.Customer;
import utils.BankUtils;

public class BankService {
	private Customer loginCustomer;  //null이면 비로그인. null이면 로그인
	
	private static BankService bankService = new BankService();
	private BankService() {}
	public static BankService getInstance() {
		return bankService;    //싱글턴 규칙
	}
	
	private CustomerService customerService = CustomerService.getInstance();
	private AccountService accountService = AccountService.getInstance();
	
	public void menu() {
		if(customerService.getLoginCustomer() == null) { //
			int no = BankUtils.nextInt("1. 회원가입  2. 로그인  3. 로그아웃  4. 조회  5. 수정  6. 탈퇴");
			switch(no) {
				case 1:
					customerService.register(); break;
				case 2:
					customerService.login(); break;
				case 3:
					customerService.logout(); break;
				case 4:
					customerService.read(); break;
				case 5:
					customerService.modify(); break;
				case 6:
					customerService.out(); break;
//				case 7:
//					customerService.modify(); break;
			}
		}
		else { //
			System.out.println("로그인 상태");
			int no = BankUtils.nextInt("1. 내 정보 보기  2. 정보수정  3. 회원탈퇴  4. 개설  5. 입금  6. 출금  7. 이체  8. 해지  9. 로그아웃");
			switch(no) {
			case 1:
				customerService.mypage(); break;
			case 2:
				customerService.modify(); break;
			case 3:
				customerService.remove(); break;
			case 4:
				accountService.open(); break;
			case 5:
				accountService.deposit(); break;
			case 6:
				accountService.withdraw(); break;
			case 7:
				accountService.transfer(); break;
			case 8:
				accountService.close(); break;
			case 9:
				customerService.logout(); break;
		
			}
		}
		
	}
}
