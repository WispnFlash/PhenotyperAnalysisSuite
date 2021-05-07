import numpy as np
import pandas as pd
import math
import time
import os
import matplotlib.pyplot as plt		
import multiprocessing as mp		
import sys
import cv2 as cv
os.environ['R_HOME'] = 'C:\Program Files\R\R-3.6.3'
os.environ['R_USER'] = 'C:\Python37\Lib\site-packages\rpy2'
from rpy2.robjects import pandas2ri
pandas2ri.activate()
import rpy2.robjects as ro
import datetime as dt

import warnings
warnings.filterwarnings("ignore")

def CalculateAge(dateofbirth, rundate):
	months = 0.0
	try: 
		dob = dt.datetime(int(dateofbirth[6:10]), int(dateofbirth[0:2]), int(dateofbirth[3:5]))
		rd = dt.datetime(int(rundate[6:10]), int(rundate[0:2]), int(rundate[3:5]))
		duration = rd - dob
		days = duration.days
		months = int(days / 30)
	except:
		months = 0.0
	return months
	
def CalculateWeightChange(pre, post):
	percentweightchange = 0.00
	try :
		percentweightchange = -((pre-post)/pre)*100
	except ZeroDivisionError:
		percentweightchange = 0.00
	return percentweightchange

def Finish():
	maindiretory = "G:/Behavioral Data/Sonntag Lab Dropbox/Phenotyper/Investigators/"
	investigator = str(sys.argv[1])
	treatment = str(sys.argv[2])
	mouseID = str(sys.argv[3])
	directory0 = maindirectory + investigator + "/"
	group = treatment
	hourlydirectories = [directory0 + "Data/Distance moved/" + group + "/",
	directory0 + "Data/Feeding/" + group + "/",
	directory0 + "Data/Indexes/Cumulative/" + group + "/",
	directory0 + "Data/Indexes/Independent/" + group + "/"]
	
	etcdirectories = [directory0 + "Data/Entries to Criterion/Initial Discrimination/" + group + "/",
	directory0 + "Data/Entries to Criterion/Reversal/" + group + "/"]
	
	survplotdirectories = [directory0 + "Data/Initial Discrimination/" + group + "/",
	directory0 + "Data/Reversal/" + group + "/"]
	
	Strain = str(sys.argv[4])
	DOB = str(sys.argv[5])
	RD = str(sys.argv[6])
	AGE = str(sys.argv[7])
	CC = str(sys.argv[8])
	Gender = str(sys.argv[9])
	PRW = str(sys.argv[10])
	POW = str(sys.argv[11])
	WC = CalculateWeightChange(PRW, POW)
	Ph = str(sys.argv[12])

	columns = ["Investigator", "Strain", "DOB", "RunDate", "Age", "CageCard", "Gender", "PreWeight", "PostWeight", "%WeightChange", "PhenotyperID"]
	AdditionalDataforHourly = pd.DataFrame(np.concatenate([np.full(89, investigator).reshape(-1,1), np.full(89, Strain).reshape(-1,1), np.full(89, DOB).reshape(-1,1), np.full(89, RD).reshape(-1,1), np.full(89, Age).reshape(-1,1), np.full(89, CC).reshape(-1,1), np.full(89, Gender).reshape(-1,1), np.full(89, PRW).reshape(-1,1), np.full(89, POW).reshape(-1,1), np.full(89, WC).reshape(-1,1), np.full(89, Ph).reshape(-1,1)], axis=1))	
	AdditionalDataforETC = 	pd.DataFrame(np.concatenate([np.full(1, investigator).reshape(-1,1), np.full(1, Strain).reshape(-1,1), np.full(1, DOB).reshape(-1,1), np.full(1, RD).reshape(-1,1), np.full(1, Age).reshape(-1,1), np.full(1, CC).reshape(-1,1), np.full(1, Gender).reshape(-1,1), np.full(1, PRW).reshape(-1,1), np.full(1, POW).reshape(-1,1), np.full(1, WC).reshape(-1,1), np.full(1, Ph).reshape(-1,1)], axis=1))
	AdditionalDataforSurv = pd.DataFrame(np.concatenate([np.full(6000, investigator).reshape(-1,1), np.full(6000, Strain).reshape(-1,1), np.full(6000, DOB).reshape(-1,1), np.full(6000, RD).reshape(-1,1), np.full(6000, Age).reshape(-1,1), np.full(6000, CC).reshape(-1,1), np.full(6000, Gender).reshape(-1,1), np.full(6000, PRW).reshape(-1,1), np.full(6000, POW).reshape(-1,1), np.full(6000, WC).reshape(-1,1), np.full(6000, Ph).reshape(-1,1)], axis=1))

	for i in hourlydirectories:
		os.chdir(i)
		animals = os.listdir()
		for j in animals:
			if (str(j).find(ID) == 0):
				mouse = pd.read_csv(j)
				try:
					del mouse["Unnamed: 0"]
				except:
					print("Unnamed: 0 not present")
				try: 
					del mouse["Unnamed: 1"]
				except:
					print("Unnamed: 1 not present")
				mouse = pd.concat([mouse, AdditionalDataforHourly], axis=1)
				mouse.to_csv(j, index=False)
				del mouse
		
				
	for x in etcdirectories:
		os.chdir(x)
		animals = os.listdir()
		for y in animals:
			if (str(y).find(ID) == 0):
				mouse = pd.read_csv(y)
				try:
					del mouse["Unnamed: 0"]
				except:
					print("Unnamed: 0 not present")
				try: 
					del mouse["Unnamed: 1"]
				except:
					print("Unnamed: 1 not present")
				mouse = pd.concat([mouse, AdditionalDataforETC], axis=1)
				mouse.to_csv(y, index=False)
				del mouse
				
	for c in survplotdirectories:
		os.chdir(c)
		animals = os.listdir()
		for d in animals:
			if (str(d).find(ID) == 0):
				mouse = pd.read_csv(d)
				try:
					del mouse["Unnamed: 0"]
				except:
					print("Unnamed: 0 not present")
				try: 
					del mouse["Unnamed: 1"]
				except:
					print("Unnamed: 1 not present")
				mouse = pd.concat([mouse, AdditionalDataforSurv], axis=1)
				mouse.to_csv(d, index=False)
				del mouse

	return "done"
				
Finish()