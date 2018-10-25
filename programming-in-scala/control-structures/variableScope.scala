// one difference 
val a = 1;
{
    val a = 2 // Compiles just fine
    println(a) 
}
println(a)
// because the 2 `a` is in the different scope, scala compiler allows you to define 2 identical name
// result: 
// 2 
// 1

// this won't work
val a = 1
val a = 2 // Does not compile
println(a)

