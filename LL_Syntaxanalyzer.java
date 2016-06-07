
public class LL_Syntaxanalyzer { 

	 public static StringBuffer stack=new 

	StringBuffer("#E"); 

	 public static StringBuffer stack2=new 

	StringBuffer("i+i*#"); 

	  

	 public static void main(String arts[]){ 

	  //stack2.deleteCharAt(0); 

	  System.out.print(accept(stack,stack2)); 

	 } 

	    public static boolean accept(StringBuffer 

	stack,StringBuffer stack2){//判断识别与否  

	       

	        boolean result=true; 

	     outer:while (true) { 

	      System.out.format("%-9s",stack+""); 

	       System.out.format("%9s",stack2+"\n"); 

	   char c1 = stack.charAt(stack.length() - 1); 

	   char c2 = stack2.charAt(0); 

	   if(c1=='#'&&c2=='#') 

	    return true; 

	   switch (c1) {    case 'E': 

	    if(!E(c2)) {result=false;break outer;} 

	    break; 

	   case 'P':                  //P代表E’ 

	    if(!P(c2)) {result=false;break outer;} 

	    break; 

	   case 'T': 

	    if(!T(c2)) {result=false;break outer;} 

	    break; 

	   case 'Q':                 //Q代表T’ 

	    if(!Q(c2)) {result=false;break outer;} 

	    break; 

	   case 'F': 

	    if(!F(c2)) {result=false;break outer;} 

	    break; 

	   default: {//终结符的时候 

	    if(c2==c1){ 

	     stack.deleteCharAt(stack.length()-1); 

	     stack2.deleteCharAt(0); 

	     //System.out.println(); 

	    } 

	    else{      return false; 

	    } 

	   } 

	   } 

	 

	   if(result=false) 

	    break outer; 

	  } 

	       

	     return result; 

	      

	    } 

	     

	    public static boolean E(char c) {//语法分析子程序  E 

	     boolean result=true; 

	     if(c=='i') { 

	      stack.deleteCharAt(stack.length()-1); 

	      stack.append("PT");  

	     } 

	     else if(c=='('){ 

	      stack.deleteCharAt(stack.length()-1); 

	      stack.append("PT");       } 

	     else{ 

	      System.err.println("E 推导时错误不能匹配"); 

	      result=false; 

	     } 

	     return result; 

	    } 

	    public static boolean P(char c){//语法分析子程序  P 

	     boolean result=true; 

	     if(c=='+') { 

	      stack.deleteCharAt(stack.length()-1); 

	      stack.append("PT+");  

	     } 

	     else if(c==')') { 

	      stack.deleteCharAt(stack.length()-1); 

	      //stack.append("");  

	      System.out.println("P->/"); 

	     } 

	     else if(c=='#') { 

	      stack.deleteCharAt(stack.length()-1); 

	      //stack.append("");  

	      System.out.println("P->/");      } 

	     else{ 

	      System.err.println("P 推导时错误不能匹配"); 

	      result=false; 

	     } 

	     return result; 

	    } 

	    public static boolean T(char c) {//语法分析子程序  T 

	     boolean result=true; 

	     if(c=='i') { 

	      stack.deleteCharAt(stack.length()-1); 

	      stack.append("QF");  

	     } 

	     else if(c=='(') { 

	      stack.deleteCharAt(stack.length()-1); 

	      stack.append("QF");  

	     } 

	     else{ 

	      result=false; 

	      System.err.println("T 推导时错误不能匹配"); 

	     } 

	     return result;     } 

	    public static boolean Q(char c){//语法分析子程序  Q 

	     boolean result=true; 

	     if(c=='+') { 

	      stack.deleteCharAt(stack.length()-1); 

	      //stack.append("");  

	      System.out.println("Q->/"); 

	     } 

	     else if(c=='*') { 

	      stack.deleteCharAt(stack.length()-1); 

	      stack.append("QF*");  

	     } 

	     else if(c==')') { 

	      stack.deleteCharAt(stack.length()-1); 

	      //stack.append("");  

	      System.out.println("Q->/"); 

	     } 

	     else if(c=='#') { 

	      stack.deleteCharAt(stack.length()-1); 

	      //stack.append("");  

	      System.out.println("Q->/"); 

	     }      else{ 

	      result=false;  

	      System.err.println("Q 推导时错误不能匹配"); 

	     } 

	     return result; 

	    } 

	    public static boolean F(char c) {//语法分析子程序  F 

	     boolean result=true; 

	     if(c=='i') { 

	      stack.deleteCharAt(stack.length()-1); 

	      stack.append("i");  

	     } 

	     else if(c=='(') { 

	      stack.deleteCharAt(stack.length()-1); 

	      stack.append(")E(");  

	     }  

	     else{ 

	      result=false; 

	      System.err.println("F 推导时错误不能匹配"); 

	     } 

	     return result; 

	    }    /* public static StringBuffer changeOrder(String 

	s){//左右交换顺序 

	     StringBuffer sb=new StringBuffer(); 

	     for(int i=0;i<s.length();i++){ 

	      sb.append(s.charAt(s.length()-1-i)); 

	     } 

	     return sb; 

	    }*/ 

	}
