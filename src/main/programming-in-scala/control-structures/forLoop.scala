// for item in a list
val filesHere = (new java.io.File(".")).listFiles
for(file <- filesHere)
    println(file)


// range type
// include the upper bound
for (i <- 1 to 4)
    println("Iteration "+ i)
// not include the upper bound 
for (i<-0 until 4)
    println("Iteration "+i)

/*
the for (i<- 1 to 4)
is equal to (1).to(2) 

because the receiver of the method call which is (1) is specified explicitly, 
therefore the dot could be ignored 
what's more, the to method only takes in one parameters, so the parenthesis could also be ignored

*/


// filter
for (file <- filesHere if file.getName.endsWith(".scala"))
    println(file)


// producing new collection with yield
/* for clauses yield body */
def checkScala = for {
    file <- filesHere
    if file.getName.endsWith(".scala")
}yield file


// notice the difference between using {} and () is that, {} let you ignore the ";". However, using "()" reguire specifying ";" 
// between different statement