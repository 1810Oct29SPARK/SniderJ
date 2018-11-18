public class RotateNew{
public static void main(String [] args){
         int[] numberListToUse = new int[]{ 1,2,3,4,5};
         int RotateNumberToUse= 8;
       
       ArrayRotate(numberListToUse,RotateNumberToUse);
       
}



public static void ArrayRotate( int []Numberlist, int RotateNumber)
{

    for (int i=0;i<RotateNumber;i++)
	{
        int IndexHolder= Numberlist[0];
        for(int x=0;x<Numberlist.length;x++)
        {
            if(x==(Numberlist.length-1))
            {
            Numberlist[x]=IndexHolder;
            } 
            else
            {
            Numberlist[x]=Numberlist[(x+1)];
            }
        }
    }
    
        for (int num : Numberlist)  
        { 
            System.out.println(num);
        } 

}
}


