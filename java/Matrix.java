package com.zoho;
import java.util.Scanner;
import java.util.InputMismatchException;
class GenMatrix
{
   int[][] array;
   GenMatrix(int[][] array)  
   {
      this.array = array;
   }
   GenMatrix add(GenMatrix fArr)
   {
      System.out.println(array.length);
      System.out.println(array[0].length);
      int[][] temp1 = new int[array.length][array[0].length];
      for(int i=0;i<array.length;i++)
      {
         for(int j=0;j<array[i].length;j++)
         {
            temp1[i][j] = fArr.array[i][j];
            temp1[i][j] = this.array[i][j]+temp1[i][j];
         } 
      }
      return new GenMatrix(temp1);
   }
   GenMatrix sub(GenMatrix fArr)
   {
      int[][] temp3 = new int[array.length][array[0].length];
      for(int i=0;i<array.length;i++)
      {
         for(int j=0;j<array[i].length;j++)
         {
            temp3[i][j] = fArr.array[i][j];
            temp3[i][j] = this.array[i][j]-temp3[i][j];
         } 
      }
      return new GenMatrix(temp3);
   }
   GenMatrix mul(GenMatrix mulArr)
   {
      int[][] temp2 = new int[mulArr.array.length][mulArr.array[0].length];
      int i = 0;
      while(i < array.length)
      {
         int j = 0;
         while(j < array.length)
         {
            int k = 0;
            while(k < mulArr.array[0].length)
            {
               temp2[i][j] = temp2[i][j] + this.array[i][k]*mulArr.array[k][j];
               k++;
            }
            j++;
         }
         i++;
      }
      return new GenMatrix(temp2);
   }
   public String toString()
   {

      String str = "";
      for(int i=0;i<array.length;i++)
      {
         for(int j=0;j<array[i].length;j++)
         {
            str= "\n"+str+ "        " + array[i][j];
         }
         str = str+"\n";
      }
      return str;
   }
} 
class Check
{
   int a;
   Check()
   {
      this.scan = new Scanner(System.in); 
   }
   Scanner scan = null;
   public int getNo()
   {
      boolean conn = true;
      while(conn)
      {
         try
         {
            a = Integer.parseInt(scan.next());
            conn =  false;
         }
         catch(Exception ex)
         {
            S matrix row  : ");
            int f_row = check.getNo();

            System.out.print("Enter the first matrix column  : ");
            int f_col = check.getNo();

            System.out.print("\nEnter the second matrix row : ");
            int s_row = check.getNo();

            System.out.print("Enter the second matrix column : ");
            int s_col = check.getNo();

            int[][] tArr1 = new int[f_row][f_col];
            int[][] tArr2 = new int[s_row][s_col];
            int[][] tArr3 = new int[f_col][s_row];


            for(int i=0;i<f_col;i++)
            {
               for(int j=0;j<s_row;j++)
               {
                  if(i == j)
                  {
                     tArr3[i][j] = 2;
                  }
                  else
                  {
                     tArr3[i][j] = 0;
                  }
               }
            }
            for(int fr=0;fr<f_row;fr++)
            {
               for(int fc=0;fc<f_col;fc++)
               {
                  System.out.print("Enter the First matrix ("+fr+","+fc+") value :");
                  tArr1[fr][fc] = check.getNo();
               }
            }
            System.out.println("\n");
            for(int sr=0;sr<s_row;sr++)
            {
               for(int sc=0;sc<s_col;sc++)
               {
                  boolean con2 = true;
                  System.out.print("Enter the second matrix ("+sr+","+sc+") value :");
                  tArr2[sr][sc] = check.getNo();
               }
            }
            GenMatrix fgMatrix = new GenMatrix(tArr1);
            GenMatrix sgMatrix = new GenMatrix(tArr2);
            GenMatrix tgMatrix = new GenMatrix(tArr3);
            while(true)
            {
               Scanner sc = new Scanner(System.in);
               System.out.print("\n\nAdd      a ;\nFormulae f ; \nMul      m ; \nclear    c ;\n\n  ");
               System.out.print("want       : ");
               String s = sc.next();
               switch(s.charAt(0))
               {
                  case 'a':
                     if((f_row == s_row) && (f_col == s_col))
                     {
                        System.out.println(fgMatrix.add(sgMatrix));
                     }
                     else
                     {
                        System.out.println("\t\t\tcannot addition ........");
                     }
                     break;
                  case 's':
                     if((f_row == s_row) && (f_col == s_col))
                     {
                        System.out.println(fgMatrix.sub(sgMatrix));
                     }
                     else
                     {
                        System.out.println("\t\t\ttry agin .........");
                     }
                     break;
                  case 'm':
                     if(f_col == s_row)
                     {
                        System.out.println(fgMatrix.mul(sgMatrix));
                     }
                     else
                     {
                        System.out.println("\t\t\tCannot multiplied  ......");
                     }
                     break;
                  case 'f':
                     {

                        if((f_row == s_row) && (f_col == s_col))
                        {
                           GenMatrix aSquare = fgMatrix.mul(fgMatrix);
                           GenMatrix bSquare = sgMatrix.mul(sgMatrix);
                           GenMatrix ab = fgMatrix.mul(sgMatrix);
                           GenMatrix ab2 = tgMatrix.mul(ab);
                           GenMatrix abSquare = aSquare.add(bSquare);
                           System.out.println(abSquare.add(ab2));

                        }
                        else
                        {
                           System.out.println("\t\t\tCannot be applied formulae a2+b2+2ab");
                        }
                     }
                     break;
                  case 'F':
                     if((f_row == s_row) && (f_col == s_col))
                     {
                        GenMatrix addab = fgMatrix.add(sgMatrix);
                        System.out.println(addab.mul(addab));
                     }
                     else
                     {
                        System.out.println("cannot be applied ...  (a+b)2");
                     }
                     break;
                  case 'c':
                     sc.close();
                     break;
               }
            }
         }
      }

