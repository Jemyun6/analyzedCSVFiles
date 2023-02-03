package assignment4;

class test {
    static int count ;
    public static void main(String[] args) {
		countSubstrings("aaa");
	}
    
    public static int countSubstrings(String s) {
        
        backtrack(s, 0);
        System.out.println(count);
        return count  ;
    }

    public static void backtrack(String s, int level){
        if(level == s.length()){
            return;
        }

        for(int i = level; i < s.length(); i++){
            String subString = s.substring(level, i+1);

            if(!isPalindrom(subString)){
               continue;
            } 
            backtrack(s, i+1);
             count++;
            System.out.println(subString);
        }
    }

    public static boolean isPalindrom(String s){
        int length = s.length(), left = 0, right = length - 1;
        if(length == 0) return false;

        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}