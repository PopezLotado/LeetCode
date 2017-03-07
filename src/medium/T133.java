package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title Clone Graph
 * @Description Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 * @author Potato
 *
 */
public class T133 {

	Map<Integer, UndirectedGraphNode> map=new HashMap<Integer,UndirectedGraphNode>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		map.clear();
		if(node==null) 
			return null;
		else 
			return getNode(node.label, node);
    }
	public UndirectedGraphNode getNode(int label,UndirectedGraphNode c){
		if(map.get(label)!=null)
			return map.get(label);
		UndirectedGraphNode ugn=new UndirectedGraphNode(label);
		map.put(label, ugn);
		for (UndirectedGraphNode u : c.neighbors) {
			ugn.neighbors.add(getNode(u.label, u));
		}
		return ugn;
	}
}
class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };
