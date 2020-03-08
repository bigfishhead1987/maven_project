import java.util.ArrayList;

import codetest.WordDictionary;

public class WordBreak {

	
	public static void main(String[] args) {
		String inputStr="ilikeicecreamandmango";
		String[] defaultDict = { "i", "like", "sam", "sung", "samsung","mobile","man","go","ice","cream","and"};
		String[] customizedDict = { "i", "like", "sam", "sung", "mobile", "icecream", "mango","and"};
		WordDictionary wd=new WordDictionary();
		wd.setdefaultDict(defaultDict);
		System.out.println("Output of Stage#1 is :");
		wordBreakOutput(inputStr,wd);//
		WordDictionary wd_stage2=new WordDictionary();
		wd_stage2.setdefaultDict(defaultDict);
		wd_stage2.setcustomizedDict(customizedDict);
		wd_stage2.setdicType(1);
		System.out.println("Output of Stage#2 is :");
		wordBreakOutput(inputStr,wd_stage2);//
		WordDictionary wd_stage3=new WordDictionary();
		wd_stage3.setdefaultDict(defaultDict);
		wd_stage3.setcustomizedDict(customizedDict);
		wd_stage3.setdicType(2);
		System.out.println("Output of Stage#3 is :");
		wordBreakOutput(inputStr,wd_stage3);//

    
	}
	
	public static void wordBreakOutput(String inputStr,WordDictionary wordDictionary){
		ArrayList<String> arrayList = new ArrayList<String>();
		breakTheWord(inputStr, arrayList,wordDictionary);
	}

	public static void breakTheWord(String str, ArrayList<String> arrayList,WordDictionary wordDictionary){
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
			if(WordDictionary.isMatchedDic(substr,wordDictionary.getfinalDict())){
				arrayList.add(substr);
				breakTheWord(str.substring(i), arrayList,wordDictionary);
				arrayList.remove(arrayList.size()-1);
			}
		}
	}

	
}