cachedFib = [0, 1]

def fibonacci(n):
    if n < len(cachedFib):
        return cachedFib[n]

    cachedFib.append(fibonacci(n - 1) + fibonacci(n - 2))

    return cachedFib[len(cachedFib) - 1]

print(fibonacci(0))
print(fibonacci(1))
print(fibonacci(2))
print(fibonacci(3))
print(fibonacci(50))
