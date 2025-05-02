package service;

import java.util.ArrayList;
import static utils.BankUtils.*;
import java.util.List;

import domain.Customer;
import utils.BankUtils;

public class CustomerService {
	private List<Customer> customers = new ArrayList<Customer>();  //리스트 부터 만들기
	private Customer loginCustomer;  //null이면 비로그인. null이면 로그인
	
	private static CustomerService customerService = new CustomerService();
	private CustomerService() {}
	public static CustomerService getInstance() {
		return customerService;  //싱글턴 
	}
	private AccountService accountService = AccountService.getInstance();
	{
		customers.add(new Customer(1, "새똥이","010-1111-2222", "ssa@gmail.com","ssa", "1234"));
	}
	
	//loginCustomer의 getter
	public Customer getLoginCustomer() {
		return loginCustomer;
	}
	
	
	public void register() {
		System.out.println("회원가입");
		String name = nextLine("이름"); //이름
		String tel = nextLine("전화번호(ex: 010-1111-2222) >"); //연락처
		String email =nextLine("이메일>");
		String id = nextLine("아이디>");
		String pw =nextLine("비밀번호>");
//		int no = 1; 
//		if(!customers.isEmpty()) {
//			no = customers.get(customers.size()-1).getNo()+1;
//		}  이렇게 해도 됨.
		int no = customers.isEmpty() ? 1 : customers.get(customers.size()-1).getNo()+1;
		Customer customer = new Customer(no, name, tel, email, id, pw);
		customers.add(customer);  //이렇게 하면 필드 낭비를 하지 않아도 됨. count 변수를 만들지 않은
		
		System.out.println("회원 가입 완료");
	} 
	
	public void mypage() {
		System.out.println("내 정보 보기");
		System.out.println(loginCustomer); //내정보만 보이게하는
		System.out.println("계좌 정보 조회");
		accountService.print(accountService.findAccountsBy(loginCustomer));
	}
	
	public void modify() {
		System.out.println("정보수정");
		String id = nextLine("아이디 >");
		Customer c = findById(id);
		if(c == null) {
			System.out.println("회원정보 없음");
			return;  //고유번호 정하면 그건 수정되지 않는거임.여기서는 아이디 수정 못하게해놓음
		}
		
		String name = nextLine("이름"); //이름
		String tel = nextLine("전화번호(ex: 010-1111-2222) >"); //연락처
		String email =nextLine("이메일>");
		String pw =nextLine("비밀번호>");
		
		c.setName(name);
		c.setTel(tel);
		c.setEmail(email);
		c.setPw(pw);
	}
	
	public void remove() { // 삭제하는건 데이터는 존재하는데 안보이게 하는 거
		System.out.println("탈퇴");  //탈퇴후 로그아웃 시켜야함. 계좌 해지 후 탈퇴할 수 있게 해야함
		
		//만약 계좌가 존재하면?
		if(!accountService.findAccountsBy(loginCustomer).isEmpty()) {
			System.out.println("계좌가 존재합니다. 해지 후 탈퇴 진행하세요");	
			return;
		}
		
		if(!nextConfirm("탈퇴하시겠습니까?")) {
			return;
		}
		customers.remove(loginCustomer);
		logout();
	}
	public Customer findById(String id) {
		for(Customer c : customers) {
			if(c.getId().equals(id)) {
				return c;
			}
		}
		return null;  //findBy 꼭 있어야함. 
	}

	public void login() {
//		System.out.println("로그인");
		String id = nextLine("아이디 >");
		String pw = nextLine("비밀번호 >");
		
		boolean flag = false;
		for(Customer c : customers) {
			if(c.getId().equals(id) && c.getPw().equals(pw)) {
				loginCustomer =c;
				break;
			}
		}
		if(!flag) {
			System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
		}
	}
	public void logout() {
		loginCustomer = null;
		System.out.println("로그아웃 되었습니다.");
	}
	public void deposit() {
		// TODO Auto-generated method stub
		
	}
}
