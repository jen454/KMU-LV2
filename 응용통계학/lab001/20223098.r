mydata = read.table("data0.txt")
print(nrow(mydata))
print(ncol(mydata))
L_1 = mydata[,2] >= mydata[,3] * 1.025
print(mydata[L_1,])
L_2 = mydata[,1] == "2023.08.25"
print(mydata[L_2,2])