package game;



public class GameMenu {
	public static void main(String[] args) {
		System.out.println("================ 게임 메뉴 ==================");
		for(;;) {
			try {  //for문 밖에서 하면 ㄴㄴ
			switch (.nextInt("1. 가위바위보 2. 숫자 맞추기 3. 로또 4. 블랙 젝")) {
			case 1:
				service.register();
				break;
				
					
			case 2:
				service.read();
				break;
				
			case 3:
				service.modify();
				break;
				
			case 4:
				service.remove();
				break;
				
			case 5:
				service.allAvg();
				break;
				
			case 6:
				service.readOrder();
				break;
			
			case 7:
				System.out.println("bye~!");
				return;
			default:
				System.out.println("지정된 범위의 숫자만 입력하세오.");
				break;
			}	
		}
		catch (NumberFormatException e){
			System.out.println("정확한 숫자를 입력하시오.");
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
