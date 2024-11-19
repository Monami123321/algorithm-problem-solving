def get_gcd(a, b):
    while b != 0:
        tmp = a % b
        a = b
        b = tmp
    return a        
def solution(numer1, denom1, numer2, denom2):
    n = numer1 * denom2 + numer2 * denom1
    d = denom1 * denom2
    gcd = get_gcd(n, d)
    return [n // gcd, d // gcd]
    
    
