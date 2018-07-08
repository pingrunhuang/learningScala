abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Int) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: String, right: Expr) extends Expr

// 1. constructing case class
val v = Var('x')
val op = BinOp("+", Number(1), v)

// 2. arguments accession
v.name

// 3. toString, hashCode and equals contains 
println(v)
println(op.right == Var('x')) // true

// 4. copy method
val newOp = op.copy(operator="-")

// pattern matching
def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e // double negation
    case BinOp("+", e, Number(0)) => e // adding zero
    case BinOp("+", e, Number(1)) => e // adding 1  
    case _ => expr // this is necessary for default situation, otherwise, MatchError exception will be thrown
}

// different kinds of patterns

// wildcard
def matchBinOp(expr: Expr) = expr match {
    case BinOp(_,_,_) => println(expr + "is an binary operation")
    case _ => // empty return 
}

// constant pattern

// constructor pattern: deep matching

// sequence pattern
expr match {
    case List(0, _*) => println("Matching lists starting with 0 and have any number of elements")
}

// tuple patterns

// typed patterns
def generalSize(x: Any): Int = x match {
    case s: String => s.length
    case m: Map[_,_] => m.size
    case _ => -1
}

// pattern guards
def simplifyAdd(e: Expr):Expr = e match {
    case BinOp("+", x, x) => BinOp("*", x, Number(2))
    case _ => e
}
// <console>:11: error: x is already defined as value x case BinOp("+", x, x) => BinOp("*", x, Number(2))

def simplifyAdd(e: Expr):Expr = e match {
    case BinOp("+", x, y) if x==y => BinOp("*", x, Number(2))
    // match only positive integers
    case n:Int if 0<n => ...
    case _ => e
}

// sealed class: the sealed keyword is lisence to pattern matching. To get rid of not finding default pattern match
sealed abstract class Expr
case class Var(name:String) extends Expr
case class Number(num:Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr


// case sequences as partial functions
val withDefault: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
} 