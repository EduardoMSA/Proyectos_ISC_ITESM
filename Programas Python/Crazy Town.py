
# coding: utf-8

# In[4]:


def getToU(hauseX, hauseY, uX, uY):
    nOfRoads = int(input())
    moves = 0
    for i in range(nOfRoads):
        road = list(map(int,input().split()))
        s = road[0]*hauseX + road[1]* hauseY + road[2]
        e = road[0]*uX + road[1]* uY + road[2]
        if(s>0 and e<0)or(s<0 and e>0):
            moves+=1
    return moves

hause = list(map(int,input().split()))
university = list(map(int,input().split()))
print(getToU(hause[0], hause[1], university[0], university[1]))
    

