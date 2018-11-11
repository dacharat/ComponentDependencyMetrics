data <- read.csv(file="./DependencyData.csv", header=T)
plot(data, xlim=c(0,1))
abline(1,-1)