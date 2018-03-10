package HeadFirstOffer;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String[] strs = str.toString().split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i ++){
            if (strs[i].equals(" ")){
                sb.append("%20");
            } else {
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        StringBuffer sb = new StringBuffer("I want a apple.   ");
        ReplaceSpace s = new ReplaceSpace();
        String str = s.replaceSpace(sb);
        System.out.println(str);
    }

}