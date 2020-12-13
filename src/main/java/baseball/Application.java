package baseball;

import java.util.Scanner;

import utils.RandomUtils;

public class Application {
	
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        
                
        while(true) {
        	int num = random();
        	int endnum;
        	
        	while(true) {
        		System.out.print("숫자를 입력해주세요 : ");
                int inNum = scanner.nextInt();
                int ball = ball(num,inNum);
                int strike = strike(num,inNum);
                	
                if(strike==3) {
                	System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                	endnum = scanner.nextInt(); 
                	break;
                }
                else if(strike==0&&ball==0) {
                	System.out.println("낫싱");
                	continue;
                }
                else if(strike==0) {
                	System.out.println(ball+"볼");
                	continue;
                }
                else if(ball==0) {
                	System.out.println(strike+"스트라이크");
                	continue;
                }                
                else {
                	System.out.println(ball+"볼 " + strike+"스트라이크");
                	continue;
                }     
        		
        	}
        	
        	if(endnum == 1) continue;
        	else break;        	       
       	}
            
    }
    
    
    
    public static int random() {
    	int num1 = RandomUtils.nextInt(1, 9);
    	
    	int num2 = RandomUtils.nextInt(1, 9);
    	if(num1==num2) {
    		while(num1==num2) {
    			num2 = RandomUtils.nextInt(1, 9);
        	}    		
    	}    	
    	
    	int num3 = RandomUtils.nextInt(1, 9);
    	if(num1==num3||num2==num3) {
    		while(num1==num3||num2==num3) {
    			num3 = RandomUtils.nextInt(1, 9);
    		}
    	}    	
    	
    	return num1*100+num2*10+num3;    	
    }
    
    public static int[] numtoarr(int num) {
    	int[] numarr = new int[3];
    	for(int i=2;i>=0;i--) {
    		numarr[i] = num%10;    		
    		num = num/10;    		
    	}
    	return numarr;
    }
    
    public static int ball(int num, int inNum) {
    	int ballnum = 0;
    	int[] numarr = numtoarr(num);
    	int[] inNumarr = numtoarr(inNum);
    	
    	for(int i=0;i<3;i++) {
    		for(int j=0;j<3;j++) {
    			if(i==j) continue;
    			if(numarr[i]==inNumarr[j]) ballnum++;
    		}
    	}
    	return ballnum;
    }
    
    public static int strike(int num, int inNum) {
    	int strikenum = 0;
    	for(int i=0;i<3;i++) {
    		if(num%10==inNum%10) strikenum++;
    		num = num/10;
    		inNum = inNum/10;
    	}
    	return strikenum;
    }
}
