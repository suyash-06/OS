import java.util.Scanner;
public class Scheduling {
   public static void main(String args[])
   {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter no. of processes: ");
    
    int n = sc.nextInt();
    int pid[] = new int[n];
    int at[] = new int[n];     
    int bt[] = new int[n];    
    int ct[] = new int[n]; 
    int tat[] = new int[n];     
    int wt[] = new int[n];      
    float twt=0,ttat=0;
    int temp;
    for(int i=0;i<n;i++)
    {
	System.out.println("Enter process "+(i+1)+" arrival time: ");
	at[i]=sc.nextInt();
	System.out.println("Enter process "+(i+1)+" brust time: ");
	bt[i]=sc.nextInt();
        pid[i]=i+1;   
     }
    for(int i=0;i<n;i++)
    {
	for(int j=0;j<n-(i+1);j++)
	{
            if(at[j]>at[j+1])
            {
		temp=at[j];
		at[j]=at[j+1];
		at[j+1]=temp;
		temp=bt[j];
		bt[j]=bt[j+1];
		bt[j+1]=temp;
		temp=pid[j];
		pid[j]=pid[j+1];
		pid[j+1]=temp;
            }
        }
    }
    for(int i=0;i<n;i++)
    {
	if(i==0)
	{	
            ct[i]=at[i]+bt[i];
	}
	else
        {
            if(at[i]>ct[i-1])
            {
                ct[i]=at[i]+bt[i];
            }
            else
		ct[i]=ct[i-1]+bt[i];
        }
        tat[i]=ct[i]-at[i] ;          
	wt[i]=tat[i]-bt[i] ;          
	twt=twt+wt[i] ;               
	ttat=ttat+tat[i] ;       

    }
    for(int i=0;i<n;i++)
    {
	for(int j=0;j<n-(i+1);j++)
	{
            if(pid[j]>pid[j+1])
            {
		temp=at[j];
		at[j]=at[j+1];
		at[j+1]=temp;
		temp=bt[j];
		bt[j]=bt[j+1];
		bt[j+1]=temp;
                temp=ct[j];
		ct[j]=ct[j+1];
		ct[j+1]=temp;
		temp=pid[j];
		pid[j]=pid[j+1];
		pid[j+1]=temp;
                temp=tat[j];
		tat[j]=tat[j+1];
		tat[j+1]=temp;
                temp=wt[j];
		wt[j]=wt[j+1];
		wt[j+1]=temp;
            }
        }
    }
    System.out.println("\nPId  Arrival  Brust  Complete Turn Waiting");
    for(int i=0;i<n;i++)
    {
	System.out.println(pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]) ;
    }
    System.out.println("\nAverage Waiting Time: "+ (twt/n)); 
    System.out.println("Average Turn Around Time:"+(ttat/n)); 
}
}