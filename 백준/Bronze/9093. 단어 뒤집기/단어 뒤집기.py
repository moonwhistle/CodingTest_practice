t = int(input())

for i in range(t):
   sen = input().split()
   mer = []
   for j in range(len(sen)):
      mer.append(sen[j][::-1])
      join_sen = " ".join(mer)
   print(join_sen)
   
   