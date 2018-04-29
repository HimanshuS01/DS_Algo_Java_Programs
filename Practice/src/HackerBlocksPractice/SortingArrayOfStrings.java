package HackerBlocksPractice;

public class SortingArrayOfStrings {

	//https://stackoverflow.com/questions/18689672/how-to-sort-a-string-array-alphabetically-without-using-compareto-or-arrays-sor
	
	//https://www.javatpoint.com/java-string-compareto
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] strArr = {"sdn","bvf","aba","aaa"};

		boolean done = false;
		while(!done)
		{
			done=true;   
			for(int i=0;i<strArr.length-1;i++)
			{
				if(!(strArr[i]==null))
				{
					String name1=strArr[i]; String name2=strArr[i+1];
					if(name1!=null&&name2!=null)
					{
						//compareTo function returns positive value if first string is lexicographically 
						//greater than second string otherwise negative value is returned.
						int num=name1.compareTo(name2);
						if(num>0)
						{ 
							String temp=strArr[i];
							strArr[i]=strArr[i+1];
							strArr[i+1]=temp;
							done=false ;
						}
					}
				}
			}
		}
		for(String str : strArr) {
			System.out.print(str+" ");
		}
	}

}
