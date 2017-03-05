/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Queue;

/**
 *
 * @author accer
 */
public class Graphs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        grahh gra=new grahh();
        gra.addVertex('A');
        gra.addVertex('B');
        gra.addVertex('C');
        gra.addVertex('D');
        gra.addVertex('E');
        gra.addVertex('F');
        gra.addEdge(0, 1);
        gra.addEdge(0, 2);
        gra.addEdge(0, 4);
        gra.addEdge(1, 0);
        gra.addEdge(1, 5);
        gra.addEdge(2, 0);
        gra.addEdge(2, 3);
        gra.addEdge(2, 4);
        gra.addEdge(3, 2);
        gra.addEdge(0, 1);
        gra.addEdge(4, 0);
        gra.addEdge(4, 2);
        gra.addEdge(4, 5);
        gra.addEdge(5, 1);
        gra.addEdge(5, 4);
//        gra.dislayLab(0);
//        gra.dislayLab(5);
       gra.Bfs();
       System.out.print("values") ;
//       gra.Dfs(0);
    }
    
}
class vertex{
        public char label;
        public boolean visited;
        public vertex(char label){
            this.label=label;
            visited=false;
        }
    }
 class grahh{
        private final int maxVertex=20;
        private vertex verticesList[];
        private int adjMat[][];
        private Stack stackGra;
        private int vertexCount;
        public grahh(){
            verticesList=new vertex[maxVertex];
            vertexCount=0;
            adjMat =new int[maxVertex][maxVertex];
            for(int i=0;i<maxVertex;i++){
                for(int j=0;j<maxVertex;j++){
                    adjMat[i][j]=0;
                }
            }
            stackGra =new Stack();
        }
        public void addVertex(char lab){
            verticesList[vertexCount++]=new vertex(lab);
        }
        public void addEdge(int source, int dest){
            adjMat[source][dest]=1;
            adjMat[dest][source]=1;
        }
        public void dislayLab(int v){
            System.out.println(verticesList[v].label);
        }
        public void Bfs(){
            dislayLab(0);
            Queue que=new Queue();
             que.enqueue(0);
             verticesList[0].visited=true;
             while(!que.isEmpty()){
                try {
                    int x=(int)que.dequeue();
                    for(int i=0; i<vertexCount; i++){
                        if(adjMat[x][i]==1)
                        {
                            if(verticesList[i].visited==false)
                            {
                                verticesList[i].visited=true;
                                dislayLab(i);
                                que.enqueue(i);
                            }
                        }
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(grahh.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
            
        }
        public void Dfs(int v){
            stackGra.push(v);
            dislayLab(v);
            verticesList[v].visited=true;
            for(int i=0;i<vertexCount;i++){
                if(adjMat[v][i]==1){
                    if(verticesList[i].visited==false){
                        verticesList[i].visited=true;
                        Dfs(i);
                    }
                    
                }
            }
        }
        
        
    }
