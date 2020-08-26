package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {
    private ArrayList<Integer>numeroDoc;
    public Registry() {
    	numeroDoc = new ArrayList<Integer>();
    }
    public RegisterResult registerVoter(Person p) {  
    	numeroDoc.add(p.getId());
        if(p.isAlive() == false) {
        	return RegisterResult.DEAD;
        }else if(p.getAge()<18 && p.getAge()>0) {
        	return RegisterResult.UNDERAGE;
        }else if(p.getAge()<0) {
        	return RegisterResult.INVALID_AGE;
        }else if(isRepeated()){
        	return RegisterResult.DUPLICATED;
        }else {
        	return RegisterResult.VALID;
        }        
    }
    
    private boolean isRepeated() {
    	if(numeroDoc.size()>=2) {
        	for(int i = 0 ; i<numeroDoc.size();i++) {
        		for(int j = 1;j<numeroDoc.size();j++) {
        			if(numeroDoc.get(i) ==numeroDoc.get(j) && j <numeroDoc.size()) {
            			System.out.println("Lista : "+numeroDoc);
            			return true;
            		}	   		        			
        			
        		}
        	}
    	}
    	return false;
    }
}