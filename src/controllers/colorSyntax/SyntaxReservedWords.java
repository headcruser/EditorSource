package controllers.colorSyntax;

import java.util.ArrayList;
import java.util.StringTokenizer;



public class SyntaxReservedWords 
{
    public String RESERVED_WORDS;
    private ArrayList<String> principales;
    
    
    public void llenaString(ArrayList<String> keys) 
    {
        StringBuilder buff = new StringBuilder("");
        buff.append("(");
        for (String keyword : keys) {
            buff.append("\\b").append(keyword).append("\\b").append("|");
        }
        buff.deleteCharAt(buff.length() - 1);
        buff.append(")");
        RESERVED_WORDS = buff.toString();
    }
    
    private String cargaPropiedades() { return System.getProperty("reservadas"); }
    
    public void principales() {
        StringTokenizer st = new StringTokenizer("", " ");
        while (st.hasMoreTokens()) {
            principales.add(st.nextToken());
        }
    }

}
