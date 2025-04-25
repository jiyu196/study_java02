package service;

import java.util.ArrayList;
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
	
	{
		customers.add(new Customer(1, "새똥이","010-1111-2222", "ssa@gmail.com","ssa", "1234"));
	}
	
	//loginCustomer의 getter
	public Customer getLoginCustomer() {
		return loginCustomer;
	}
	
	
	public void register() {
		System.out.println("회원가입");
	}
	

	public void login() {
//		System.out.println("로그인");
		String id = BankUtils.nextLine("아이디 >");
		String pw = BankUtils.nextLine("비밀번호 >");
		
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
}
