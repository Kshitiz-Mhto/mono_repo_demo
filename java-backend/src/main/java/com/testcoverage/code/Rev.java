package com.testcoverage.code;

public class Rev {
 
    public String revString(String inp){

        if(inp == null){
            return null;
        }
        if(inp.isEmpty()){
            return inp;
        }

        StringBuffer rev = new StringBuffer(inp);
        String revStringi = String.valueOf(rev.reverse());

        return  revStringi;

    }

}
