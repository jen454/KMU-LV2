# 1
mtcars_ptm1 = mtcars$mpg[mtcars$am == 0]
res_1 = t.test(mtcars_ptm1, conf.level = 0.99)
print(c(res_1$conf.int[1], res_1$conf.int[2]))

#2
mtcars_ptm2 = mtcars$mpg[mtcars$am == 1]
res_2 = t.test(mtcars_ptm2, mu = 20, alternative = "greater", conf.level = 0.95)
print(res_2$p.value)

#3
mydata = read.table("data.txt")
col2 = mydata[,2]
col3 = mydata[,3]

res_a = t.test(col3, col2, paired = TRUE, conf.level = 0.95)
print(c(res_a$conf.int[1], res_a$conf.int[2]))

res_b = t.test(col3, col2, conf.level = 0.95)
print(c(res_b$conf.int[1], res_b$conf.int[2]))

L = (col3 > col2)
res_c = mydata[L,]
print(c(nrow(mydata), nrow(res_c)))

res_d = mean(col3 > col2)
print(res_d)

res_e = prop.test(sum(col3 > col2), n = nrow(mydata), conf.level = 0.95)
print(c(res_e$conf.int[1], res_e$conf.int[2]))