import java.util.Scanner;
import java.util.Vector;


public class Main {

    public static void main(String[] args) {
    Vector<String > ImagesNames= new Vector<String>();
    ImagesNames.add("12.bmp");
    ImagesNames.add("33.bmp");
    ImagesNames.add("89.bmp");
   
   Vector<String > Names= new Vector<String>();
    Names.add("0001");
    Names.add("0011");
    Names.add("1000");

           String path =ImagesNames.elementAt(0); 
          ImageProcessing image= new ImageProcessing(path);
         Vector<Integer> X1= image.readImage();
         
          String path1 =ImagesNames.elementAt(1); 
          ImageProcessing image1= new ImageProcessing(path1);
         Vector<Integer> X2= image1.readImage();
         
          String path11 =ImagesNames.elementAt(2); 
          ImageProcessing image11= new ImageProcessing(path11);
         Vector<Integer> X3= image11.readImage();
         
   int width =image.width;
   int height =image.height;
   System.out.print("Width  "+width );
   System.out.print("height  "+height );

     int counter =0;
  Scanner input=new Scanner (System.in);
  int size_x=X1.size(); 
  System.out.print("Enter Image Name " );
  path11 =input.next();
 ImageProcessing image2= new ImageProcessing(path11);
  Vector<Integer> Xo= image2.readImage();

 int [][] X1X1= new int[size_x][size_x];
  int [][] X2X2= new int[size_x][size_x];
 int [][] X3X3= new int[size_x][size_x];
 int [][] W= new int[size_x][size_x];

 for (int i=0; i<size_x; ++i){
    for (int j=0,k=0; j<size_x; ++j,++k){
     
        X1X1[i][k] = X1.get(i)*X1.get(j) ; 
        }
}
 for (int i=0; i<size_x; ++i){
    for (int j=0,k=0; j<size_x; ++j,++k){
     
        X2X2[i][k] = X2.get(i) *X2.get(j) ; 
        }
   }

for (int i=0; i<size_x; ++i){
    for (int j=0,k=0; j<size_x; ++j,++k){
     
        X3X3[i][k] = X3.get(i)*X3.get(j) ; 
        }
}

for (int i=0; i<size_x; ++i){
    for (int j=0; j<size_x; ++j){
    
        W[i][j] =  X1X1[i][j] +X2X2[i][j]+X3X3[i][j] ; 
        }
}
/*
 * 
  System.out.println("W = "); 
 
for (int i=0; i<size_x; ++i){
    for (int j=0; j<size_x; ++j){
     // for (int k=0; k<size_y; ++k)
       System.out.print(W[i][j] +" " ) ; 
        
        }
         System.out.println();
}*/
int H_X1=0;
int H_X2=0;
int H_X3=0;
for(int i =0 ;i<size_x;i++ )
{
    if(X1.get(i)!=Xo.get(i))
    H_X1++;
    
  if(X2.get(i)!=Xo.get(i))
    H_X2++;
    
  if(X3.get(i)!=Xo.get(i))
    H_X3++;
}


//int min_H_X=Math.min(H_X1, H_X2);
//int min_H_Y=Math.min(H_Y1, H_Y2);

// Recall X
 int [] X_1_1 =new int [size_x];
 int [] X_2_1 =new int [size_x];
 int [] X_1_2 =new int [size_x];
 int [] X_2_2 =new int [size_x];
 
while(true){
    
for (int i = 0; i < size_x ; i++) { // aRow
            for (int j = 0; j < 1; j++) { // bColumn
                for (int k = 0; k < size_x; k++) { // aColumn
                    X_1_1[i]+= W[i][k] * Xo.get(k);
                }
               
            }
    }
/*
System.out.println ();
System.out.println("Y_111");
for( int i=0 ;i<size_y;i++){
System.out.print (Y_1[i] + "  ");

}
    */
    for(int i=0 ;i<size_x;i++ )
    {
     if(X_1_1[i]>0)
      X_1_1[i]=1;
      else  if( X_1_1[i]<0)
      X_1_1[i]=-1;
      else{ 
          
        if(H_X1<=H_X2&&H_X1<=H_X3)
        X_1_1[i]=X1.get(i);
        else  if(H_X2<=H_X1&&H_X2<=H_X3)
        X_1_1[i]=X2.get(i);
        else
        X_1_1[i]=X3.get(i);
       }
 
    }
 //System.out.println(" X_1 ");

for (int i = 0; i < 1; i++) { // aRow
            for (int j = 0; j < size_x; j++) { // bColumn
                
                for (int k = 0; k < size_x; k++) { // aColumn
                    X_2_1[j]+= X_1_1[k] * W[k][j] ;
                }
            }
    }
    
/*System.out.println();
System.out.println("X_1");
for( int i=0 ;i<size_x;i++){
System.out.print (X_1[i] + "  ");

}*/

     for(int i=0 ;i<size_x;i++ )
    {
     if( X_2_1[i]>0)
      X_2_1[i]=1;
      else  if( X_2_1[i]<0)
      X_2_1[i]=-1;
       else{ 
        if(H_X1<=H_X2&&H_X1<=H_X3)
        X_2_1[i]=X1.get(i);
        
       else if(H_X2<=H_X1&&H_X2<=H_X3)
        X_2_1[i]=X2.get(i);
         
       else
          X_2_1[i]=X3.get(i);
       }
 
    }  
    if(counter>0)
    {
Boolean check_X1=false ,check_X2=false;
 for(int i=0;i<size_x;i++)
 {  
     if (X_1_1[i] ==X_1_2[i])
  check_X1=true;
    else {
    check_X1=false;
     break;}
 }
 for(int i=0;i<size_x;i++)
 {  
     if (X_2_1[i] ==X_2_2[i])
  check_X2=true;
    else {
    check_X2=false;
    break;
     }
 }
 
 if(check_X1==true &&check_X2==true)
  break;
    }
   //  System.out.println(" Y_2 ");

    for (int i = 0; i < size_x ; i++) { // aRow
            for (int j = 0; j < 1; j++) { // bColumn
                for (int k = 0; k < size_x; k++) { // aColumn
                    X_1_2[i]+= W[i][k] * X_2_1[k];
                }
            }


    }
   /* System.out.println ();
    System.out.println("Y_2");
    for( int i=0 ;i<size_y;i++){
    System.out.print (Y_2[i] + "  ");

    }
    */
    for(int i=0 ;i<size_x;i++ )
    {
     if( X_1_2[i]>0)
      X_1_2[i]=1;
      else  if( X_1_2[i]<0)
      X_1_2[i]=-1;
      else{ 
        if(H_X1<=H_X2&&H_X1<=H_X3)
        X_1_2[i]=X1.get(i);
   else   if(H_X2<H_X1 && H_X2<=H_X3)
        X_1_2[i]=X2.get(i);
        else
    X_1_2[i]=X3.get(i);
       }
 
    }
//     System.out.println("X_2 ");

    for (int i = 0; i < 1; i++) { // aRow
            for (int j = 0; j < size_x; j++) { // bColumn
                for (int k = 0; k < size_x; k++) { // aColumn
                    X_2_2[j]+=X_1_2[k]*W[k][j] ;
                }
            }
            // System.out.println(X_2[i] +" ");

    }
    
  /*  System.out.println ();
    System.out.println("X_2");
    for( int i=0 ;i<size_x;i++){
    System.out.print (X_2[i] + "  ");

    }*/
for(int i=0 ;i<size_x;i++ )
    {
     if( X_2_2[i]>0)
      X_2_2[i]=1;
      else  if( X_2_2[i]<0)
      X_2_2[i]=-1;
       else{ 
        if(H_X1<=H_X2 &&H_X1<=H_X3)
        X_2_2[i]=X1.get(i);
   else  if(H_X2<=H_X1 &&H_X2<=H_X3)
        X_2_2[i]=X2.get(i);
        else
         X_2_2[i]=X3.get(i);
       }
 
    } 
 System.out.println ();

     boolean check_X1=false,check_X2=false;
 for(int i=0;i<size_x;i++)
 {    
   if (X_1_1[i]==X_1_2[i])
  check_X1=true;
    else{
    check_X1=false;
     break;
    }
   
 }
 for(int i=0;i<size_x;i++)
 {  
     if (X_2_1[i] ==X_2_2[i])
  check_X1=true;
    else{
    check_X2=false;
    break;
    }
 }
 
 if(check_X1==true &&check_X2==true)
  break;
  counter ++;
  
  for(int i=0;i<size_x;i++){
    //  Xo[i]=;
      Xo.set(i, X_2_1[i]);
  }
  
  // break;
}
 
boolean check_X1=false,check_X2=false,check_X3=false ;

for(int i=0;i<size_x;i++)
{
   if (X_1_1[i]==X1.get(i))
  check_X1=true;
   else{
	   check_X1=false ;
	   break;
   }
}

 if (check_X1==false)  
  for(int i=0;i<size_x;i++)
{
   if (X_1_1[i]==X2.get(i))
  check_X2=true;
    else{
        check_X2=false;
        break;
      }   
}
if (check_X1==false&&check_X2==false)  
{ 
	check_X3=true;
}
int [] Res=new int[size_x];
 for(int j=0;j<size_x;j++)
  { 
	 if (X_1_1[j] == -1 )
	   Res[j] =0;
  else
	   Res[j]=255;
	 
	}


if(check_X1==true&&check_X2==false &&check_X3==false)
{   System.out.println("For recall X" );
 
    System.out.print("X1 = " + Names.get(0));
   /* for(int i=0;i<size_x;i++){
        System.out.print(X1.get(i) +"  ") ;
       // System.out.println() ; 
      
    }*/
 
    ImageProcessing imageRes= new ImageProcessing(ImagesNames.get(0));
    try {
		imageRes.getPixelArrayToBmpByteArray(Res, width, height, "1.bmp");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println() ; 
    
}
else if (check_X1==false&&check_X2==true &&check_X3==false) {
    System.out.println("For recall X" );

System.out.print("X2 = " + Names.get(1));
 
ImageProcessing imageRes= new ImageProcessing(ImagesNames.get(1));
try {
	imageRes.getPixelArrayToBmpByteArray(Res, width, height, "3.bmp");
} catch (Exception e) {

	e.printStackTrace();
}

    System.out.println() ; 
}

else if (check_X1==false&&check_X2==false &&check_X3==true){
    System.out.println("For recall X" );

System.out.print("X3 = " + Names.get(2));
   /* for(int i=0;i<size_x;i++){
        System.out.print(X3.get(i)+"  " ) ;
        //System.out.println() ; 
 
    }*/
ImageProcessing imageRes= new ImageProcessing(ImagesNames.get(2));
try {
	imageRes.getPixelArrayToBmpByteArray(Res, width, height, "8.bmp");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

    System.out.println() ; 
}


System.out.println() ; 
  
 /*int sum=0;
for(int i=0;i<size_x;i++){
    for (int j=0;j<size_x;j++)
    {
         sum+=Math.abs(W[i][j]);
    }
}
System.out.print("Lyapunaoun Energy= "+ -1*sum) ; 

int [] Sum=new int [size_x];

for (int i = 0; i < 1 ; i++) { // aRow
    for (int j = 0; j < size_x; j++) { // bColumn
        for (int k = 0; k < size_x; k++) { // aColumn
            Sum[j]+=Y1.get(k)* W[k][j] ;
        }
    }
}
System.out.println() ; 
int sum2=0;
for(int i=0;i<size_x;i++){
    sum2+=Math.abs(Sum[i]*X1.get(i));
    
}
System.out.print("Computational  Energy= "+ -1*sum2) ; 
System.out.println() ; 
*/
    }

}