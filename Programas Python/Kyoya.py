
# coding: utf-8

# In[6]:


matrix = [[0 for x in range(1001)] for y in range(1001)]
mod = 1000000007

def pascal():
    matrix[0][0]=1;
    for i in range(1001):
        for j in range(1001):
            if j==0 or j==i:
                matrix[i][j]=1
            else:
                matrix[i][j] = (matrix[i-1][j-1]+matrix[i-1][j])%mod

a = int(input())
b = []
for i in range(a):
    b.append(int(input()))
pascal()
r = 1
s = b[0]
for i in range(1,a):
    r = (r*matrix[s + b[i]-1][b[i]-1])%mod
    s += b[i]
print(r)

