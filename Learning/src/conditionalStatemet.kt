fun ifasExpression(a:Int,b:Int){
	val maxVal = if(a>b){
					a
				}else
					b
	println(maxVal)
}

fun whenAsExpression(a:Int){
	val value = when(a){
		in 1..10 -> "one to ten"
		2 -> "two"
		3, 22 -> "three"
		 else -> "other"
	}
	println("In when as expression $value")
}

fun funcAsExpression(a:Int,b:Int):Int = if(a>b) a else b

fun main(args:Array<String>){
	var a:Int = 5
	var b:Int = 100
	//ifasExpression(a,b)
	//whenAsExpression(a)
	println(funcAsExpression(a,b))
}