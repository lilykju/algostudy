#8byte를 넘는 정수를 저장해야하는데 C++은 어려워서 파이썬으로 작성
#주어진 점화식 대로 코드 작성해서 해결
#시간복잡도 O(n)
#공간복잡도 ??

a,b,c = (input()).split()
a = int(a)
b = int(b)
c = int(c)

arr = [0 for _ in range(c)]
arr[0] = a
arr[1] = b

for i in range(2,c):
      arr[i] = arr[i-2] + arr[i-1]*arr[i-1]
print(arr[c-1])
