# Summary
What this repo 

## Scary annotations in Scala

#### colon <:>
* function that take a seq as parametes: `def f(ys: String*):String = ys.foreach(println)`
* how to call this func: `f(x: _*)` where the `x` is actually a collection such as `List` or `Seq`.


#### uniform access principle
invoking parameterless method withou parentheses can either call the function literal `val` or the method `def`. This way the client code does not need to modify even the source code change from `def` to `val` or the other way. 


#### use transient lazy val for efficient serialization task