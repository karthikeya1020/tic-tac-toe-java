import java.util.*;
class TicTacToeLogic
{
    boolean winner(char a[][],char ch)
    {
        //Checking rows
        for(int i=0;i<3;i++)
            if(a[i][0]==ch && a[i][1]==ch && a[i][2]==ch)
                return true;
        
        //Checking coloumns
        for(int i=0;i<3;i++)
            if(a[0][i]==ch && a[1][i]==ch && a[2][i]==ch)
                return true;
        
        //Checking right diagonal
        if(a[0][0]==ch && a[1][1]==ch && a[2][2]==ch)
                return true;
        
        //Checking left diagonal
        if(a[0][2]==ch && a[1][1]==ch && a[2][0]==ch)
                return true;
        
        return false;
    }

    boolean placeElement(char n,char a[][],char ch){
        int i,j;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                if(a[i][j]==n){
                    a[i][j]=ch;
                    return true;
                }
            }
        }
        return false;
    }

    void display(char a[][]){
        for(int i=0;i<3;i++){
            System.out.println(" "+a[i][0]+" | "+a[i][1]+" | "+a[i][2]);
            if(i<2)
                System.out.println("-----------");
        }
    }
}
public class TicTacToe
{
    public static void main(String[] args)
    {
        System.out.println("TIC TAC TOE\n");
        TicTacToeLogic t=new TicTacToeLogic();
        boolean found,win;
        int i=1;
        char a[][]={{'1','2','3'},{'4','5','6'},{'7','8','9'}},ch;
        t.display(a);
        Scanner sc=new Scanner(System.in);

        while(i<=9)
        {
            if(i%2!=0)
                System.out.print("\nPlayer-1's turn('X'):");
            else
                System.out.print("\nPlayer-2's turn('O'):");

            int num=sc.nextInt();
            char n=(char)(num + '0');
            ch=(i%2!=0)?'X':'O';
            found=t.placeElement(n,a,ch);

            if(!found){
                System.out.println("Already filled..Enter another number...\n");
                i--;
            }
            t.display(a);
            win=t.winner(a,ch);
            if(win && ch=='X')
                System.out.println("\n\nPlayer-1 Wins!!!!\n\n");
            if(win && ch=='O')
                System.out.println("\n\nPlayer-2 Wins!!!!\n\n");
            if(win)
                break;
            i++;
        }
        if(i>9)
            System.out.println("\n\nMatch Draw...");
        sc.close();
    }
}