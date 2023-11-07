def solution(name, yearning, photo):
    answer = []

    pair = dict(zip(name, yearning))

    for i in range(len(photo)):
        answer1 = []
        for k in range(len(photo[i])):
            for j in range(len(name)):
                if (photo[i][k] == name[j]):
                    answer1.append(pair.get(name[j]))
        a = sum(answer1)
        answer.append(a)
        print(a)

    return answer