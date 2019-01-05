# Different between case class and normal class

1. You can do pattern matching on it
2. You can construct instances of these classes without using the new keyword
3. All constructor arguments are accessible from outside using automatically generated accessor functions
4. The `toString` method is automatically redefined to print the name of the case class and all its arguments
5. The `equals` method is automatically redefined to compare two instances of the same case class structurally rather than by identity
6. The `hashCode` method is automatically redefined to use the hashCodes of constructor arguments.