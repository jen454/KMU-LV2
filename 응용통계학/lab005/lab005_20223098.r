mydata = read.table("data.txt")
colnames(mydata) = c("V1", "V2", "V3")
v3_lm = lm(V3 ~ V2, data = mydata)
summary_v3_lm = summary(v3_lm)

#1
print(nrow(mydata))

#2
alpha = round(summary_v3_lm$coefficients[1, 1], 3)
beta = round(summary_v3_lm$coefficients[2, 1], 3)
print(c(alpha, beta))

#3
p_value_alpha = round(summary_v3_lm$coefficients[1, 4], 3)
p_value_beta = round(summary_v3_lm$coefficients[2, 4], 3)
print(c(p_value_alpha, p_value_beta))

#4
r_squared = round(summary_v3_lm$r.squared, 3)
print(r_squared)

#5
newdata = data.frame(V2 = 70)
confidence_interval = predict(v3_lm, newdata, interval="confidence", level=0.95)
print(round(confidence_interval, 3))

#6
newdata = data.frame(V2 = 70)
predict_interval = predict(v3_lm, newdata, interval="predict", level=0.95)
print(round(predict_interval, 3))

#7
bmp(file="res.bmp")
v3_res = rstandard(v3_lm)
plot(mydata$V2, v3_res, ylab="Standardized Residual", xlab="V2", main="Standardized Residuals")
abline(0,0)
dev.off()