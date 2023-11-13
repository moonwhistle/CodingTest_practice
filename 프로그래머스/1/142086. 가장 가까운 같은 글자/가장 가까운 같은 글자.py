def solution(s):
    new_s = []
    answer = []
    s = list(s)

    for i in range(len(s)-1, -1, -1):
        cnt = 0

        for k in range(i-1, -1, -1):
            if (s[i] == s[k]):
                new_s.append(i-k)
                cnt += 1
                break
        if (cnt == 0):
            new_s.append(-1)

    for i in reversed(new_s):
        answer.append(i)

    return answer