while True:
    try:
        n = int(input())
        result = 1

        while True:
            if result % n == 0:
                print(len(str(result)))
                break
            result = result * 10 + 1
    except:
        break