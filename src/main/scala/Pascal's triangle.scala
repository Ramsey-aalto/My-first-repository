

def bioCo( x:Int , y:Int):Int=
    if y > x then 0
    else if x == 1 || y == 0 then 1
    else if x == y then 1
    else bioCo(x-1,y-1)+bioCo(x-1,y)

def factorial(n:Int):Int= 

    var result = 1
    if n == 0 then 1
    else 
        for i <- 1 to n do
            result = result*i
    result

def bioCo2(n:Int,k:Int):Int =
    factorial(n)/(factorial(k)*factorial(n-k))


