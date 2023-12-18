//package Kruskal;
//
//import java.util.List;
//import java.util.Collections;
//import java.util.Queue;
//import java.util.LinkedList;
//
//public class SpanningTreeBuilder {
//     // Kruskal Method
//     public SpanningTree build(Graph graph, int source) {
//         // 구현하기
//         // source 의 경우 시작점으로 시작하는 경우 사용
//         // 그렇지 않은 경우, 첫 번째 SpanningTree의 속하는 정점 중에 선택
//
//         boolean visited[] = new boolean[graph.size];
//         int disjoint[] = new int[graph.size];
//         SpanningTree tree = new SpanningTree(graph.size);
//         for(int v = 0; v < graph.size; v++) disjoint[v] = v;
//
//     List<Edge> edges = graph.getEdges();
//     Collections.sort(edges, (e1,e2) -> {
//         return e1.weight - e2.weight;
//     });
//
//         for(int i = 0; i < edges.size(); i++){
//             Edge select = edges.get(i);
//             int a = find(select.start, disjoint); int b = find(select.end, disjoint);
//             if(a == b) continue;
//             union(a, b, disjoint);
//             tree.add(select.start, select.end, select.weight);
//         }
//
//         return tree;
//     }
//
//    public SpanningTree build(Graph graph, int source){
//        boolean visited[] = new boolean[graph.size];
//        SpanningTree tree = new SpanningTree(graph.size);
//         Queue<Integer> edges = new LinkedList<>();
//
//         edges.add(source);
//         while(!edges.isEmpty()){
//             int vertex = edges.remove();
//             visited[vertex] = true;
//             int next = -1;
//             int w = 9999;
//             for(int e = 0; e < graph.size; e++){
//                 if(visited[e]){
//                     for(int i = 0; i < graph.size; i++){
//                         if(graph.am[e][i] < 9999 && visited[i] == false){
//                             if(graph.am[e][i] < w){
//                                 next = i;
//                                 w = graph.am[e][i];
//                             }
//                         }
//                     }
//                 }
//             }
//             if(next == -1) break;
//             tree.add(vertex, next, w);
//             edges.add(next);
//         }
//
//     int find(int v, int[] disjoint){
//         if(v == disjoint[v]) return v;
//         disjoint[v] = find(disjoint[v], disjoint);
//         return disjoint[v];
//     }
//     void union(int v1, int v2, int[] disjoint){
//         int r1 = find(v1, disjoint);
//         int r2 = find(v2, disjoint);
//         if(r1 == r2) return;
//         disjoint[r1] = r2;
//     }
//}
//
