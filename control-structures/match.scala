val fisrtArg = if (args.length > 0) args(0) else ""
fisrtArg match {
    case "salt" => println("1")
    case "chips" => println("asd")
    case "eggs" => println("fdsafdas")
    case _ => println("default")
}

// match could return a value
val firstArg = if (!args.isEmpty) args(0) else ""
val friend =
    firstArg match {
        case "salt" => "pepper"
        case "chips" => "salsa"
        case "eggs" => "bacon"
        case _ => "huh?"
    }

