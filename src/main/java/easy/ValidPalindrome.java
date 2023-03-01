package easy;

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String updatedString = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int i=0;
        int j=updatedString.length()-1;
        while(i<j){
            if(updatedString.charAt(i) == updatedString.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
class SollutionValidPalindrome{
    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean result=validPalindrome.isPalindrome("car is a car");
        System.out.println("Result for valid Palindrome :"+result);
    }
}