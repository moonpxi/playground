manager <- c(1, 2, 3, 4, 5)
date <- c("10/24/08", "10/28/08", "10/1/08", "10/12/08", "5/1/09")
country <- c("US", "US", "UK", "UK", "UK")
gender <- c("M", "F", "F", "M", "F")
age <- c(32, 45, 25, 39, 99)
q1 <- c(5, 3, 3, 3, 2)
q2 <- c(4, 5, 5, 3, 2)
q3 <- c(5, 2, 5, 4, 1)
q4 <- c(5, 5, 5, NA, 2)
q5 <- c(5, 5, 2, NA, 1)
leadership <- data.frame(manager, date, country, gender, age,
                         q1, q2, q3, q4, q5, stringsAsFactors=FALSE)

# recode age
leadership$age[leadership$age == 99] <- NA

leadership <- within(leadership,{
  agecat <- NA
  agecat[age > 75]              <- "Elder"
  agecat[age >= 55 & age <= 75] <- "Middle Aged"
  agecat[age < 55]              <- "Young" })

# recode gender and country
leadership$gender <- factor(leadership$gender)
leadership$country <- factor(leadership$country)

# rename date
names(leadership)[2] <- "testDate"

# recode date
leadership$testDate <- as.Date(leadership$testDate, "%m/%d/%y")

# limit obs
startdate <- as.Date("2009-01-01")
enddate <- as.Date("2009-10-31")
someleads <- leadership[
    which(
      leadership$testDate >= startdate &
      leadership$testDate <= enddate), ]

# subsetting
otherleads <- subset(leadership, age >= 35 | age <= 24, select = c(manager, q1, q2))