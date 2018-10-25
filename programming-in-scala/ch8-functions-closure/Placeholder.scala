someNumbers = [1,2,3,45,5,6, -11]

// different use cases of placeholder

// 1. type will be infered only in this case
someNumbers.filter(_>0)
// equivilent to 
someNumbers.filter(x => x>0)

// 2. short for parameters, type are required
val f = (_:Int) + (_:Int)


