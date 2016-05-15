package com.granada.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Iteniary_dfs_search {

	
	    int[][] routes;
	    Map<String, Integer> indexMap = new HashMap<String, Integer>();
	    String[] ports;
	    List<String> ans = null;
	    int ticketNum = 0;
	    int portNum = 0;
	  
	    public List<String> findItinerary(String[][] tickets) {
	      
	        int i = 0;
	        for (String[] ticket : tickets) {
	            if (!indexMap.containsKey(ticket[0])) {
	                indexMap.put(ticket[0], i++);
	            }
	            if (!indexMap.containsKey(ticket[1])) {
	                indexMap.put(ticket[1], i++);
	            }
	        }
	      
	        portNum = indexMap.size();
	        routes = new int[portNum][portNum];
	        ports = new String[portNum];
	        for (String[] ticket : tickets) {
	            routes[indexMap.get(ticket[0])][indexMap.get(ticket[1])] = 1;
	            ports[indexMap.get(ticket[0])] = ticket[0];
	            ports[indexMap.get(ticket[1])] = ticket[1];
	        }
	        ticketNum = tickets.length;
	      
	        ArrayList<String> path = new ArrayList<String>();
	        path.add("JFK");
	        dfs(path, indexMap.get("JFK"));
	      
	        return ans;
	    }
	  
	    private void dfs(List<String> path, int lastPort) {
	        if (path.size() == ticketNum) {
	            if (ans == null || compare(ans, path)) {
	                ans = new ArrayList<String>();
	                ans.addAll(path);
	            }
	            return;
	        }
	      
	        for (int i = 0; i < portNum; i++) {
	            if (routes[lastPort][i] == 1) {
	                path.add(ports[i]);
	                routes[lastPort][i] = 0;
	                dfs(path, i);
	                routes[lastPort][i] = 1;
	                path.remove(ports[i]);
	            }
	        }
	    }
	  
	    private boolean compare(List<String> a, List<String> b) {
	        for (int i = 0; i < a.size(); i++) {
	            if (a.get(i).compareTo(b.get(i)) > 0) {
	                return true;
	            } else if (a.get(i).compareTo(b.get(i)) < 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    public static void main(String[] args) {
	    	      Iteniary_dfs_search rc = new Iteniary_dfs_search();
	    	      String[][] bds = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"ATL", "JFK"}, {"SFO", "ATL"}, {"ATL", "SFO"}};
	    	      List<String> ret = rc.findItinerary(bds);
	    	      for (String s : ret)  System.out.println(s);
	    	    }
}
