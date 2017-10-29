def min_change(V, C):
    def min_coins(i, aC):
        if aC == 0:
            return 0
        elif i == -1 or aC < 0:
            return float('inf')
        else:
            return min(min_coins(i-1, aC), 1 + min_coins(i, aC-V[i]))
    return min_coins(len(V)-1, C)
