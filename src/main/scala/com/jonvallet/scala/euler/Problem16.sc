def pow (base: Int, n: Int) = (1 to n).map(BigInt(_)).fold (BigInt(1))((a,b) => a * BigInt(base))
def getSum(n: BigInt): BigInt = if (n == 0) 0 else n % 10 + getSum(n/10)

getSum(pow(2,1000))
