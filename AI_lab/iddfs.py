from collections import defaultdict 

class Graph: 
  
    def __init__(self,vertices): 
        self.V = vertices 
        self.graph = defaultdict(list) 
  
    def addEdge(self,u,v): 
        self.graph[u].append(v) 

    def DLS(self,src,target,maxDepth): 
  
        if src == target : return True
  
        if maxDepth <= 0 : return False
  
        for i in self.graph[src]: 
                if(self.DLS(i,target,maxDepth-1)): 
                    return True
        return False
  
    def IDDFS(self,src, target, maxDepth): 
  
        for i in range(maxDepth): 
            if (self.DLS(src, target, i)): 
                return True
        return False
   


n = int(input("Enter number of nodes in graph:"))
g = Graph (n);
e = int(input("Enter number of edges:"))
for i in range(e):
    x, y = [int(x) for x in input("Enter edges a->b: ").split()]
    g.addEdge(x,y)

target = int(input("Enter target:"))
maxDepth = int(input("Enter maxDepth:"))
src = int(input("Enter source:"))
  
if g.IDDFS(src, target, maxDepth) == True: 
    print ("Target is found from source in the given depth") 
else : 
    print ("Target is not found from source in the given depth")


