import random
import pandas as pd
import numpy as np 

def days(min_Temp, max_Temp, num_days):
	day =[]
	for i in range(num_days):
	    day.append(random.randrange(min_Temp,max_Temp
	    	,1))
	print (day)
	return day

def new_period(min_Temp, max_Temp, num_days):
	temps = []

	for i in range(24):
		temps.append(days(min_Temp, max_Temp, num_days))
	return temps

def date_gen(periods):
	times = pd.date_range(start='1/1/2018', periods=7)
	print(times)
	return times

def gen_csv(dates, temps):
	df = pd.DataFrame(data={"date": dates,
	 "t0": temps[0],
	 "t1": temps[1],
	 "t2": temps[2],
	 "t3": temps[3],
	 "t4": temps[4],
	 "t5": temps[5],
	 "t6": temps[6],
	 "t7": temps[7],
	 "t8": temps[8],
	 "t9": temps[9],
	 "t10": temps[10],
	 "t11": temps[11],
	 "t12": temps[12],
	 "t13": temps[13], 
	 "t14": temps[14],
	 "t15": temps[15],
	 "t16": temps[16],
	 "t17": temps[17],
	 "t18": temps[18],
	 "t19": temps[19],
	 "t20": temps[20],
	 "t21": temps[21],
	 "t22": temps[22],
	 "t23": temps[23]
	 })
	df.to_csv("./weatherData.csv", sep=',',index=False)

def main():
  dates = date_gen(7)
  print(len(dates))


  temps = new_period(-10, 25, 7)
  print(len(temps))
  for i in temps:
  	print(len(i))



 
  gen_csv(dates, temps)
  print("done")
  
if __name__== "__main__":
  main()






