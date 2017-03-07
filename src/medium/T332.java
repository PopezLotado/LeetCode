package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @Title Reconstruct Itinerary
 * @Description Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 * @author Potato
 *
 */
public class T332 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [][] tickets={{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
		String [][] tickets2={{"JFK","ABC"},{"JFK","BBC"},{"BBC","JFK"}};
		T332 t332=new T332();
		t332.findItinerary(tickets2).forEach(System.out::println);;
	}
	String result=null;
    Map<String, List<String>> map=new HashMap<String, List<String>>();
    int c;
//	public List<String> findItinerary(String[][] tickets) {
//        List<String> res=new ArrayList<>();
//        c=tickets.length+1;
//        for(int i=0;i<tickets.length;i++){
//        	if(map.containsKey(tickets[i][0])){
//        		map.get(tickets[i][0]).add(tickets[i][1]);
//        	}else {
//				List<String> list=new LinkedList<>();
//				list.add(tickets[i][1]);
//				map.put(tickets[i][0], list);
//			}
//        }
//        String current="JFK";
//        route(current, "JFK,");
//        String [] ts=result.split(",");
//        for (String string : ts) {
//			res.add(string);
//		}
//        return res;
//    }
//	public void route(String current,String res){
//		List<String> des=map.get(current);
//		if(des==null || des.size()==0){
//			if(res.length()==c*4){
//				if(result==null)
//					result=res;
//				else if(res.compareTo(result)<0)
//					result=res;
//			}
//			return;
//		}
//		for(int i=0;i<des.size();i++){
//			String to=des.get(i);
//			des.remove(i);
//			res+=to+",";
//			route(to,res);
//			res=res.substring(0, res.length()-4);
//			des.add(i, to);
//		}
//	}
    public List<String> findItinerary(String[][] tickets) {
        List<String> ans = new ArrayList<String>();
        if(tickets == null || tickets.length == 0) return ans;
        Map<String, PriorityQueue<String>> ticketsMap = new HashMap<>();
        for(int i = 0; i < tickets.length; i++) {
            if(!ticketsMap.containsKey(tickets[i][0])) ticketsMap.put(tickets[i][0], new PriorityQueue<String>());
            ticketsMap.get(tickets[i][0]).add(tickets[i][1]);
        }

        String curr = "JFK";
        Stack<String> drawBack = new Stack<String>();
        for(int i = 0; i < tickets.length; i++) {
            while(!ticketsMap.containsKey(curr) || ticketsMap.get(curr).isEmpty()) {
                drawBack.push(curr);
                curr = ans.remove(ans.size()-1);
            }
            ans.add(curr);
            curr = ticketsMap.get(curr).poll();
        }
        ans.add(curr);
        while(!drawBack.isEmpty()) ans.add(drawBack.pop());
        return ans;
    }

}
