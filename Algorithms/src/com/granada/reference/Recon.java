package com.granada.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Recon {

    private Map<String, PriorityQueue<String>> edges;
    private Map<String, String[]> edgeByOrder = new HashMap<String, String[]>();
    int num = 0;
    List<String> ret = new ArrayList<String>();
    boolean find = false;

     public List<String> findItinerary(String[][] tickets) {
    	 
      edges = new HashMap<String, PriorityQueue<String>>();
      for (String[] bd : tickets) {
    	  System.out.println("bd[0] - " + bd[0] + "- b[1] - " + bd[1]);
        if (!edges.containsKey(bd[0])) {
          edges.put(bd[0], new PriorityQueue<String>(10));
        }
        edges.get(bd[0]).offer(bd[1]);
      }
      num = tickets.length;

      for (String edge : edges.keySet()) {
        String[] arr = new String[edges.get(edge).size()];
        int i = 0;
        while (!edges.get(edge).isEmpty()) {
          arr[i++] = edges.get(edge).poll();
        }
        edgeByOrder.put(edge, arr);
      }

      List<String> path = new ArrayList<String>();
      path.add("JFK");
      dfs (path, "JFK");
      return ret;
    }

    private void dfs(List<String> path, String prev) {
      if (path.size() == num + 1) {
        for (String s : path) ret.add(s);
        find = true;
        return;
      }

      if (find || !edgeByOrder.containsKey(prev)) return;

      for (int i = 0; i < edgeByOrder.get(prev).length; i++) {
        if (find) break;
        if (edgeByOrder.get(prev)[i].length() != 0) {
          path.add(edgeByOrder.get(prev)[i]);
          String tmp = edgeByOrder.get(prev)[i];
          edgeByOrder.get(prev)[i] = "";
          dfs(path, tmp);
          edgeByOrder.get(prev)[i] = tmp;
          path.remove(path.size() - 1);
        }
      }
    }

    public static void main(String[] args) {
      Recon rc = new Recon();
      String[][] bds = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"ATL", "JFK"}, {"SFO", "ATL"}, {"ATL", "SFO"}};
      List<String> ret = rc.findItinerary(bds);
      for (String s : ret)  System.out.println(s);
    }
}