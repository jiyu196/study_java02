package service;

import java.util.ArrayList;
import static utils.BankUtils.*;
import java.util.List;

import domain.Customer;

//import student.StudentUtils;
import utils.BankUtils;

public class CustomerService {
	//회원의 추가(가입)
	//회원 정보 조회(본인정보만 나오게)
	//내 정보 수정
	//탈퇴
	
	private List<Customer> customers = new ArrayList<Customer>();  //리스트 부터 만들기
	private List<Customer> sortedCustomers;  ////sortedStudents.addAll(students); 이거하면 addAll 할 수 있는
	private Customer loginCustomer;  //null이면 비로그인. null이면 로그인
	
	private static CustomerService customerService = new CustomerService();
	private CustomerService() {}
	public static CustomerService getInstance() {
		return customerService;  //싱글턴 
	}
	private AccountService accountService = AccountService.getInstance();
	{
		customers.add(new Customer(1, "새똥이","010-1111-2222", "ssa@gmail.com","ssa", "1234"));
//		customers.add(new Customer(2, "개똥이","010-2222-3333", "sss@gmail.com","sss", "5678"));
//		customers.add(new Customer(3, "말똥이","010-3333-4444", "saa@gmail.com","saa", "1111"));
//		customers.add(Customer.builder().no(1).name("새똥이).no(randomScore()).tel(randomScore()).email(randomScore()).build()";  전화번호, 이메일을 랜덤으로 하는건 어떻게 해야할까
//		public int randomScore() {
//
//			return (int) (Math.random() * 41 + 60);   
//		}
	}
	
	Customer findBy(int no) {
		Customer customer = null; 
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getNo() == no) {
				customer = customers.get(i);
				break;
			}
			
		}
		return customer;
	}
	public int checkRange(String id, String pw) {
		return checkRange(id,pw);
	}

	public String inputName() {
		String name = BankUtils.nextLine("이름 > ");   
		if(!name.matches("[가-힣]{2,4}")) {
			throw new IllegalArgumentException("이름은 2~4글자의 한글입니다.");
		}
		return name;
	}
	public String inputTel() {
		String tel = BankUtils.nextLine("전화번호 > ");   
		if(!tel.matches("(0\\d{1,2})-(\\d{3,4})-(\\d{4})")) {
			throw new IllegalArgumentException("본인 휴대전화 번호를 입력해주세요");
		}
		return tel;
	}
	
	public String inputEmail() {
		String email = BankUtils.nextLine("이메일 > ");   
		if(!email.matches("(\\w)@(\\w+).(\\w+)")) {
			throw new IllegalArgumentException("이메일 형식으로 입력해주세요");
		}
		return email;
	}
	
	//loginCustomer의 getter
	public Customer getLoginCustomer() {
		return loginCustomer;
	}
	
	//등록
	public void register() {
		System.out.println("회원가입");
<<<<<<< HEAD
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

=======
		
		int no = BankUtils.nextInt("회원번호 > ");
		Customer c = findBy(no);
		
		if(c != null) {
			System.out.println("중복된 회원번호가 존재합니다.");
			return;
		}

//		int no = BankUtils.nextInt(" > ");    //회원번호는 가입이 끝나면 자동으로 부여되야하는거같은데
//		checkRange("회원번호", no);               //BankService에서 등록을 하면 생기는건 어떻게 만드는건지
		
		String name = BankUtils.nextLine("이름 > ");
		String tel = BankUtils.nextLine("전화번호 > ");      //여기서 예외 발생하면  main으로 넘김
		String email = BankUtils.nextLine("이메일 > "); 
		
		String id = BankUtils.nextLine("새로운 아이디 > ");      
		
		
		String pw = BankUtils.nextLine("새로운 비밀번호 > ");      
		
		
		customers.add(new Customer(no, name, tel, email, id, pw));
		rank();
		
	}
	
	//로그인
>>>>>>> 20fd4608ef95abc23d59b50b7dff181ab1e16099
	public void login() {
//		System.out.println("로그인");
		String id = nextLine("아이디 >");
		String pw = nextLine("비밀번호 >");
		
		boolean flag = false;
		for(Customer c : customers) {
			if(c.getId().equals(id) && c.getPw().equals(pw)) {
				loginCustomer =c;
				System.out.println("로그인 되었습니다.");
				break;
			}
		}
		if(!flag) {
			System.out.println("아이디 또는 비밀번호가 틀렸습니다.");     
		}
	}
	//로그아웃
	public void logout() {
		loginCustomer = null;
		System.out.println("로그아웃 되었습니다.");
	}
<<<<<<< HEAD
	public void deposit() {
		// TODO Auto-generated method stub
		
	}
=======
	
	//조회
	public void read()	 {
		System.out.println("정보 조회");
		String id = BankUtils.nextLine("아이디 >");
		String pw = BankUtils.nextLine("비밀번호 >");
		boolean flag = false;
		for(Customer c : customers) {
		if(c.getId().equals(id) == c.getPw().equals(pw)) {
			System.out.println("조회 가능합니다.");
			break;
		}
		System.out.println(customers);                      //아이디 비밀번호 입력 후 회원 정보 내용이 뜨지 않음.
	}
//		if(!flag) {
//			System.out.println("본인이 아닙니다.");         //조회 가능하다랑 본인이 아니라는게 둘다 뜸. 이걸 지우면
//		} return;                                             뭘 입력해도 조회가능하다고 뜸. ..
}
	public void print(List<Customer> cus) {
//		for (int i = 0; i < cus.size(); i++) {
//			System.out.println(cus.get(i));
		cus.forEach(c -> System.out.println(c)); 
		
	}
	
	//수정
	public void modify() {
		System.out.println("내 정보 수정");
		int no = BankUtils.nextInt("수정할 회원번호 > ");
		Customer c = findBy(no);
		if (c == null) {
			System.out.println("입력된 회원번호가 존재하지 않습니다.");
			return;
		}
		String name = inputName();
		String tel = inputTel();
		String email = inputEmail();
		c.setName(BankUtils.nextLine("이름 > "));
		c.setTel(BankUtils.nextLine("전화번호 > "));
		c.setEmail(BankUtils.nextLine("이메일 > "));
		c.setId(BankUtils.nextLine("아이디 > "));
		c.setPw(BankUtils.nextLine("비밀번호 > "));
		rank();
	}
	
	public void rank() {
		
	}
	
	//탈퇴
	public void out() {
		System.out.println("탈퇴");
		int no = BankUtils.nextInt("탈퇴할 회원번호 > ");
		Customer c = findBy(no);  
		if (c == null) {
			System.out.println("탈퇴되었습니다.");  
			return;
		}

		customers.remove(c);

	
	}
>>>>>>> 20fd4608ef95abc23d59b50b7dff181ab1e16099
}
