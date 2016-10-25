package edu.hit.ccf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class BMI {
	public static void main(String[] args) {
		//generateBMIData("bmi.txt");
		
		BMIstatics(calcBMI());
	}
	public static double[] calcBMI() {
		
		Vector<String[]> v= readFileByLines("bmi.txt");
		int N = v.size();
		double[] bmi = new double[N];
		double height=0.0,weight=0.0;
		String id="";
		double sum=0.0;
		for(int i=0;i<N;i++){
			id=v.get(i)[0];
			height=Float.parseFloat(v.get(i)[1]);
			weight=Float.parseFloat(v.get(i)[2]);
			bmi[i]= weight/(height*height);
			sum=sum+bmi[i];
			System.out.println("学号="+id+",身高="+height+",体重="+weight+",BMI="+bmi[i]);
		}
		double mean= sum/N;
		double variance =0.0;
		System.out.println("平均bmi为"+mean);
		for(int i=0;i<N;i++){
			variance=variance+(bmi[i]-mean)*(bmi[i]-mean);
		}
		variance=variance/N;
		double d = Math.sqrt(variance);
		System.out.println("bmi的标准方差为"+d);
		String s= String.format("%.2f,%.2f,%.2f,%.2f", mean-2*d,mean-d,mean+d,mean+2*d);
		System.out.println(s);
		return bmi;
	}
	public static void BMIstatics(double[] bmi) {
		int NumofStudent=0;
		int NumofGroup=9;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("输入学生人数:");
		NumofStudent=0;//sc.nextInt();
		//double[] bmi = new double[NumofStudent];
		//double[] bmi = {17.0,17.0,18.0,19,22,23,25,28,18.5,20,22,23,22.4,24.6,28.5,30.9,34,16.5,22.5,26.5,23.5,22.6};//new double[NumofStudent];
		
		NumofStudent= bmi.length;
		System.out.println("学生人数:"+NumofStudent);
		double min=0.0,max=0.0;
		for (int i=0;i<NumofStudent;i++){
			//bmi[i]=bmi();
			if(i==0){min=bmi[i];max=bmi[i];}
			else{
				if(min>bmi[i])min=bmi[i];
				if(max<bmi[i])max=bmi[i];
			}
		}
		System.out.println("min:"+min+" , max:"+max);
		double step = (max-min)/NumofGroup;
		int[] statics =new int[NumofGroup];
		double lower=0.0,upper=0.0;
		for(int i=0;i<NumofGroup;i++){
			for(int j=0;j<NumofStudent;j++){
				lower=min+i*step;
				upper=min+(i+1)*step;
				if(i==(NumofGroup-1))upper=max+1;
				if((bmi[j]>=lower) && (bmi[j]<upper)) statics[i]++;				
			}
			System.out.println("第"+(i+1)+"组人数:"+statics[i]);
		}
		
		
	}
	public static double bmi(){
		String studentID="";
		double height=0.0,weight=0.0;
		Scanner sc = new Scanner(System.in);
		System.out.println("输入学号:");
		studentID=sc.nextLine();
		System.out.println("输入体重(kg):");
		weight=sc.nextDouble();
		System.out.println("输入身高(m):");
		height=sc.nextDouble();
		double bmi = weight/(height*height);
		System.out.println(studentID+"的BMI为: "+bmi);
		return bmi;
	}
	
	public static Vector<String[]> readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        Vector<String[]> v= new Vector();
        try {

            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                //System.out.println("line " + line + ": " + tempString);
                String[] a= tempString.split(",");
                //System.out.println("学号:"+a[0]+",身高:"+a[1]+"m,体重:"+a[2]+"kg");
                v.add(a);
                line++;
            }
            reader.close();
            return v;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    return v;
                } catch (IOException e1) {
                }
            }
        }
		return v;
    }
	public static void generateBMIData(String fileName) {
		try {
            
            FileWriter writer = new FileWriter(fileName, false);
            Random r = new Random();
            double x=0.0,y=0.0;
            for(int i=0;i<500;i++){
            	x=r.nextGaussian();
            	y=x;//r.nextGaussian();

            	System.out.println(x);
            	writer.write(String.format("%04d,%.2f,%.2f\r\n", i,(1.75+x*0.1),(60.0+y*5)));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
