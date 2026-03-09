import java.util.*;
class bankmanagement 
{
    static Scanner scan = new Scanner(System.in);
    static int pinno = 2007;
    static int pin;
    static int flag = 0;
    static int goldOneGram = 9000;
    static int intersetRate = 8;
    int count = 1;
    static float  newgoldRenew;
    static float goldRenew;
    static String account;
    static float intersetAmmount;
    static String useracc =  "7XXXXXX1";
    static int current = 500;
    void display()
    {
        System.out.println("\n\t|1.Deposit\t|\n\t|2.WithDraw\t|\n\t|3.CheckBalance |\n\t|4.Cancel\t|");
    }
    void authentication()
    {
        for(int i = 1; i <=3; i++)
        {
            scan.nextLine();
            System.out.print("\n\t\tEnter Your Account Number: ");
            String account = scan.nextLine();
            System.out.print("\n\t\tEnter Your Pin Number: ");
            int pin = scan.nextInt();
            if(pin == pinno && useracc.equals(account))
            {
                display();
                flag = 1;
                break;
            }
            else
            {
                System.out.println("\n\t\t--Re-Enter Your Correct Pin Number--");
                count++;
            }
        }
        if(count > 3)
        {
            System.out.println("\n\t\t--Your Limit Ends Please Try Later!--");
        }

    }
    float intresetCal(float ToAm, float Time)
    {
        intersetAmmount = ToAm*intersetRate*goldRenew/ 100;
        return intersetAmmount;
    }
    public static void main(String args[])
    {
        bankmanagement money = new bankmanagement();
        System.out.println("\n\t\t\t\t\t\t\t    ATM");
        System.out.println("\n\n\t\t\t\t\t\t\t--WELCOME--");
        System.out.println("\n\n\t\t|1.ATM|\t\t\t|2.CHELLAN|\t\t\t|3.Gold Loan|");
        System.out.print("\n\tChoose :");
        int mainchoice = scan.nextInt();
        switch(mainchoice)
        {
            case 1:
                money.authentication();
                if(flag == 1)
                {
                    while(true)
                    {
                        System.out.print("\n\t\tEnter Your Choice : ");
                        int choice = scan.nextInt();
                        switch (choice) 
                        {
                            case 1:
                                System.out.print("\n\t\tEnter Your Deposit Money :");
                                int depo = scan.nextInt();
                                current += depo;
                                System.out.println("\n\t\t-- "+depo+" Successfully Deposited--");
                                break;
                            
                            case 2:     
                                System.out.print("\n\t\tEnter Your Ammount to WithDraw : ");
                                int with = scan.nextInt();
                                if(with > current )
                                {
                                    System.out.println("\n\t\t--Insufficient Balance--");
                                }
                                else
                                {
                                    current -= with;
                                    System.out.println("\n\t\t--Thank You!--");
                                }
                                break;

                            case 3:
                                System.out.println("\n\t\tAccount No:- "+useracc);
                                System.out.println("\n\t\tYour Current Balance Ammount is: "+current);
                                break;

                            case 4:
                                System.out.println("\n\t\t==Please Collect Your Card==\n\n");
                                break;
                            default:
                                break;
                        }
                        if(choice == 4)
                        {
                            break;
                        }
                    }
                }
                break;

            case 2:
                System.out.println("\n\t\t1.Deposit Chellan\n\t\t2.WithDraw Chellan");
                System.out.print("\n\t\tEnter your chellan : ");
                int chelno = scan.nextInt();
                switch(chelno)
                {
                    case 1:
                        System.out.print("\n\t\tDate: ");
                        int date = scan.nextInt();
                        System.out.print("\n\t\tEnter your Account Number: "+useracc);
                        scan.nextLine();
                        System.out.print("\n\t\tEnter Your Bank Name: ");
                        String bname = scan.nextLine();
                        System.out.print("\n\t\tEnter How much Money Need To Deposit: ");
                        int cheldepo = scan.nextInt();
                        current += cheldepo;
                        System.out.println("\n\t\tMoney Successfully Deposited In Your bank :"+cheldepo);
                        System.out.println("\n\t\tYour Current Ammout is :"+current);
                        break;
                    case 2:
                        System.out.print("\n\t\tDate: ");
                        int withdate = scan.nextInt();
                        System.out.println("\n\t\tEnter your Account Number: "+useracc);
                        scan.nextLine();
                        System.out.print("\n\t\tEnter Your Bank Name: ");
                        String withbname = scan.nextLine();
                        System.out.print("\n\t\tEnter How much Money Need To WithDraw: ");
                        int withcheldepo = scan.nextInt();
                        current -= withcheldepo;
                        System.out.println("\n\t\tMoney Successfully WithDraw In Your bank :"+withcheldepo);
                        System.out.println("\n\t\tYour Current Ammout is :"+current);
                        break;
                }
                break;
                case 3:
                        System.out.print("\n\t\tHowmuch Gram Of Gold: ");
                        int GiveGold = scan.nextInt();
                        int totalAmmount=goldOneGram*GiveGold; 
                        System.out.println("\n\t\tYou Got From Your Gold Is:"+totalAmmount);
                        System.out.println("\n\n\t\t--Your Intrest Deatils--");
                        System.out.println("\n\t\tYour Total Ammount: "+totalAmmount);
                        System.out.print("\n\t\tHow Many Month Did You Take To Renew Your Gold: ");
                        goldRenew = scan.nextInt();
                        if(goldRenew == 12)
                        {
                            money.intresetCal(totalAmmount,goldRenew);
                        }
                        else
                        {
                            float newgoldRenew = goldRenew / 12;
                            money.intresetCal(totalAmmount, newgoldRenew);
                        }
                        System.out.println("\n\n\t\tPer Month Intreset Ammount Is: "+intersetAmmount);
                        




                }


            }
        }        