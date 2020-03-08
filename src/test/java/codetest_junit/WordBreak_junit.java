package codetest_junit;

import java.util.ArrayList;

import org.junit.Test;

import codetest_junit.WordDictionary_junit;

public class WordBreak_junit {

	
	@Test
	public void wordBreakOutput()
	{   
		String inputStr="ilikeicecreamandmango";
		String[] defaultDict = { "i", "like", "sam", "sung", "samsung","mobile","man","go","ice","cream","and"};
		String[] customizedDict = { "i", "like", "sam", "sung", "mobile", "icecream", "mango","and"};
		WordDictionary_junit wd=new WordDictionary_junit();
		wd.setdefaultDict(defaultDict);
		System.out.println("Output of Stage#1 is :");
		wordBreakOutput(inputStr,wd);
		WordDictionary_junit wd_stage2=new WordDictionary_junit();
		wd_stage2.setdefaultDict(defaultDict);
		wd_stage2.setcustomizedDict(customizedDict);
		wd_stage2.setdicType(1);
		System.out.println("Output of Stage#2 is :");
		wordBreakOutput(inputStr,wd_stage2);
		WordDictionary_junit wd_stage3=new WordDictionary_junit();
		wd_stage3.setdefaultDict(defaultDict);
		wd_stage3.setcustomizedDict(customizedDict);
		wd_stage3.setdicType(2);
		System.out.println("Output of Stage#3 is :");
		wordBreakOutput(inputStr,wd_stage3);
	}
	
	
	public  void wordBreakOutput(String inputStr,WordDictionary_junit wordDictionary){
		ArrayList<String> arrayList = new ArrayList<String>();
		breakTheWord(inputStr, arrayList,wordDictionary);
	}
    
	
	public  void breakTheWord(String str, ArrayList<String> arrayList,WordDictionary_junit wordDictionary){
		int len = str.length();
		if(len == 0){
			String[] resultArray = arrayList.toArray(new String[arrayList.size()]);
			String result="";
			
			for(int i=0;i<resultArray.length;i++)
			{
				if(resultArray[i] != null)
					result+=resultArray[i]+" ";
			}
			System.out.println(result);
			return;
		}
		
		
		for(int i=1; i<=len; i++){
			String substr = str.substring(0, i);
			if(WordDictionary_junit.isMatchedDic(substr,wordDictionary.getfinalDict())){
				arrayList.add(substr);
				breakTheWord(str.substring(i), arrayList,wordDictionary);
				arrayList.remove(arrayList.size()-1);
			}
		}
	}

	
}