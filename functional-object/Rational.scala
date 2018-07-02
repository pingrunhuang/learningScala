// notice the parameters are in the class declaration
class Rational(numerator : Int, denominator : Int){
    // check if the denominator is non zero
    // otherwise, throw java.lang.IllegalArgumentException
    require(denominator!=0)
    
    private val g = gcd(numerator, denominator)
    // assign to the class fields so that the methods could access
    val num = numerator / g 
    val denum = denominator / g

    // Auxiliary constructors: function overload
    def this(numerator: Int) = this(numerator, 1)

    // override method
    override def toString = num + "/" + denum
    
    def add(that : Rational):Rational = new Rational(that.denum * num + that.num * denum, that.denum * denum)
    // the return type could nothing, the scala compiler will infer 
    def lessThan(that : Rational):Boolean = num * that.denum < denum * that.num

    // usage of this: the first this could be omitted
    def max(that: Rational):Rational = if (this.lessThan(that)) that else this

    // private methods
    private def gcd(a: Int, b: Int):Int= {
        // a>b: a = q*b + r
        if(b==0) a else gcd(b, a%b)
    }

    // define operators
    def + (that: Rational):Rational = add(that)

    def * (that: Rational):Rational = new Rational(this.num * that.num, this.denum * that.denum)
}
