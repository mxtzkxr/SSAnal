package calculation.utils

fun comb(n: Int, k: Int) : Long{
    if(n < k){
        throw IllegalArgumentException("n < k")
    }
    return factorial(n) / (factorial(n - k) * factorial(k))
}

fun factorial(n: Int) : Long{
    if(n < 0){
        throw IllegalArgumentException("n < 0")
    }
    var result: Long = 1
    if(n == 0 || n == 1){
        return result
    }
    for(i in 2..n){
        result *= i
    }
    return result
}