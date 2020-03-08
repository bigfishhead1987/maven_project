package codetest_junit;

import java.util.ArrayList;

public class WordDictionary_junit {

	public String[] defaultDict;
	public String[] customizedDict;
	public String[] finalDict; 
	
	/*
	 * 1-customizedDict 2-bothDict
	 */
	public int dicType; 

	public  String[] getfinalDict() {
		if(this.dicType==1)
		{
			return customizedDict;				
		}
		else if(this.dicType==2)
		{
			return mergeDict(defaultDict, customizedDict);
		}
	
	    else return defaultDict;
	}

	public void setdefaultDict(String[] defaultDict) {
		this.defaultDict = defaultDict;
	}

	public void setdicType(int dicType) {
		this.dicType = dicType;
	}

	public void setcustomizedDict(String[] customizedDict) {
		this.customizedDict = customizedDict;
	}
	
	
	private static String[] mergeDict(String[] a1,String[] a2){
		ArrayList<String> arrayList1=new ArrayList<String>();
		ArrayList<String> arrayList2=new ArrayList<String>();
		for(String i:a1)
			arrayList1.add(i);
		for(String i:a2)
			arrayList2.add(i);
		arrayList1.removeAll(arrayList2);
		arrayList2.addAll(arrayList1);
		String[] stringArray = arrayList2.toArray(new String[arrayList2.size()]);
		return stringArray;
	}

	public static boolean isMatchedDic(String word,String[] dict){
		for(int i=0; i<dict.length; i++){
			if(dict[i].equals(word)){
				return true;
			}
		}
		return false;
	}
}
