mydata = read.table("data.txt")
# 1
mydata_2 = as.integer(mydata[,2] / 1000)
mydata_3 = as.integer(mydata[,3] / 1000)
# 2
data_range = as.integer(range(mydata_2))
data_mean = as.integer(mean(mydata_2))
data_var = as.integer(var(mydata_2))
data_sd = as.integer(sd(mydata_2))
data_min = as.integer(min(mydata_2))
data_max = as.integer(max(mydata_2))

print(data_range)
print(data_mean)
print(data_var)
print(data_sd)
print(data_min)
print(data_max)
# 3
breaks = seq(min(mydata_3)-1, max(mydata_3)+8, by=8)
mydata.cut = cut(mydata_3, breaks, right=FALSE)
high.freq = table(mydata.cut)
print(cbind(high.freq))

bmp(file="aa.bmp")
hist(mydata_3, breaks, col="lightgray", xlab="High", ylab="Count", main="Frequency", right=FALSE)
dev.off()
# 4
bmp(file="bb.bmp")
mydata_4 = mydata[1:100,4]
mydata_5 = mydata[1:100,5]
plot(cbind(mydata_4, mydata_5), xlab="High", ylab="Low", main="Scatter")
dev.off()
